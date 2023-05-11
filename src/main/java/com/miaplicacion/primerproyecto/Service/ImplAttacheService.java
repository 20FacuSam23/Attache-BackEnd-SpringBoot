
package com.miaplicacion.primerproyecto.Service;

import com.miaplicacion.primerproyecto.Entity.Attache;
import com.miaplicacion.primerproyecto.Repository.IAttacheRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class ImplAttacheService {
   @Autowired
   IAttacheRepository iAttacheRepository;
   
   public List<Attache> list(){
       return iAttacheRepository.findAll();   
   }
   
   public Optional <Attache> getOne(int id){
   return iAttacheRepository.findById(id);
   }
   
   public Optional <Attache> getByNombreA(String nombreA){
   return iAttacheRepository.findByNombreA(nombreA);
   }
   public void save(Attache attache){
   iAttacheRepository.save(attache);
   }
   public void delete(int id){
   iAttacheRepository.deleteById(id);
   }
   public boolean existsById(int id){
   return iAttacheRepository.existsById(id);
   }
   public boolean existsByNombreA(String nombreA){
   return iAttacheRepository.existsByNombreA(nombreA);
   }  
}
