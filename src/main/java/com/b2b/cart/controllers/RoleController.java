package com.b2b.cart.controllers;

import com.b2b.cart.controllers.generics.CrudController;
import com.b2b.cart.models.users.Role;
import com.b2b.cart.services.RoleServices;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/v1/roles")
@Data
public class RoleController extends CrudController<Role> {

    @Autowired
    private RoleServices roleServices;

    @PostConstruct
    public void posContructor() {
        this.service = roleServices;
    }

}
