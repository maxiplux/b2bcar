package com.b2b.cart.services;


import com.b2b.cart.models.items.Item;
import com.b2b.cart.repository.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDao productRepository;

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


    @Override
    public Boolean deleteProductById(long id) {
        return this.productRepository.deleteById(id);
    }

    @Override
    public Optional<Item> findById(long id) {
        return this.productRepository.findById(id);
    }
}