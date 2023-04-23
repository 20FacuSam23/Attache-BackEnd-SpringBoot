package com.miaplicacion.primerproyecto.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String password;
    
    public Persona(){
    }
    
    public Persona(Long id, String email, String password){
    this.id = id;
    this.email = email;
    this.password = password;
    }
    
    
}
