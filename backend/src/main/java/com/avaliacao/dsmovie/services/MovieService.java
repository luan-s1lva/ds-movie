package com.avaliacao.dsmovie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avaliacao.dsmovie.dto.MovieDTO;
import com.avaliacao.dsmovie.entities.Movie;
import com.avaliacao.dsmovie.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository rep;
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pags) {
		Page<Movie> result = rep.findAll(pags);
		
		Page<MovieDTO> page = result.map(x ->  new MovieDTO(x));
		
		return page;
	}
	
	@Transactional(readOnly = true)
	public MovieDTO findById(Long id) {
		Movie result = rep.findById(id).get();
		
		MovieDTO dto = new MovieDTO(result);
		
		return dto;
	}
}
