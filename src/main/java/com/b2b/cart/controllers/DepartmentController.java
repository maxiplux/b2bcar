package com.b2b.cart.controllers;

import com.b2b.cart.controllers.generics.CrudController;
import com.b2b.cart.models.corporate.Department;
import com.b2b.cart.services.DepartmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController extends CrudController<Department> {
    @Autowired
    DepartmentServices departmentServices;



    @PostConstruct
    private void postConstruct() {
        this.setService( departmentServices);
    }
}
