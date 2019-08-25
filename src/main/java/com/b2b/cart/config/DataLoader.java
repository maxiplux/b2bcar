package com.b2b.cart.config;

import com.b2b.cart.models.items.Category;
import com.b2b.cart.models.items.Item;
import com.b2b.cart.models.users.Role;
import com.b2b.cart.models.users.RoleName;
import com.b2b.cart.models.users.User;
import com.b2b.cart.repository.CategoryRepository;
import com.b2b.cart.repository.ItemRepository;
import com.b2b.cart.repository.RoleRepository;
import com.b2b.cart.repository.UserRepository;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
@Transactional
public class DataLoader implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Autowired
    private ItemRepository itemRepository;

    private EasyRandom factory;

    private User user;
    private Category category;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.createFactory();
        this.createUser();
        this.createCategory();
        this.createItems();


    }

    private void createFactory() {
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

    private void createItems() {
        this.itemRepository.saveAll(
                IntStream.range(1, 10).mapToObj(e ->
                        {
                            Item item = factory.nextObject(Item.class);
                            item.setPrice(1000d);
                            item.setQuality(1000d);
                            return item;

                        }

                ).map(item -> {
                    item.setCategory(this.category);
                    return item;
                }).collect(Collectors.toSet())
        );

    }

    private void createCategory() {
        Category category = new Category();
        category.setName("General");
        this.category = this.categoryRepository.save(category);

    }

    private void createUser() {
        User user = new User();
        roleRepository.save(new Role(RoleName.ROLE_USER));
        roleRepository.save(new Role(RoleName.ROLE_ADMIN));
        user.setPassword(passwordEncoder.encode("12345"));
        user.setUsername("admin");
        user.setEnabled(true);
        user.setRoles((List<Role>) this.roleRepository.findAll());

        this.userRepository.save(user);


    }
}

