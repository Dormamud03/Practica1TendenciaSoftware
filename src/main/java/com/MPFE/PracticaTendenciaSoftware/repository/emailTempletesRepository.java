package com.MPFE.PracticaTendenciaSoftware.repository;

import com.MPFE.PracticaTendenciaSoftware.controller.EmailTemplates;

import org.springframework.data.jpa.repository.JpaRepository;

public interface emailTempletesRepository  extends JpaRepository<EmailTemplates, Long> {
    
}
