package com.openwebinars.movieadvisor.dao;

import java.util.Collection;

import com.openwebinars.movieadvisor.model.Film;

public interface FilmDao {

	public Film findById(long id);
	public Collection<Film> findAll();
	public void create(Film film);
	public void edit(Film film);
	public void delete(long id);
}
