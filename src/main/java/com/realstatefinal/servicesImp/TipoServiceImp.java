/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.realstatefinal.servicesImp;

import com.realstatefinal.models.Inmueble;
import com.realstatefinal.models.Tipo;
import com.realstatefinal.repositories.TipoRepository;
import com.realstatefinal.services.TipoService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author erick
 */
@Service
public class TipoServiceImp implements TipoService, Serializable {

    @Autowired
    private TipoRepository tipoRepository;
    
    @Override
    public Set<Inmueble> obtenerInmueblesTipo(Long id) {
        Optional<Tipo> optionalTipo = tipoRepository.findById(id);
        
        
        if (optionalTipo.isPresent()) {
            Tipo tipo = optionalTipo.get();
            Set<Inmueble> inmuebles = tipo.getInmuebles();
            return new HashSet <>(inmuebles);
            } else {
             return null;
         }
    }
    }
    

