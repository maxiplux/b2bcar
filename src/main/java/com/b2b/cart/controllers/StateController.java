package com.b2b.cart.controllers;

import com.b2b.cart.controllers.generics.CrudController;
import com.b2b.cart.models.corporate.Company;
import com.b2b.cart.models.rules.State;
import com.b2b.cart.services.CompanyServices;
import com.b2b.cart.services.StateServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/v1/states")
public class StateController extends CrudController<State> {
    @Autowired
    StateServices stateServices;

    @PostConstruct
    private void postConstruct() {
        this.setService( stateServices);
    }

}
