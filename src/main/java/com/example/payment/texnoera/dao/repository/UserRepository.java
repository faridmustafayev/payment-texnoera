package com.example.payment.texnoera.dao.repository;

import com.example.payment.texnoera.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
