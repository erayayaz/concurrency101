package com.concurrency101.service;

import com.concurrency101.dto.CreateInvoiceRequest;
import com.concurrency101.model.Invoice;
import com.concurrency101.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    @Transactional
    public void upsert(CreateInvoiceRequest request) {
        Invoice invoice = this.invoiceRepository.findInvoiceByUuid(request.getUuid())
                .orElseGet(() -> Invoice.builder().uuid(request.getUuid()).amount(request.getAmount()).build());

        this.invoiceRepository.save(invoice);
    }
}
