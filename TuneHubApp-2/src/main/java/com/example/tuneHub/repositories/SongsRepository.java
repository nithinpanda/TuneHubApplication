package com.example.tuneHub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tuneHub.entities.Songs;

public interface SongsRepository extends JpaRepository<Songs, Integer> {

	public Songs findByName(String name);	
}
