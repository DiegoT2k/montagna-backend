package com.diego.test.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.diego.test.dto.PasseggiataDto;
import com.diego.test.service.PasseggiataService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/passeggiata")
public class PasseggiataController {
    
    private PasseggiataService passeggiataService;

    @PostMapping
    public Long createPasseggiata(@RequestBody PasseggiataDto passeggiataDto){
 
        PasseggiataDto p = passeggiataService.createPasseggiata(passeggiataDto);

        return p.getId();

    }

    @PutMapping("{id}")
    public PasseggiataDto updatePasseggiata(@PathVariable Long id, @RequestBody MultipartFile file){
        return passeggiataService.updatePasseggiata(id, file);
    }


    @GetMapping
    public List<PasseggiataDto> getAllPasseggiate(){

        return passeggiataService.getAllPasseggiate();

    }

    @GetMapping("{id}")
    public PasseggiataDto getPasseggiata(@PathVariable Long id){
    
        return passeggiataService.getPasseggiata(id);
    
    }

    @DeleteMapping("{id}")
    public PasseggiataDto deletePasseggiata(@PathVariable Long id){

        return passeggiataService.deletePasseggiataDtoById(id);
    
    }

}
