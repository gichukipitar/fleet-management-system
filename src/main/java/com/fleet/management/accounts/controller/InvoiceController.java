package com.fleet.management.accounts.controller;

import com.fleet.management.accounts.entity.Invoice;
import com.fleet.management.accounts.services.InvoiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class InvoiceController {

    private final InvoiceService invoiceService;
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

@GetMapping("/invoices")
    public  ResponseEntity <List <Invoice>> getAllInvoices() {
        List <Invoice> invoices = invoiceService.findAllInvoices();
        return ResponseEntity.ok(invoices);
}

}
