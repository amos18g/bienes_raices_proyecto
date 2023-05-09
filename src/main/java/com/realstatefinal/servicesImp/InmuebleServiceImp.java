/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.realstatefinal.servicesImp;

import com.realstatefinal.models.ClaveCatastral;
import com.realstatefinal.models.Cuota;
import com.realstatefinal.models.Cuota.DescripcionCuota;
import com.realstatefinal.models.Inmueble;
import com.realstatefinal.models.Tipo;
import com.realstatefinal.repositories.ClaveCatastralRepository;
import com.realstatefinal.repositories.CuotaRepository;
import com.realstatefinal.repositories.InmuebleRepository;
import com.realstatefinal.repositories.TipoRepository;
import com.realstatefinal.services.ClaveCatastralService;
import com.realstatefinal.services.InmuebleService;
import com.realstatefinal.services.TipoService;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author erick
 */
@Service
public class InmuebleServiceImp implements InmuebleService, Serializable {

    @Autowired
    private InmuebleRepository inmuebleRepository;
    
    @Autowired
    private ClaveCatastralRepository claveRepository;
    
    @Autowired
    private ClaveCatastralService claveCatastralService;
    
    @Autowired
    @Lazy
    private InmuebleService inmuebleService;
    
    @Autowired
    private CuotaRepository cuotaRepository;
    


    @Override
    public void crearCuotas(Long codigoInmueble) {
        
        
        
        
        LocalDate fechaActual = LocalDate.now();
        LocalDate fecha = LocalDate.of(fechaActual.getYear(), fechaActual.getMonth(), 20);
        Long codigo = codigoInmueble;
        
        
        
        Optional<Inmueble> optionalInmueble = inmuebleRepository.findById(codigo);
        
        
        
        
        
        if (optionalInmueble.isPresent()) {
            Inmueble inmueble = optionalInmueble.get();   
            
            
            double montoCuota = 1.5 * inmueble.getArea();            
            
            
            
            for (int i = 0; i < 12; i++) {
                fecha = fecha.plusMonths(1);
                
                Cuota cuota = new Cuota();
                cuota.setDescripcion(DescripcionCuota.A);
                cuota.setFechaVencimiento(fecha);
                cuota.setMonto(montoCuota);
                cuota.setInmueble(inmueble);
                
                
                cuotaRepository.save(cuota);
            }
            
         }
        

        
    }

    @Override
    @Transactional
    public Inmueble crearInmueble(Inmueble inmueble) {
        //
       // inmueble.setClaveCatastral(null);
        
         
         
        
   
        /*Crenado el registro de clave catastral*/
        ClaveCatastral clave =new  ClaveCatastral();   
        clave.setClaveCatastral(inmueble.getClaveCatastralTr());
        clave.setDepartamento(inmueble.getDepartamento());
        clave.setFechaInscripcion(inmueble.getFechaInscripcion());
        //clave.setInmueble(inmueble);
   
        ClaveCatastral claveNueva =  claveCatastralService.crearClaveCatastral(clave);
        
        inmueble.setClaveCatastral(claveNueva);
        
        System.out.println(inmueble);
        
        
        Inmueble inmuebleCreado = inmuebleRepository.save(inmueble);
        inmuebleCreado.setClaveCatastral(claveNueva);
        this.crearCuotas(inmuebleCreado.getCodigoInmueble());
        
       
         
         return inmuebleRepository.save(inmuebleCreado);
    }

    @Override
    public List<Inmueble> obtenerInmueblesCuotasVencidas() {
        
        return inmuebleRepository.findByInmueblesCuotaVencida();
    }

    @Override
    public Inmueble ObtenerInmueble(Long id) {
        Optional<Inmueble> optionalInmueble = inmuebleRepository.findById(id);
        return    optionalInmueble.orElse(null);
    
    }

    
    @Override
    @Transactional
    public void borrarInmueble(Long id) {
        
//        List<Cuota> cuotas = inmuebleService.ObtenerInmueble(id).getCuotas();
//           
//        for (Cuota cuota : cuotas) { //borrando las cuotas
//            cuotaRepository.deleteById(cuota.getCodigoCuota());
//        }
//        
//        claveRepository.deleteById(inmuebleService.ObtenerInmueble(id).getClaveCatastral().getCodigoClave()); //borando la clave
//        
        
        
        inmuebleRepository.deleteById(id);
        
    }

    @Override
    public Inmueble ActualizarInmueble(Inmueble inmueble) {
        Inmueble inmuebleActualizar = inmuebleService.ObtenerInmueble(inmueble.getCodigoInmueble());        
        inmuebleActualizar.setDuenios(inmueble.getDuenios());        
        inmuebleActualizar.setPrecioPorMetro(inmueble.getPrecioPorMetro() );
        
        
        return inmuebleRepository.save(inmuebleActualizar);
        }
    
    
    
    }
    

