/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.realstatefinal.servicesImp;

import com.realstatefinal.models.ClaveCatastral;
import com.realstatefinal.repositories.ClaveCatastralRepository;
import com.realstatefinal.services.ClaveCatastralService;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author erick
 */
@Service
public class ClaveCatastralServiceImp  implements ClaveCatastralService, Serializable{
    @Autowired
    ClaveCatastralRepository  claveCatastralRepository;
    
    
    @Override
    public ClaveCatastral crearClaveCatastral(ClaveCatastral clave) {
        return claveCatastralRepository.save(clave);
    }
    
}
