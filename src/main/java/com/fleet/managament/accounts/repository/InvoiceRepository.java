package com.fleet.managament.accounts.repository;

import com.fleet.managament.accounts.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository <Invoice, Long> {
}
