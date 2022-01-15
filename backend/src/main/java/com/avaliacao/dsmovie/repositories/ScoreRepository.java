package com.avaliacao.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avaliacao.dsmovie.entities.Score;
import com.avaliacao.dsmovie.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK>{

	
}
