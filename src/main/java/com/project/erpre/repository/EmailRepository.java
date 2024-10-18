package com.project.erpre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.erpre.model.entity.EmailSend;

public interface EmailRepository extends JpaRepository<EmailSend, Integer>{
  
}
