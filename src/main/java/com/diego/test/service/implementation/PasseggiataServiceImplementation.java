package com.diego.test.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.diego.test.dto.PasseggiataDto;
import com.diego.test.entity.Passeggiata;
import com.diego.test.exception.ResourceNotFoundException;
import com.diego.test.mapper.PasseggiataMapper;
import com.diego.test.repository.PasseggiataRepository;
import com.diego.test.service.PasseggiataService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PasseggiataServiceImplementation implements PasseggiataService{

    private PasseggiataRepository passeggiataRepository;

    /**
     * Method to create a object 'Passeggiata'
     */
    @Override
    public PasseggiataDto createPasseggiata(PasseggiataDto passeggiataDto) {
        
        try{
            
            Passeggiata p = PasseggiataMapper.mapToPasseggiata(passeggiataDto);
            Passeggiata saved = passeggiataRepository.save(p);

            return PasseggiataMapper.mapToPasseggiataDto(saved);

        }catch(Exception e){

            throw new RuntimeException("Errore caricamento immagine");
        
        }

    }

    /**
     * Method to get all the object in the db
     */
    @Override
    public List<PasseggiataDto> getAllPasseggiate() {
        
        List<Passeggiata> lista = passeggiataRepository.findAll();

        return PasseggiataMapper.mapToPasseggiataDto(lista);

    }

    /**
     * Method to get one 'Passeggiata' from the db
     */
    @Override
    public PasseggiataDto getPasseggiata(Long id) {
        Passeggiata p = passeggiataRepository.findById(id)
            .orElseThrow(() -> 
            new ResourceNotFoundException("Non trovato " + id));
        
        return PasseggiataMapper.mapToPasseggiataDto(p);
    }

    /**
     * Method that delete one element from db with its id
     */
    @Override
    public PasseggiataDto deletePasseggiataDtoById(Long id) {
    
        Passeggiata p = passeggiataRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("non trovato"));

        passeggiataRepository.delete(p);

        return PasseggiataMapper.mapToPasseggiataDto(p);

    }

    @Override
    public PasseggiataDto updatePasseggiata(Long id, MultipartFile file) throws RuntimeException {
    
        Passeggiata passeggiata = passeggiataRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("errore id"));

        
        try{
            passeggiata.setImg(file.getBytes());
        }catch(Exception e){
            throw new RuntimeException("errore set img");
        }

        passeggiataRepository.save(passeggiata);

        return PasseggiataMapper.mapToPasseggiataDto(passeggiata);
    }

}
