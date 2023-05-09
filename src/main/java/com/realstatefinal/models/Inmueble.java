/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.realstatefinal.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
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
@Table(name =  "inmueble")
@JsonIdentityInfo(scope = Inmueble.class,  generator = ObjectIdGenerators.PropertyGenerator.class, property = "codigoInmueble")
public class Inmueble implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoinmueble")
    private Long codigoInmueble;
    
    @Column
    private String color;
    
    @Column(name = "area")
    private double area;
            
    @Column
    private int piso;
    
    @Column(name = "preciopormetro")
    private double precioPorMetro;
    
    
    @Column(name = "precioalquiler")
    private double precioAlquiler;
    
    @OneToOne(cascade = CascadeType.REMOVE,fetch = FetchType.EAGER) //relacion uno a uno con ClaveCatastral
    @JsonIdentityReference(alwaysAsId = true)
    @JoinColumn(name = "codigoclave", referencedColumnName = "codigoclave")
    private ClaveCatastral claveCatastral;
    
    
    
    @ManyToMany //relacion muchos a muchos con duenios
    @JsonIdentityReference(alwaysAsId = true)
    @JoinTable(
        name = "duenio_inmueble",
        joinColumns = @JoinColumn(name = "codigoinmueble"),
        inverseJoinColumns = @JoinColumn(name = "codigoduenio")
    )
    private List<Duenio> duenios;
    
   
    @OneToMany(mappedBy = "inmueble", fetch = FetchType.EAGER//relacion uno a muchos tabla padre
            
    )
    private List<Cuota> cuotas;
    
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "codigotipo" ,nullable = false)   
    private Tipo tipo;
    
    
    
    //campos que no se van a mapear a la BD
    
    @Transient
    private int claveCatastralTr;
    
    
    
    @Transient
    private Date fechaInscripcion;
    
    @Transient
    private String departamento;
}
