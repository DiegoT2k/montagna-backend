package com.diego.test.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.diego.test.dto.PasseggiataDto;

public interface PasseggiataService {
    
    PasseggiataDto createPasseggiata(PasseggiataDto passeggiataDto);

    PasseggiataDto updatePasseggiata(Long id, MultipartFile file);

    List<PasseggiataDto> getAllPasseggiate();

    PasseggiataDto getPasseggiata(Long id);

    PasseggiataDto deletePasseggiataDtoById(Long id);

}
