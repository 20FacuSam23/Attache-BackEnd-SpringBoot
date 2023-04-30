
package com.miaplicacion.primerproyecto.Security.Repository;

import com.miaplicacion.primerproyecto.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository <Persona, Long>{
    
}
