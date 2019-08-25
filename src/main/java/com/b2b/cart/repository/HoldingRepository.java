package com.b2b.cart.repository;

import com.b2b.cart.models.corporate.Holding;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository
public interface HoldingRepository extends PagingAndSortingRepository<Holding, Long> {
    Set<Holding> findByName(@Param("name") String name);
}