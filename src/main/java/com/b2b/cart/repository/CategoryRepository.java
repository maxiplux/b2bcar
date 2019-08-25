package com.b2b.cart.repository;

import com.b2b.cart.models.items.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {


}
