package com.example.apirestpart2bruno.services;

import com.example.apirestpart2bruno.entities.Localidad;
import com.example.apirestpart2bruno.repositories.BaseRepository;
import com.example.apirestpart2bruno.repositories.LocalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalidadServiceImpl extends BaseServiceImpl<Localidad, Long> implements LocalidadService {

    @Autowired
    private LocalidadRepository localidadRepository;

    public LocalidadServiceImpl (BaseRepository<Localidad, Long> baseRepository){
        super(baseRepository);
    }
}
