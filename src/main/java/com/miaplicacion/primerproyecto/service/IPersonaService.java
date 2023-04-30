package com.miaplicacion.primerproyecto.service;

import com.miaplicacion.primerproyecto.model.Persona;
import java.util.List;

public interface IPersonaService {
    
    public List<Persona> getPersona();
    public void savePersona (Persona persona);
    public void deletePersona(Long id);
    public Persona findPersona (Long id);
}
