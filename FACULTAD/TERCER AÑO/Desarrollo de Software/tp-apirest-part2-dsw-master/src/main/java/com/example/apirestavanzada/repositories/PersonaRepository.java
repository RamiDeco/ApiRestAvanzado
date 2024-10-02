package com.example.apirestpart2bruno.repositories;


import com.example.apirestpart2bruno.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {

    //Métodos de Query
    List <Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);
    //Lo que hace es ver todas las personas que contengan ese nombre o apellido que se pasan como parámetro

//    boolean existsByDni(int dni);
    //El metodo se usa para ver si existe una persona con ese dni en la BD.

    //@Query usando JPQL
    //Una forma de poner los parámetros es con el ?1 que significa que es un parámetro:
    //  @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %?1%")
    // List <Persona> search(String filtro);
    // o usar parámetros nombrados
    //Para eso, dentro del metodo se usa @Param y el nombre del parámetro, luego eso se pone en la consulta
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
    List<Persona> search(@Param("filtro") String filtro);

    //@Query usando SQL pelado (nativa)

    @Query(
            value = "SELECT * FROM persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro% ",
            nativeQuery = true
    )
    List <Persona> searchNativo(@Param("filtro") String filtro);

    //Con paginación
    Page<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);

    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
    Page<Persona> search(@Param("filtro") String filtro, Pageable pageable);

    @Query(
            value = "SELECT * FROM persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro% ",
            //Query de conteo de páginas
            countQuery = "SELECT COUNT(*) FROM persona ",
            nativeQuery = true
    )
    Page <Persona> searchNativo(@Param("filtro") String filtro, Pageable pageable);
}
