package com.diego.test.mapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.diego.test.dto.PasseggiataDto;
import com.diego.test.entity.Passeggiata;

public class PasseggiataMapper {

    
    public static Passeggiata mapToPasseggiata(PasseggiataDto p){

        return new Passeggiata(
            p.getId(),
            p.getTitle(),
        null,
            p.getLevel(),
            p.getDescription()
        );

    }

    public static PasseggiataDto mapToPasseggiataDto(Passeggiata p){

        return new PasseggiataDto(
            p.getId(),
            p.getTitle(),
            p.getImg(),
            p.getLevel(),
            p.getDescription()
        );

    }

    public static List<PasseggiataDto> mapToPasseggiataDto(List<Passeggiata> l){
        
        List<PasseggiataDto> lista = new ArrayList<>();

        for(Passeggiata e : l){
            lista.add(mapToPasseggiataDto(e));
        }

        return lista;
    }

}
