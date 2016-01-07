package de.krien.game.survivalists.model.entities;

import java.util.ArrayList;
import java.util.List;

import de.krien.game.survivalists.model.entities.player.Player;

public enum GameEntities {

	INSTANCE();

	private List<IGameEntity> entityList;

	private GameEntities() {
		entityList = new ArrayList<>();
		Player player = new Player();
		entityList.add(player);
	}

	public List<IGameEntity> getEntityList() {
		return entityList;
	}

	public void setEntityList(List<IGameEntity> entityList) {
		this.entityList = entityList;
	}

}
