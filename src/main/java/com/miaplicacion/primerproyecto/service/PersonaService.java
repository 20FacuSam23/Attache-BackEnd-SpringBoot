
package com.miaplicacion.primerproyecto.service;

import com.miaplicacion.primerproyecto.model.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.miaplicacion.primerproyecto.Security.Repository.IPersonaRepository;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    public IPersonaRepository persoRepo;
    
    
    
    @Override
    public List<Persona> getPersona() {
        return persoRepo.findAll();
    }

    @Override
    public void savePersona(Persona per) {
        persoRepo.save(per);
    }

    @Override
    public void deletePersona(Long id) {
        persoRepo.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        return persoRepo.findById(id).orElse(null);
    }
    
   
    
}
