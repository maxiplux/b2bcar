package com.b2b.cart.repository;

import com.b2b.cart.models.corporate.Department;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository
public interface DepartmentRepository extends PagingAndSortingRepository<Department, Long> {
    Set<Department> findByName(@Param("name") String name);
}