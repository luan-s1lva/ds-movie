package com.avaliacao.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avaliacao.dsmovie.dto.MovieDTO;
import com.avaliacao.dsmovie.dto.ScoreDTO;
import com.avaliacao.dsmovie.entities.Movie;
import com.avaliacao.dsmovie.entities.Score;
import com.avaliacao.dsmovie.entities.User;
import com.avaliacao.dsmovie.repositories.MovieRepository;
import com.avaliacao.dsmovie.repositories.ScoreRepository;
import com.avaliacao.dsmovie.repositories.UserRepository;

@Service
public class ScoreService {

	@Autowired
	private MovieRepository movieRep;
	
	@Autowired
	private UserRepository userRep;
	
	@Autowired
	private ScoreRepository scoreRep;
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		
		User user = userRep.findByEmail(dto.getEmail());
		
		if(user == null) {
			
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRep.saveAndFlush(user);
		}
		
		Movie movie = movieRep.findById(dto.getMovieId()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		
		score = scoreRep.saveAndFlush(score);
		
		double sum = 0.0;
		for(Score s : movie.getScores()) {
			sum = sum+s.getValue();
		}
		
		double agv = sum / movie.getScores().size();
		
		movie.setScore(agv);
		movie.setCount(movie.getScores().size());
		
		movie = movieRep.save(movie);
		
		return new MovieDTO(movie);
	}
}
