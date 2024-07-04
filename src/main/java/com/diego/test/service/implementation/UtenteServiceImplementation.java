package com.diego.test.service.implementation;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.diego.test.dto.UtenteDto;
import com.diego.test.entity.Utente;
import com.diego.test.exception.ResourceNotFoundException;
import com.diego.test.mapper.UtenteMapper;
import com.diego.test.repository.UtenteRep;
import com.diego.test.service.UtenteService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UtenteServiceImplementation implements UtenteService{

    private UtenteRep utenteRepository;

    @Override
    public UtenteDto createUtente(UtenteDto u) {

        Utente utente = UtenteMapper.mapToUtente(u);
        Utente saved = utenteRepository.save(utente);
        
        return UtenteMapper.mapToUtenteDto(saved);
    }

    @Override
    public List<UtenteDto> getAllUtente() {
        
        List<Utente> lista = utenteRepository.findAll();
        List<UtenteDto> listaDto = new ArrayList<>();

        for(Utente u : lista){
            listaDto.add(UtenteMapper.mapToUtenteDto(u));
        }

        return listaDto;

    }

    @Override
    public UtenteDto getUtente(String email){

        Utente u = utenteRepository.findById(email)
            .orElseThrow(() -> 
            new ResourceNotFoundException("Non trovato " + email));

        return UtenteMapper.mapToUtenteDto(u);

    }

    @Override
    public List<UtenteDto> getUtenteByFirst(String first_name) {
        
        List<Utente> lista = utenteRepository.findByFirstName(first_name);

        return lista.stream().map(utente -> UtenteMapper.mapToUtenteDto(utente)).collect(Collectors.toList());

    }

    @Override
    public UtenteDto deleteUtente(String email) {
        
        Utente u = utenteRepository.findById(email)
            .orElseThrow(() -> new ResourceNotFoundException("non esiste"));

        utenteRepository.delete(u);

        return UtenteMapper.mapToUtenteDto(u);
    }
    
}
