package de.krien.game.survivalists.controller.gamestate;

import de.krien.game.survivalists.controller.input.InputHandler;
import javafx.scene.canvas.GraphicsContext;

public interface IGameState {

    void draw(GraphicsContext graphicalContext);
    void update(float secondsElapsed);
    
}
