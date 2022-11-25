package com.superHeroes.superHeroesapi.servicios;

import com.superHeroes.superHeroesapi.modelos.Heroe;
import com.superHeroes.superHeroesapi.repositorio.RepositorioHeroe;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServicioHeroeImpl implements ServicioHeroe {

    private final RepositorioHeroe repositorioHeroe;

    @Override
    public Heroe guardarHeroe(Heroe heroe) {
        return repositorioHeroe.save(heroe);
    }

    @Override
    public Heroe obtenerHeroe(Long idheroe) {
        return repositorioHeroe.findById(idheroe).orElseThrow(()-> {throw new RuntimeException();});
    }

    public List<Heroe> findAllHeroes() {
        return repositorioHeroe.findAll();
    }


    @Override
    public Heroe heroeModificado(Long idHeroe, Heroe heroe) {
        Heroe heroeBuscado = repositorioHeroe.findById(idHeroe).get();
        heroeBuscado.setNombre(heroe.getNombre());
        heroeBuscado.setPoder(heroe.getPoder());
        return repositorioHeroe.save(heroeBuscado);

    }

    @Override
    public Boolean eliminarHeroe(Long idHeroe) {
        try{
            repositorioHeroe.deleteById(idHeroe);
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
