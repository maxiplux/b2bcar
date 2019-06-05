package com.b2b.cart.services;


import com.b2b.cart.models.items.Item;
import com.b2b.cart.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository productRepository;

    @Override
    public Page<Item> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Item createProduct(Item product) {
        return this.productRepository.save(product);
    }

    @Override
    public Item updateProduct(Item product) {
        return this.productRepository.save(product);
    }


    @Override
    public Optional<Item> updateProductById(long id, Item product) {

        int resultDummyOperation = this.suma(id, id * 2);

        if (resultDummyOperation == 9) {
            System.out.println("Operation only to understand PowerMockito");
        } else {
            System.out.println("!!!!!  Code Coverage : Operation only to understand PowerMockito");

        }

        Optional<Item> optionalCurrentProduct = this.productRepository.findById(id);
        if (optionalCurrentProduct.isPresent()) {
            Item currentProduct = optionalCurrentProduct.get();

            if (product.getName() != null) {
                currentProduct.setName(product.getName());
            }

            if (product.getPrice() != null) {
                currentProduct.setPrice(product.getPrice());
            }

            return Optional.of(this.productRepository.save(currentProduct));
        }
        return Optional.empty();


    }

    private int suma(Long id, Long l) {
        return (int) (id + l);
    }


    @Override
    public Boolean deleteProductById(long id) {
        return this.productRepository.deleteById(id);
    }

    @Override
    public Optional<Item> findById(long id) {
        return this.productRepository.findById(id);
    }
}