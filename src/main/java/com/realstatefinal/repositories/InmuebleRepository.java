/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.realstatefinal.repositories;

import com.realstatefinal.models.Cuota;
import com.realstatefinal.models.Inmueble;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author erick
 */
@Repository
public interface InmuebleRepository  extends JpaRepository <Inmueble, Long>{

  @Query("SELECT i FROM Inmueble i INNER JOIN i.cuotas c WHERE c.descripcion = 'P' GROUP BY i.codigoInmueble HAVING COUNT(c) > 0")
  List<Inmueble> findByInmueblesCuotaVencida(); //obtener inmuebles con cuotas vencidas
    
}
