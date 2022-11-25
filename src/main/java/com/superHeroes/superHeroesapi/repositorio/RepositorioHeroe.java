package com.superHeroes.superHeroesapi.repositorio;

import com.superHeroes.superHeroesapi.modelos.Heroe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioHeroe extends JpaRepository<Heroe,Long> {

}
