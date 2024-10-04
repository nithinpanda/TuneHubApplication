package com.example.tuneHub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.tuneHub.entities.Songs;
import com.example.tuneHub.services.SongsService;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SongsController {
	@Autowired
	SongsService songserv;
	
	@PostMapping("/addSongs")
	public String addSongs(@ModelAttribute Songs song )
	{
		boolean status=songserv.songExists(song.getName());
		if(status==false) {
			songserv.addSongs(song);
			return "songSuccess";
		}
	
		else {
			return "songFail";
		}
	}
	
	@GetMapping("/map-viewSongs")
	public String viewSongs(Model model) {
		List<Songs> songslist=songserv.fetchAllSongs();
		 model.addAttribute("songslist", songslist);
		 
		 		return "displaySongs";
	}
	
	@GetMapping("/viewSongs")
	public String viewCustomerSongs(Model model) {
		boolean primeCustomerStatus=true;
		
		if(primeCustomerStatus==true) {
			List<Songs> songslist=songserv.fetchAllSongs();
			 model.addAttribute("songslist", songslist);
			 
			 		return "displaySongs";
			
		}
		else {
			return "makePayment";
		}
		
	}
	
	

}
