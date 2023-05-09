/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.realstatefinal.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
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
@Table(name =  "cuota")
@JsonIdentityInfo(scope = Cuota.class,generator = ObjectIdGenerators.PropertyGenerator.class, property = "codigoCuota")
public class Cuota implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigocuota")
    private Long codigoCuota;
    
    @Column(name = "fechavencimiento")
    private LocalDate fechaVencimiento;
    
    
    @Enumerated(EnumType.STRING)
    @Column(name = "descripcion")
    private DescripcionCuota descripcion;
    
    @Column
    private double monto;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false) //relacion muchos a uno tabla hija
    @JoinColumn(name = "codigoinmueble" ,nullable = false)
    private Inmueble inmueble;
    
    
    public enum DescripcionCuota {
    A,
    P
    }

    
}
