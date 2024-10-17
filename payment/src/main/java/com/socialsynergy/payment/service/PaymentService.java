package com.socialsynergy.payment.service;

import com.socialsynergy.payment.entity.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> getAll();
    Payment getById(Long paymentId);
    Payment create(Payment payment);
}
