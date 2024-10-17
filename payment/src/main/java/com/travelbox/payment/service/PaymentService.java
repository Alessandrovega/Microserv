package com.travelbox.payment.service;

import com.travelbox.payment.entity.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> getAll();
    Payment getById(Long paymentId);
    Payment create(Payment payment);
    Payment update(Long paymentId, Payment payment);
    void delete(Long paymentId);
}
