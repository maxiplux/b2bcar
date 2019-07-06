package com.b2b.cart.repository;


import com.b2b.cart.models.corporate.Company;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CompanyRepository extends MongoRepository<Company, String> {
    //http://www.technicalkeeda.com/spring-tutorials/spring-4-mongodb-repository-example
    List<Company> findAllByCompanyId(String id);

    Optional<Company> findByCompanyId(String id);
}