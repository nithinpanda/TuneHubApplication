package com.example.tuneHub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.tuneHub.entities.PlayList;
import com.example.tuneHub.entities.Songs;
import com.example.tuneHub.services.PlayListService;
import com.example.tuneHub.services.SongsService;

@Controller
public class PlayListController {
	
	@Autowired
	PlayListService pserv;
	
	@Autowired
	SongsService sserv;
	
	@GetMapping("/createPlaylist")
 public String createPlayList(Model model)
 {
//	 fetching the songs using Song Service
	 List<Songs> songslist=sserv.fetchAllSongs();
	 
	 // adding the Songs in the model
	 model.addAttribute("songslist", songslist);
	 
	 // sending createPlaylist
	 return "createPlaylist";
 }
	@PostMapping("/addPlayList")
	public String addPlayList(@ModelAttribute PlayList playlist) {
		
		return "playListSuccess";
	}

}
