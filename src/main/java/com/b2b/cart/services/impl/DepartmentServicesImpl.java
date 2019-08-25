package com.b2b.cart.services.impl;

import com.b2b.cart.models.corporate.Department;
import com.b2b.cart.repository.CompanyRepository;
import com.b2b.cart.services.DepartmentServices;
import com.b2b.cart.services.generics.CrudServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
public class DepartmentServicesImpl extends CrudServicesImpl<Department> implements DepartmentServices<Department> {

    @Autowired
    private CompanyRepository companyRepository;


    @PostConstruct
    private void postConstruct() {
        this.setRepository(this.companyRepository);
    }

    public Optional<Department> UpdateById(long id, Department element) {
        Optional<Department> optionalCurrentCompany = this.repository.findById(id);
        if (optionalCurrentCompany.isPresent()) {
            Department currentProduct = optionalCurrentCompany.get();

            if (element.getName() != null) {
                currentProduct.setName(element.getName());
            }

            if (element.getMananger() != null) {
                currentProduct.setMananger(element.getMananger());
            }
            return Optional.of((Department) this.repository.save(currentProduct));
        }
        return Optional.empty();

    }


}
