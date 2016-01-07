package de.krien.game.survivalists.model.entities;

import de.krien.game.survivalists.model.entities.player.Player;

public enum EGameEntity {

	PLAYER(Player.class), NPC(null), ACTIVE_OBJECT(null), PASSIVE_OBJECT(null);

	private Class<? extends IGameEntity> entityClass;

	private EGameEntity(Class<? extends IGameEntity> entityClass) {
		this.entityClass = entityClass;
	}

	public Class<? extends IGameEntity> getEntityClass() {
		return entityClass;
	}

}
