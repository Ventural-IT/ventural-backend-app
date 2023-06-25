package com.hishab.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hishab.app.exceptionhandling.PlayerAlreadyExistsException;
import com.hishab.app.exceptionhandling.PlayerNotFoundException;
import com.hishab.app.model.Player;
import com.hishab.app.persistence.PersistenceDB;
import com.hishab.app.repository.PlayerRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	PlayerRepository playerRepository;

	@Override
	public Player addPlayer(Player player) {

		log.info("Start to add new player : {}", player.getName());

		Boolean isExists = PersistenceDB.playerList.stream()
				.anyMatch(p -> p.getName().equals(player.getName()) || 
						p.getPlayerId().equals(player.getPlayerId()));

		if (isExists) {
			throw new PlayerAlreadyExistsException("Player Is Already Exists");
		}

		Player savedPlayer = playerRepository.addPlayer(player);

		log.info("End to add new player : {}", player.getName());
		return savedPlayer;
	}

	@Override
	public List<Player> getPlayers() {

		List<Player> players = playerRepository.getPlayers();
		if (players.isEmpty()) {
			throw new PlayerNotFoundException("No Player Found");
		}
		return playerRepository.getPlayers();
	}
}
