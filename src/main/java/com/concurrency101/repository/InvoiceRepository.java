package com.concurrency101.repository;

import com.concurrency101.model.Invoice;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.Optional;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
    @Lock(LockModeType.OPTIMISTIC)
    //  @Lock(LockModeType.PESSIMISTIC_WRITE) --other solution
    Optional<Invoice> findInvoiceByUuid(String uuid);
}
