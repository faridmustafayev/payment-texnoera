package com.example.payment.texnoera.dao.repository;

import com.example.payment.texnoera.dao.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {

}
