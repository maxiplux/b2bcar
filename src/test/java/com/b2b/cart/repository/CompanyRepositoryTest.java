package com.b2b.cart.repository;

import com.b2b.cart.CartApplication;
import com.b2b.cart.models.corporate.Company;
import com.b2b.cart.models.corporate.Holding;
import com.b2b.cart.models.generic.Address;
import com.b2b.cart.models.users.User;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = CartApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CompanyRepositoryTest {

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private UserRepository userRepository;
    private EasyRandom factory;

    @Test
    public void testCountryRepositoryNotNUll() {
        Assert.assertNotNull(companyRepository);
    }

    private User user;

    @Test
    public void testFindAll() {
        Holding holding = factory.nextObject(Holding.class);
        holding.setMananger(user);
        Address address = factory.nextObject(Address.class);

        List<Company> companies = IntStream.range(1, 10).mapToObj(e ->


                {
                    Company company = factory.nextObject(Company.class);
                    company.setManager(user);
                    company.setHolding(holding);
                    company.setPrimaryPhone("16414517283");
                    company.setEmail("maxiplux@gmail.com");
                    company.setPrimaryAddress(address);
                    return company;
                }


        ).map(el ->
                {
                    int k = 9;
                    return this.companyRepository.save(el);
                }
        ).collect(Collectors.toList());


        Assert.assertEquals(companies.size(), ((Collection<?>) this.companyRepository.findAll()).size());


    }

    @Before
    public void setUp() throws Exception {
        this.userRepository.findAll().forEach(user1 -> {
            this.user = user1;
        });
        EasyRandomParameters parameters = new EasyRandomParameters()
                .seed(123L)
                .objectPoolSize(100)
                .randomizationDepth(3)
                .charset(StandardCharsets.UTF_8)
                .stringLengthRange(5, 50)
                .collectionSizeRange(1, 10)
                .scanClasspathForConcreteTypes(true)
                .overrideDefaultInitialization(false)
                .ignoreRandomizationErrors(true);
        factory = new EasyRandom(parameters);



    }

    @Test
    public void testDelete() {


        Company company = factory.nextObject(Company.class);
        company.setId(null);


        company.setEmail("maxiplux@gmail.com");
        company.setPrimaryPhone("16414517283");
        company.setManager(user);
        company.setSeq(0);

        company = this.companyRepository.save(company);

        Long iD = company.getId();
        this.companyRepository.delete(company);
        Assert.assertFalse(this.companyRepository.findById(iD).isPresent());

    }


    @Test
    public void testSave() {
        Company company = factory.nextObject(Company.class);
        company.setId(null);
        company.setEmail("maxiplux@gmail.com");
        company.setPrimaryPhone("16414517283");
        company.setManager(user);
        company.setSeq(0);
        Company dbPojo = this.companyRepository.save(company);
        System.out.println(company);

        Assert.assertNotNull(dbPojo.getId());
    }


    @After
    public void tearDown() throws Exception {
        this.companyRepository.deleteAll();
    }
}