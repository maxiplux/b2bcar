package com.b2b.cart.repository;


import com.b2b.cart.models.corporate.Company;
import com.b2b.cart.models.rules.State;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface StateRepository extends PagingAndSortingRepository<State, Long> {
    Optional<State> findById(Long id);
}