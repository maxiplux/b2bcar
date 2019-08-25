package com.b2b.cart.services.impl;

import com.b2b.cart.models.corporate.Company;
import com.b2b.cart.models.items.Category;
import com.b2b.cart.repository.CategoryRepository;
import com.b2b.cart.repository.CompanyRepository;
import com.b2b.cart.services.CategoryServices;
import com.b2b.cart.services.CompanyServices;
import com.b2b.cart.services.generics.CrudServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
public class CategoryServicesImpl extends CrudServicesImpl<Category> implements CategoryServices<Category> {

    @Autowired
    private CategoryRepository categoryRepository;


    @PostConstruct
    public  void posContructor() {
        this.setRepository( categoryRepository);
    }


    public Optional<Category> UpdateById(long id, Category element) {
        Optional<Category> optionalCurrentCompany = this.repository.findById(id);
        if (optionalCurrentCompany.isPresent()) {
            Category currentProduct = optionalCurrentCompany.get();

            if (element.getName() != null) {
                currentProduct.setName(element.getName());
            }


            return Optional.of((Category) this.repository.save(currentProduct));
        }
        return Optional.empty();

    }


}
