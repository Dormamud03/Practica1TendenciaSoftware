package com.MPFE.PracticaTendenciaSoftware.repository;

import com.MPFE.PracticaTendenciaSoftware.model.Application;

import org.springframework.data.jpa.repository.JpaRepository;

public interface appRepository extends JpaRepository<Application, Long>{
    
}
