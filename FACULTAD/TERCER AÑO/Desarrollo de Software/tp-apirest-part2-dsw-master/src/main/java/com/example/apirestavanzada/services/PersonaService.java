package com.example.apirestpart2bruno.services;

import com.example.apirestpart2bruno.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonaService extends BaseService<Persona, Long>{
    List<Persona> search(String filtro) throws Exception;

    //Search con paginación
    Page<Persona> search(String filtro, Pageable pageable) throws Exception;
}
