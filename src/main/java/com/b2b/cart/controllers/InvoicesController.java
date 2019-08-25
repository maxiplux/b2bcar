package com.b2b.cart.controllers;

import com.b2b.cart.controllers.generics.CrudController;
import com.b2b.cart.models.corporate.Company;
import com.b2b.cart.models.invoices.Invoice;
import com.b2b.cart.services.HoldingServices;
import com.b2b.cart.services.InvoiceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/v1/invoices")
public class InvoicesController extends CrudController<Invoice> {
    @Autowired
    InvoiceServices invoiceServices;



    @PostConstruct
    private void postConstruct() {
        this.setService( invoiceServices);
    }
}
