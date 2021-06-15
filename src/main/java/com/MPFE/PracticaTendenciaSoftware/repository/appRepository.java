package com.MPFE.PracticaTendenciaSoftware.repository;

import com.MPFE.PracticaTendenciaSoftware.model.App;

import org.springframework.data.jpa.repository.JpaRepository;

public interface appRepository extends JpaRepository<App, Long>{
    
}
