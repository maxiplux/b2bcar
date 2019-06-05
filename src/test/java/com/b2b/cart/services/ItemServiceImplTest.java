package com.b2b.cart.services;

import com.b2b.cart.models.items.Item;
import com.b2b.cart.repository.ItemRepository;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static java.nio.charset.Charset.forName;
import static org.powermock.api.mockito.PowerMockito.when;

//https://medium.com/@kamath.praveen1992/powermockito-in-springboot-574857b19f60
@SpringBootTest
@RunWith(SpringRunner.class)
@PrepareForTest({ItemServiceImpl.class})
public class ItemServiceImplTest {


    @Mock
    private ItemRepository itemRepository;
    @InjectMocks
    private ItemServiceImpl itemService = new ItemServiceImpl();
    private EasyRandom factory;


    public ItemServiceImplTest() {
    }

    @Before
    public void setUp() {


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

    @After
    public void tearDown() {
        itemService = null;
    }

    @Test
    public void testServiceNotNull() {
        Assert.assertNotNull(itemService);

    }


    @Test
    public void updateProductById() throws Exception {
        Item product = factory.nextObject(Item.class);
        product.setId(1L);
        when(itemRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(product));
        when(itemRepository.save(Mockito.any(Item.class))).thenReturn(product);

        final ItemServiceImpl spiedItemService = PowerMockito.spy(itemService);


        //PowerMockito.doReturn(9).when(spiedItemService, "suma", ArgumentMatchers.anyLong(), ArgumentMatchers.anyLong() );

        //PowerMockito.doReturn(9).when(spiedItemService,method(ItemServiceImpl.class, "suma", Long.class, Long.class)).withArguments(ArgumentMatchers.anyLong(), ArgumentMatchers.anyLong());


        final Integer entero = Whitebox.invokeMethod(spiedItemService, "suma", ArgumentMatchers.anyLong(), ArgumentMatchers.anyLong(), 9);


        Assert.assertTrue(spiedItemService.updateProductById(1, product).isPresent());
    }


}