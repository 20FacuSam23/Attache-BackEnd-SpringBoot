package com.miaplicacion.primerproyecto.Controller;

import com.miaplicacion.primerproyecto.Dto.AttacheDto;
import com.miaplicacion.primerproyecto.Entity.Attache;
import com.miaplicacion.primerproyecto.Security.Controller.Mensaje;
import com.miaplicacion.primerproyecto.Service.ImplAttacheService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attache")
@CrossOrigin(origins = "http://localhost:4200")
public class AttacheController {

    @Autowired
    ImplAttacheService implAttacheService;

    @GetMapping("/lista")
    @CrossOrigin(origins = "htp://localhost:4200")
    public ResponseEntity<List<Attache>> list() {
        List<Attache> list = implAttacheService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PutMapping("/create")
    public ResponseEntity<?> create(@RequestBody AttacheDto attacheDto) {
        if (StringUtils.isBlank(attacheDto.getNombreA())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (implAttacheService.existsByNombreA(attacheDto.getNombreA())) {
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        }
        Attache attache = new Attache(attacheDto.getNombreA(), attacheDto.getDescripcionA());
        implAttacheService.save(attache);
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody AttacheDto attacheDto) {
        if (!implAttacheService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        if (implAttacheService.existsByNombreA(attacheDto.getNombreA()) && implAttacheService
                .getByNombreA(attacheDto.getNombreA()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(attacheDto.getNombreA())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Attache attache = implAttacheService.getOne(id).get();
        attache.setNombreA(attacheDto.getNombreA());
        attache.setDescripcionA(attacheDto.getDescripcionA());

        implAttacheService.save(attache);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!implAttacheService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        implAttacheService.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);

    }

}
