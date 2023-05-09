/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.realstatefinal.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *
 * @author erick
 */
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tipo")
@JsonIdentityInfo(scope = Tipo.class ,generator = ObjectIdGenerators.PropertyGenerator.class, property = "codigoTipo")
public class Tipo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigotipo")
    private Long codigoTipo;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "descripcion")
    private Descripcion descripcion;  
    
    
    @OneToMany(mappedBy = "tipo", fetch = FetchType.EAGER
    )
     @JsonIgnore
    private Set<Inmueble> inmuebles;
    
    
    
    
    private enum Descripcion {
    venta,
    alquiler
}
}
