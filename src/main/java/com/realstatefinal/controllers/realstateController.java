/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.realstatefinal.controllers;

import com.realstatefinal.models.ClaveCatastral;
import com.realstatefinal.models.Duenio;
import com.realstatefinal.models.Inmueble;
import com.realstatefinal.models.Tipo;
import com.realstatefinal.services.ClaveCatastralService;
import com.realstatefinal.services.DuenioService;
import com.realstatefinal.services.InmuebleService;
import com.realstatefinal.services.TipoService;
import java.util.Date;
import java.util.List;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author erick
 */

@RestController
@RequestMapping("/realstate")
@Slf4j
public class realstateController {
    
    @Autowired
    private TipoService tipoService;
    
    @Autowired
    private DuenioService duenioService;
    
    @Autowired
    private InmuebleService inmuebleService;
    
    @Autowired
    private ClaveCatastralService claveCatastralService;
    
    
    @GetMapping("/tipo/getInmuebles/{id}")
    public Set<Inmueble> getInmueblesPorTipo(@PathVariable Long id){
        
        
        Set<Inmueble> inmuebles = tipoService.obtenerInmueblesTipo(id);
        return inmuebles;

    }
    

    
    @PostMapping("/inmueble/guardar")
    public Inmueble guardarInmuble(@RequestBody Inmueble inmueble){
    
        return inmuebleService.crearInmueble(inmueble);
    }
    
    
    
    @GetMapping("/inmueble/getCuotasVencidas")
    public List<Inmueble> getInmueblesCuotasVencidas(){
        
        
        List<Inmueble> inmuebles = inmuebleService.obtenerInmueblesCuotasVencidas();
        return inmuebles;

    }
    
    @GetMapping("/inmueble/getInmueble/{id}")  //obtener inmueble por id
    public Inmueble getInmueblePorId(@PathVariable Long id){
        
        
        Inmueble inmueble = inmuebleService.ObtenerInmueble(id);
        return inmueble;

    }
    
    
     @PostMapping("/inmueble/delete/{id}") //borrar inmueble
    public void deleteInmueble(@PathVariable(name = "id") Long id){
         this.inmuebleService.borrarInmueble(id);
    }
    
    
    
    

    @PostMapping("/inmueble/actualizar")
    public Inmueble actualizarInmueble(@RequestBody Inmueble inmueble){ 
    
        return inmuebleService.ActualizarInmueble(inmueble);
    }
    
    
    
    
    @PostMapping("/duenio/guardar")
    public Duenio guardarDuenio(@RequestBody Duenio duenio){
    
        return duenioService.guardarDuenio(duenio);
    }
    
    
    
    @PostMapping("/duenio/delete/{id}") //borrar inmueble
    public void deleteDuenio(@PathVariable(name = "id") Long id){
         this.duenioService.eliminarDuenio(id);
    }
    
    
    @GetMapping("/duenio/getDuenio/{id}")  //obtener inmueble por id
    public Duenio getDuenioPorId(@PathVariable Long id){       
        
        return duenioService.obtenerDuenio(id);       

    }
    
    
    @GetMapping("/duenio/getInmuebles/{id}")  //obtener inmueble por id
    public Set<Inmueble> getInmueblesDuenio(@PathVariable Long id){       
        
        return duenioService.getInmueblesDuenio(id);

    }
    
}
