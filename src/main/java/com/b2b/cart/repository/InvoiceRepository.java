package com.b2b.cart.repository;


import com.b2b.cart.models.invoices.Invoice;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface InvoiceRepository extends PagingAndSortingRepository<Invoice, Long> {
    Optional<Invoice> findById(Long id);
}