package com.b2b.cart.controllers;

import com.b2b.cart.controllers.generics.CrudController;
import com.b2b.cart.models.corporate.Company;
import com.b2b.cart.models.items.Category;
import com.b2b.cart.services.CategoryServices;
import com.b2b.cart.services.CompanyServices;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/v1/categories")
@Data
public class CategoryController extends CrudController<Category> {

    @Autowired
    CategoryServices categoryServices;

    @PostConstruct
    public  void posContructor() {
        this.service = categoryServices;
    }

}
