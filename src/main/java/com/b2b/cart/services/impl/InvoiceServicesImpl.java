package com.b2b.cart.services.impl;

import com.b2b.cart.models.invoices.Invoice;
import com.b2b.cart.repository.InvoiceRepository;
import com.b2b.cart.services.InvoiceServices;
import com.b2b.cart.services.generics.CrudServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
public class InvoiceServicesImpl extends CrudServicesImpl<Invoice> implements InvoiceServices<Invoice> {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @PostConstruct
    public  void posContructor() {
        this.setRepository( invoiceRepository);
    }


    public Optional<Invoice> UpdateById(long id, Invoice element) {
        Optional<Invoice> optionalCurrentCompany = this.repository.findById(id);
        if (optionalCurrentCompany.isPresent()) {
            Invoice currentProduct = optionalCurrentCompany.get();

            if (element.getCustomer() != null) {
                currentProduct.setCustomer(element.getCustomer());
            }

            if (element.getComments() != null) {
                currentProduct.setComments(element.getComments());
            }

            if (element.getDescription() != null ) {
                currentProduct.setDescription(element.getDescription());
            }

            if (element.getItems() != null ) {
                currentProduct.setItems(element.getItems());
            }

            return Optional.of((Invoice) this.repository.save(currentProduct));
        }
        return Optional.empty();

    }


}
