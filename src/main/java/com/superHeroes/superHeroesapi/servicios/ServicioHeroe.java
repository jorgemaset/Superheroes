package com.superHeroes.superHeroesapi.servicios;

import com.superHeroes.superHeroesapi.modelos.Heroe;

import java.util.List;

public interface ServicioHeroe {
    Heroe guardarHeroe(Heroe heroe);
    Heroe obtenerHeroe(Long idheroe);

    Heroe heroeModificado(Long idHeroe, Heroe heroe);
    Boolean eliminarHeroe(Long idHeroe);


    List<Heroe> findAllHeroes();
}
