/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.realstatefinal.services;

import com.realstatefinal.models.Inmueble;
import java.util.List;

/**
 *
 * @author erick
 */
public interface InmuebleService {
    void crearCuotas(Long codigoInmueble);
    
    Inmueble crearInmueble(Inmueble inmueble);
    
    
    Inmueble ActualizarInmueble(Inmueble inmueble);
    
    
    List<Inmueble> obtenerInmueblesCuotasVencidas();
    
    
    Inmueble ObtenerInmueble(Long id); 
    
    void borrarInmueble(Long id);
}
