package com.example.tuneHub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tuneHub.entities.Songs;
import com.example.tuneHub.repositories.SongsRepository;
@Service
public class SongsServiceImplimentation implements SongsService 
{

	@Autowired
	SongsRepository srepo;
	
	@Override
	public String addSongs(Songs song) 
	{
		srepo.save(song);
		return "Song is added";
	}

	@Override
	public boolean songExists(String name) {

		Songs song=srepo.findByName(name);
		if(song==null)
		{
			return false;

		}
		else {
			return true;
		}
	}

	@Override
	public List<Songs> fetchAllSongs() {

		List<Songs> songlist=srepo.findAll();
		return songlist;
	}

}
