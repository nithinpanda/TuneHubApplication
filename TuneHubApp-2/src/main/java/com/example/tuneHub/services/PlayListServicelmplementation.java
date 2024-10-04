package com.example.tuneHub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tuneHub.repositories.PlayListRepository;

@Service
public class PlayListServicelmplementation implements PlayListService{
	
	@Autowired
	PlayListRepository prepo;
	
}
