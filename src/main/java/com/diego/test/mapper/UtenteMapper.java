package com.diego.test.mapper;

import com.diego.test.dto.UtenteDto;
import com.diego.test.entity.Utente;

public class UtenteMapper {
    
    public static Utente mapToUtente(UtenteDto u){
        return new Utente(
            u.getEmail(),
            u.getFirstName(),
            u.getSecondName()
        );
    }

    public static UtenteDto mapToUtenteDto(Utente u){
        return new UtenteDto(
            u.getEmail(),
            u.getFirstName(),
            u.getSecondName()
        );
    }

}
