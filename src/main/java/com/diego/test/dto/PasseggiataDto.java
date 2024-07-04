package com.diego.test.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PasseggiataDto {
    
    private Long id;
    private String title;
    private byte[] img;
    private String level;
    private String description; 

}
