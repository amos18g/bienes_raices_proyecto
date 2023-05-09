/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.realstatefinal.repositories;

import com.realstatefinal.models.Cuota;
import com.realstatefinal.models.Duenio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author erick
 */
@Repository
public interface DuenioRepository  extends JpaRepository <Duenio, Long>{
    
}
