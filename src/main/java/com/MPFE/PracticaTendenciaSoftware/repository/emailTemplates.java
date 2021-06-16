package com.MPFE.PracticaTendenciaSoftware.repository;

import com.MPFE.PracticaTendenciaSoftware.model.EmailTemplates;

import org.springframework.data.jpa.repository.JpaRepository;

public interface emailTemplates extends JpaRepository<EmailTemplates, Long>{
    
}
