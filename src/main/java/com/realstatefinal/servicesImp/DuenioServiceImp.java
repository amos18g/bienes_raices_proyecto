/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.realstatefinal.servicesImp;

import com.realstatefinal.models.Duenio;
import com.realstatefinal.models.Inmueble;
import com.realstatefinal.repositories.DuenioRepository;
import com.realstatefinal.services.DuenioService;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author erick
 */

@Service
public class DuenioServiceImp implements DuenioService, Serializable{
    
    @Autowired
    private DuenioRepository duenioRepository;

    @Override
    public Duenio guardarDuenio(Duenio duenio) {
           return duenioRepository.save(duenio);
    }

    @Override
    public Duenio obtenerDuenio(Long id) {
        Optional<Duenio> optionalDuenio = duenioRepository.findById(id);
       return    optionalDuenio.orElse(null);
    }

    @Override
    public void eliminarDuenio(Long id) {
        duenioRepository.deleteById(id);
    }

    @Override
    public Set<Inmueble> getInmueblesDuenio(Long id) {
        Optional<Duenio> optionalDuenio = duenioRepository.findById(id);
       return    optionalDuenio.orElse(null).getInmuebles();  
    }
    
}
