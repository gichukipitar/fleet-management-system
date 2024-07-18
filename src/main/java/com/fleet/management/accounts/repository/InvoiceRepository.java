package com.fleet.management.accounts.repository;

import com.fleet.management.accounts.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository <Invoice, Long> {
}
