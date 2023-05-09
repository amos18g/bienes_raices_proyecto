/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.realstatefinal.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author erick
 */

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clave_catastral")
@JsonIdentityInfo(scope = ClaveCatastral.class ,generator = ObjectIdGenerators.PropertyGenerator.class, property = "idCodigoClave")//property (se puede definir con JsonProperty(name = ) )
public class ClaveCatastral implements Serializable{
    
    @JsonProperty("idCodigoClave")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoclave")
    private Long codigoClave;
    
    @Column(name = "clavecatastral") 
    private int claveCatastral;
    
    
    
    @Column(name = "fechadescripcion")
    @JsonFormat(pattern="yyyy-MM-dd")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInscripcion;
    
    @Column(name = "departamento")
    private String departamento;
    
    
    @OneToOne(mappedBy = "claveCatastral")
    @JsonIdentityReference(alwaysAsId = true)
    //@JsonIgnore
    private Inmueble inmueble;
    
}
