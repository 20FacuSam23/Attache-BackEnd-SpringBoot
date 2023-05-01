
package com.miaplicacion.primerproyecto.Security.Service;

import com.miaplicacion.primerproyecto.Security.Entity.Usuario;
import javax.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.miaplicacion.primerproyecto.Security.Repository.iUsuarioRepository;

@Service
@Transactional

public class UsuarioService {
    @Autowired
    iUsuarioRepository iusuarioRepository;
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
    return iusuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    public boolean existsByEmail(String email){
    return iusuarioRepository.existsByEmail(email);
    }
    public void save(Usuario usuario){
    iusuarioRepository.save(usuario);
    }
}
