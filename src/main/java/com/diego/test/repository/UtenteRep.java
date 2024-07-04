package com.diego.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diego.test.entity.Utente;
import java.util.List;



public interface UtenteRep extends JpaRepository<Utente, String>{
    
    List<Utente> findByFirstName(String firstName);
    
    
}
