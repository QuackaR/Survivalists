package de.krien.game.survivalists.controller.game;

import javafx.scene.Group;

public enum GameReferences {

	INSTANCE;
	
	private Group root;
	
	private GameReferences() {
		root = new Group();
	}
	


	public Group getRoot() {
		return root;
	}

}
