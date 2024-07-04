package com.diego.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diego.test.entity.Passeggiata;

public interface PasseggiataRepository extends JpaRepository<Passeggiata, Long>{
    
}
