package com.b2b.cart.controllers;

import com.b2b.cart.controllers.generics.CrudController;
import com.b2b.cart.models.corporate.Company;
import com.b2b.cart.services.CompanyServices;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/v1/companies")
@Data
public class CompanyController extends CrudController<Company> {
    @Autowired
    CompanyServices companyServices;

    @PostConstruct
    public  void posContructor() {
        this.service = companyServices;
    }

}
