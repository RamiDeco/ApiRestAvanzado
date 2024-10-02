package com.example.inicial1.dtos;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
//Dto usa solo las partes de las entidades que necesitamos. Ej solo necesito el campo apellido de la clase personas
public class PersonaDto {

    private Long id;
    private String nombre;
    private String apellido;
}
