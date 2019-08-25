package com.b2b.cart.services.impl;

import com.b2b.cart.models.corporate.Company;
import com.b2b.cart.repository.CompanyRepository;
import com.b2b.cart.services.CompanyServices;
import com.b2b.cart.services.generics.CrudServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
public class CompanyServicesImpl extends CrudServicesImpl<Company> implements CompanyServices<Company> {

    @Autowired
    private CompanyRepository companyRepository;


    @PostConstruct
    public  void posContructor() {
        this.setRepository( companyRepository);
    }

    public Optional<Company> UpdateById(long id, Company element) {
        Optional<Company> optionalCurrentCompany = this.repository.findById(id);
        if (optionalCurrentCompany.isPresent()) {
            Company currentProduct = optionalCurrentCompany.get();

            if (element.getName() != null) {
                currentProduct.setName(element.getName());
            }

            if (element.getEmail() != null) {
                currentProduct.setEmail(element.getEmail());
            }
            return Optional.of((Company) this.repository.save(currentProduct));
        }
        return Optional.empty();

    }


}
