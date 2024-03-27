package com.simone.recipesharing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping
	public String homeController() {
		return "Benvenuto nel sito";
	}

	
}
