package com.hishab.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hishab.app.service.DiceService;

@RestController
public class WelcomeController {

	@Autowired
	private DiceService diceService;
	
	@GetMapping(value = "/")
	public ResponseEntity<?> welcome() {
		return new ResponseEntity<>("Welcome to Hishab Game App-", HttpStatus.OK);

	}
	@GetMapping(value = "/api/1.0/dice")
	public ResponseEntity<Integer> getDiceScore() {
		return new ResponseEntity<>(diceService.getScoreValue(), HttpStatus.OK);
	}
}
