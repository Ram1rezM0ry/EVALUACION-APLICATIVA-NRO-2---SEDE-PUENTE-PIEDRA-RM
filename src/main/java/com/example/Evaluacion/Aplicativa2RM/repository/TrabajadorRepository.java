
package com.example.Evaluacion.Aplicativa2RM.repository;

import com.example.Evaluacion.Aplicativa2RM.model.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabajadorRepository extends JpaRepository<Trabajador, Long> {
    
}