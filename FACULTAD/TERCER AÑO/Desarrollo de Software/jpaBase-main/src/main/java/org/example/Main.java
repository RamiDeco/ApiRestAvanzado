package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        System.out.println("en marcha Alberto");

        try {
            // Persistir una nueva entidad Person
            entityManager.getTransaction().begin();

            Domicilio domicilio1 = Domicilio.builder()
                    .nombreCalle("Chuquisaca")
                    .numero(1010)
                    .build();

            Cliente cliente1 = Cliente.builder()
                    .name("Facu Cortez")
                    .dni(45256278)
                    .domicilio(domicilio1)
                    .build();

            entityManager.persist(cliente1);


            Categoria categoria1 = Categoria.builder()
                    .denominacion("Limpieza")
                    .build();
            Categoria categoria2 = Categoria.builder()
                    .denominacion("Util")
                    .build();
            Categoria categoria3 = Categoria.builder()
                    .denominacion("Cartuchera")
                    .build();
            Categoria categoria4 = Categoria.builder()
                    .denominacion("Escuela")
                    .build();

            List<Categoria> categoriasHogar = new ArrayList<>();
            categoriasHogar.add(categoria1);
            categoriasHogar.add(categoria2);

            List<Categoria> categoriasLibreria = new ArrayList<>();
            categoriasHogar.add(categoria3);
            categoriasHogar.add(categoria4);

            Articulo articulo1 = Articulo.builder()
                    .cantidad(10)
                    .precio(100)
                    .denominacion("Escoba")
                    .categoria(categoriasHogar)
                    .build();

            Articulo articulo2 = Articulo.builder()
                    .precio(200)
                    .cantidad(2)
                    .denominacion("Sacapuntas")
                    .categoria(categoriasLibreria)
                    .build();

            entityManager.persist(articulo1);
            entityManager.persist(articulo2);

            Factura factura1 = Factura.builder()
                    .numero(123)
                    .total(1400)
                    .fecha("30/10/2003")
                    .cliente(cliente1)
                    .build();

            DetalleFactura detalleFac1 = DetalleFactura.builder()
                    .articulo(articulo1)
                    .cantidad(10)
                    .subtotal(1000)
                    .factura(factura1)
                    .build();
            DetalleFactura detalleFac2 = DetalleFactura.builder()
                    .articulo(articulo2)
                    .cantidad(2)
                    .subtotal(100)
                    .factura(factura1)
                    .build();

            entityManager.persist(detalleFac1);
            entityManager.persist(detalleFac2);

            entityManager.getTransaction().commit();


            // Consultar y mostrar la entidad persistida
            Cliente retrievedPerson = entityManager.find(Cliente.class, cliente1.getId());
            System.out.println("Retrieved Client: " + retrievedPerson.getName());

        }catch (Exception e){

            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
            System.out.println("No se pudo grabar la clase Persona");}

        // Cerrar el EntityManager y el EntityManagerFactory
        entityManager.close();
        entityManagerFactory.close();
    }
}
