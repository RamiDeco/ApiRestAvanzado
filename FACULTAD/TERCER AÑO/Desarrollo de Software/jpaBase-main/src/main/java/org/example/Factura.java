package org.example;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "Factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fecha;
    private int numero;
    private float total;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "fk_cliente")
    private Cliente cliente;

}
