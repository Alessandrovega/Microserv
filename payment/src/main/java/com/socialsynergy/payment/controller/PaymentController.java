package com.socialsynergy.payment.controller;

import com.socialsynergy.payment.entity.Payment;
import com.socialsynergy.payment.service.PaymentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "payments")
@Tag(name = "Payment", description = "Payment Management Endpoints")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public ResponseEntity<List<Payment>> getAll() {
        List<Payment> categories = paymentService.getAll();

        if (categories.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(categories);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Payment> getById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getById(id);

        if (payment == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(payment);
    }

    @PostMapping
    public ResponseEntity<Payment> create(@RequestBody Payment payment) {
        Payment paymentCreated = paymentService.create(payment);

        return ResponseEntity.status(HttpStatus.CREATED).body(paymentCreated);
    }
}
