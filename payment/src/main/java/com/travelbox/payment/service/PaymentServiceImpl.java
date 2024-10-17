package com.travelbox.payment.service;

import com.travelbox.payment.entity.Payment;
import com.travelbox.payment.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getById(Long paymentId) {
        return paymentRepository.findById(paymentId).orElse(null);
    }

    @Override
    public Payment create(Payment payment) {
        payment.setCreated(new Date());

        return paymentRepository.save(payment);
    }

    @Override
    public Payment update(Long paymentId, Payment payment) {
        Optional<Payment> existingPayment = paymentRepository.findById(paymentId);

        if (existingPayment.isPresent()) {
            Payment paymentToUpdate = existingPayment.get();
            paymentToUpdate.setName(payment.getName());
            paymentToUpdate.setDescription(payment.getDescription());
            paymentToUpdate.setTitle(payment.getTitle());
            // Si es necesario actualizar la fecha de creación o algún otro campo
            return paymentRepository.save(paymentToUpdate);
        }

        return null; // Manejar este caso en el controlador.
    }

    @Override
    public void delete(Long paymentId) {
        if (paymentRepository.existsById(paymentId)) {
            paymentRepository.deleteById(paymentId);
        }
    }
}
