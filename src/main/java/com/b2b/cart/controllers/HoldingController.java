package com.b2b.cart.controllers;

import com.b2b.cart.controllers.generics.CrudController;
import com.b2b.cart.models.corporate.Company;
import com.b2b.cart.services.HoldingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/v1/holdings")
public class HoldingController extends CrudController<Company> {
    @Autowired
    HoldingServices holdingServices;



    @PostConstruct
    private void postConstruct() {
        this.setService( holdingServices);
    }
}
