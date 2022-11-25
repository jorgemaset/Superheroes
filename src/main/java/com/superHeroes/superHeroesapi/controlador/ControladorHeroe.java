package com.superHeroes.superHeroesapi.controlador;

import com.superHeroes.superHeroesapi.modelos.Heroe;
import com.superHeroes.superHeroesapi.repositorio.RepositorioHeroe;
import com.superHeroes.superHeroesapi.servicios.ServicioHeroe;
import com.superHeroes.superHeroesapi.servicios.ServicioHeroeImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/heroes")
@AllArgsConstructor
public class ControladorHeroe {

    private final ServicioHeroe servicioHeroe;

    @PostMapping
    public ResponseEntity guardarHeroe(@RequestBody Heroe heroe){
        return new ResponseEntity(servicioHeroe.guardarHeroe(heroe), HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Heroe>> getHeroes() {
        var heroes = servicioHeroe.findAllHeroes();
        return new ResponseEntity<>(heroes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity obtenerHeroe(@PathVariable("id") Long idHeroe){
        return new ResponseEntity(servicioHeroe.obtenerHeroe(idHeroe), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity modificarHeroe(@PathVariable("id") Long idHeroe, @RequestBody Heroe heroe){
        return new ResponseEntity(servicioHeroe.heroeModificado(idHeroe, heroe), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarHeroe(@PathVariable("id") Long idHeroe){
        Boolean respuesta = servicioHeroe.eliminarHeroe(idHeroe);
        if(respuesta == true){
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
