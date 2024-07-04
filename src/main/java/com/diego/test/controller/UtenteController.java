package com.diego.test.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diego.test.dto.UtenteDto;
import com.diego.test.service.UtenteService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/utente")
public class UtenteController {
    
    private UtenteService utenteService;

    @PostMapping
    public UtenteDto createUtente(@RequestBody UtenteDto u){
        return  utenteService.createUtente(u);
    }

    @GetMapping
    public List<UtenteDto> getAllUtente(){
        return utenteService.getAllUtente();
    }

    @GetMapping("{email}")
    public UtenteDto getUtenteByEmail(@PathVariable String email) {
        return utenteService.getUtente(email);
    }
    
    @GetMapping("/first/{first_name}")
    public List<UtenteDto> getUtenteByFirstName(@PathVariable("first_name") String first_name) {
        return utenteService.getUtenteByFirst(first_name);
    }
    
    @DeleteMapping("{email}")
    public UtenteDto deleteUtente(@PathVariable String email){

        return utenteService.deleteUtente(email);

    }


}
