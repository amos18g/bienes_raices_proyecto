/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.realstatefinal.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author erick
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "duenio")
@JsonIdentityInfo(scope = Duenio.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "codigoDuenio")
public class Duenio implements Serializable{

 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoduenio")
    private Long codigoDuenio;
    
    @Column
    private String nombre;
    
    @Column
    private String apellido;
    
    @Column
    private String telefono;
    
    
    @Column
    private String correo;
    
    
    @ManyToMany(mappedBy = "duenios")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIgnore
    private Set<Inmueble> inmuebles;
    
}
