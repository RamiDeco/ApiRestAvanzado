package com.example.apirestpart2bruno.services;

import com.example.apirestpart2bruno.entities.Autor;
import com.example.apirestpart2bruno.repositories.AutorRepository;
import com.example.apirestpart2bruno.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorServiceImpl extends BaseServiceImpl<Autor, Long> implements AutorService{
    @Autowired
    private AutorRepository autorRepository;

    public AutorServiceImpl(BaseRepository<Autor, Long> baseRepository){
        super(baseRepository);
    }
}
