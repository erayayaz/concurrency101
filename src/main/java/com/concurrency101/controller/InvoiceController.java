package com.concurrency101.controller;

import com.concurrency101.dto.CreateInvoiceRequest;
import com.concurrency101.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoices")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceService invoiceService;

    @PostMapping
    void upsert(@RequestBody CreateInvoiceRequest request) {
        this.invoiceService.upsert(request);
    }
}
