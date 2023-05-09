/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.realstatefinal.services;

import com.realstatefinal.models.Inmueble;
import java.util.List;
import java.util.Set;

/**
 *
 * @author erick
 */

public interface TipoService {
    
    Set<Inmueble> obtenerInmueblesTipo(Long id);
    
}
