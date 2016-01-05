package de.krien.game.survivalists.controller.gamestate.play;

import de.krien.game.survivalists.controller.gamestate.IGameState;
import javafx.scene.canvas.GraphicsContext;

public enum PlayState implements IGameState {

	INSTANCE;
	
	public int pos_X = 50;
	public int pos_Y = 50;
	
	public int width = 25;
	public int height = 25;
	
	boolean move_X = true;
	boolean move_Y = true;

	public void draw(GraphicsContext graphicalContext) {
		
		graphicalContext.fillOval(pos_X, pos_Y, width, height);
		
	}

	public void update(float secondsElapsed) {
		if(move_X) {
			pos_X++;
		} else {
			pos_X--;
		}
		
		if(move_Y) {
			pos_Y++;
		} else {
			pos_Y--;
		}
		
		if(pos_X > 250) {
			move_X = false;
		}
		if(pos_X < 50) {
			move_X = true;
		}
		
		if(pos_Y > 250) {
			move_Y = false;
		}
		if(pos_Y < 50) {
			move_Y = true;
		}
		
	}
}
