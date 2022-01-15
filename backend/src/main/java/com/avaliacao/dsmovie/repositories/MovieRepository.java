package com.avaliacao.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avaliacao.dsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

	
}
