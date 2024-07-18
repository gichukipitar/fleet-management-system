package com.fleet.management.accounts.services;

import com.fleet.management.accounts.entity.Invoice;
import com.fleet.management.accounts.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }
    //get all invoices

    public List<Invoice> findAllInvoices() {
        return invoiceRepository.findAll();
    }

    //get invoice by id
    public Invoice findInvoiceById(Long id) {
        return invoiceRepository.findById(id).orElse(null);
    }

    //delete invoice
    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }

    //update invoice
    public void saveInvoice(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

}
