package com.b2b.cart.repository;


import com.b2b.cart.models.corporate.Company;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CompanyRepository extends PagingAndSortingRepository<Company, Long> {
    Optional<Company> findById(Long id);
}