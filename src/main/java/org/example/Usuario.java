package org.example;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.io.Serializable;

@Data
//Necesario para almacenar en la base de datos. (Entidad perteneciente a la base de datos)
@Entity
//Nombre de la tabla en la que vas a insertar.
@Table (name = "usuario")
public class Usuario implements Serializable {
  @Id
  //Para indicarle a Hibernate que el atributo de abajo es el id
  @GeneratedValue( strategy = GenerationType.IDENTITY)
  private Long id;
  private String nombre;
  private String email;
}
