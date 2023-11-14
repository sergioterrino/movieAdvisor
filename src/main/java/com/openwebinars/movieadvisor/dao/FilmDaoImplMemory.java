package com.openwebinars.movieadvisor.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.openwebinars.movieadvisor.config.AppCongif;
import com.openwebinars.movieadvisor.model.Film;

//Este bean será de estereotipo = Repository
@Repository
public class FilmDaoImplMemory implements FilmDao {

	public List<Film> peliculas = new ArrayList<>();

	@Autowired
	private AppCongif appconfig;

	// cargamos las peliculas. Manejando el ciclo de vida de este Bean
	public void init() throws FileNotFoundException, IOException {
		peliculas = UtilFilmFileReader.readFile(appconfig.getFile(), appconfig.getSeparator(),
				appconfig.getListSeparator());
	}

	@Override
	public Film findById(long id) {
		//@formatter:off
		Optional<Film> result = peliculas
				.stream()
				.filter(f -> f.getId() == id)
				.findFirst();
		//@formatter:on
		return result.orElse(null);
	}

	@Override
	public Collection<Film> findAll() {
		return peliculas;
	}

	@Override
	public void create(Film film) {
		peliculas.add(film);
	}

	@Override
	public void edit(Film film) {
		int index = getIndexOf(film.getId());
		if(index != -1) peliculas.set(index, film);
	}

	@Override
	public void delete(long id) {
		int index = getIndexOf(id);
		if(index != -1) peliculas.remove(index);
	}
	
	private int getIndexOf(long id) {
		boolean finded = false;
		int index = 0;
		while(!finded && index < peliculas.size()) {
			if(peliculas.get(index).getId() == id) {
				finded = true;
			}else {
				index++;
			}
		}
		
		return (finded) ? index : -1 ;
	}

}
