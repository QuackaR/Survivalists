package de.krien.game.survivalists.controller.game;

import de.krien.game.survivalists.controller.gamestate.EGameState;
import de.krien.game.survivalists.controller.gamestate.menu.MenuState;
import de.krien.game.survivalists.controller.gamestate.play.PlayState;
import de.krien.game.survivalists.controller.input.InputHandler;
import javafx.scene.canvas.GraphicsContext;

public enum GameManager {

	INSTANCE;
	
    private EGameState gameState = EGameState.PLAY;

    public void draw(GraphicsContext graphicalContext) {
        switch (gameState) {
        case PLAY:
            PlayState.INSTANCE.draw(graphicalContext);
            break;
        case MENU:
            MenuState.INSTANCE.draw(graphicalContext);
            break;
        case SETTINGS:
//            settingsState.draw(graphicalContext);
            break;
        case QUIT:
            quitGame();
            break;
        }
    }

    public void update(float secondsElapsed) {
        switch (gameState) {
        case PLAY:
        	PlayState.INSTANCE.update(secondsElapsed);
            break;
        case MENU:
        	MenuState.INSTANCE.update(secondsElapsed);
            break;
        case SETTINGS:
//            settingsState.update();
            break;
        case QUIT:
            quitGame();
            break;
        }
    }
    
    private void quitGame() {
        System.exit(0);
    }
    
    public EGameState getGameState() {
        return gameState;
    }

    public void setGameState(EGameState gameState) {
        this.gameState = gameState;
    }

}
