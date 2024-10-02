package com.example.apirestpart2bruno.services;

import com.example.apirestpart2bruno.entities.Base;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public interface BaseService <E extends Base, ID extends Serializable>{
    public List<E> findAll() throws Exception; //Lista de las entidades de un tipo que queramos obtener
    //Metodo para devolver los datos paginados
    public Page<E> findAll(Pageable pageable) throws Exception;
    public E findById(ID id) throws Exception; //Busca un único registro de una entidad en la BD
    public E save(E entity) throws Exception; //Crear un registro de una entidad en la BD
    public E update(ID id, E entity) throws Exception; //Actualizar un registro en la BD
    public boolean delete(ID id) throws Exception; //Eliminar un registro en la BD
}
