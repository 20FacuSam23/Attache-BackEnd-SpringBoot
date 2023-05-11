
package com.miaplicacion.primerproyecto.Repository;

import com.miaplicacion.primerproyecto.Entity.Attache;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAttacheRepository extends JpaRepository<Attache, Integer>{
    public Optional<Attache>findByNombreA(String nombreA);
    public boolean existsByNombreA(String nombreA);
}
