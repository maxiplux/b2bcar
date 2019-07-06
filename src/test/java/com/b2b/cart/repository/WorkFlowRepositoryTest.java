package com.b2b.cart.repository;

import com.b2b.cart.CartApplication;
import com.b2b.cart.models.workflow.WorkFlow;
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

import static java.nio.charset.Charset.forName;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CartApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WorkFlowRepositoryTest {

    @Autowired
    private WorkFlowRepository workFlowRepository;
    private EasyRandom factory;

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
    public void testCountryRepositoryNotNUll() {
        Assert.assertNotNull(this.workFlowRepository);
    }

    @Test
    public void testSave() {
        WorkFlow pojo = factory.nextObject(WorkFlow.class);
        pojo.setWorkFlowId(null);
        pojo.setSteps(2);
        pojo = this.workFlowRepository.save(pojo);


        Assert.assertNotNull(pojo.getWorkFlowId());
    }

    @After
    public void tearDown() throws Exception {
        this.workFlowRepository.deleteAll();
    }
}