package com.diego.test.service;

import java.util.*;

import com.diego.test.dto.UtenteDto;

public interface UtenteService {
    
    public UtenteDto createUtente(UtenteDto u);

    public List<UtenteDto> getAllUtente();

    public UtenteDto getUtente(String email);

    public List<UtenteDto> getUtenteByFirst(String email);

    public UtenteDto deleteUtente(String email);

}
