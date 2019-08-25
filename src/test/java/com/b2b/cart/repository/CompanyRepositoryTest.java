package com.b2b.cart.repository;

import com.b2b.cart.CartApplication;
import com.b2b.cart.models.corporate.Company;
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

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.nio.charset.Charset.forName;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = CartApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CompanyRepositoryTest {

    @Autowired
    private CompanyRepository companyRepository;
    private EasyRandom factory;

    @Test
    public void testCountryRepositoryNotNUll() {
        Assert.assertNotNull(companyRepository);
    }

    @Test
    public void testFindAll() {

        List<Company> carts = IntStream.range(1, 10).mapToObj(e ->


                this.companyRepository.save(factory.nextObject(Company.class))


        ).collect(Collectors.toList());


        Assert.assertEquals(carts.size(), ((Collection<?>) this.companyRepository.findAll()).size());


    }

    @Before
    public void setUp() throws Exception {
        EasyRandomParameters parameters = new EasyRandomParameters()
                .seed(123L)
                .objectPoolSize(100)
                .randomizationDepth(3)
                .charset(forName("UTF-8"))
                .stringLengthRange(5, 50)
                .collectionSizeRange(1, 10)
                .scanClasspathForConcreteTypes(true)
                .overrideDefaultInitialization(false)
                .ignoreRandomizationErrors(true);
        factory = new EasyRandom(parameters);


    }

    @Test
    public void testDelete() {


        Company pojo = factory.nextObject(Company.class);
        pojo.setId(null);
        pojo = this.companyRepository.save(pojo);

        Long iD = pojo.getId();
        this.companyRepository.delete(pojo);
        Assert.assertFalse(this.companyRepository.findById(iD).isPresent());

    }


    @Test
    public void testSave() {
        Company pojo = factory.nextObject(Company.class);
        pojo.setId(null);
        pojo.setSeq(0);
        Company dbPojo = this.companyRepository.save(pojo);
        System.out.println(pojo);

        Assert.assertNotNull(dbPojo.getId());
    }


    @After
    public void tearDown() throws Exception {
        this.companyRepository.deleteAll();
    }
}