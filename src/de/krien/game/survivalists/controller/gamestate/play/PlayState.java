package de.krien.game.survivalists.controller.gamestate.play;

import java.util.List;

import de.krien.game.survivalists.controller.game.GraphicsContextFactory;
import de.krien.game.survivalists.controller.gamestate.IGameState;
import de.krien.game.survivalists.model.entities.GameEntities;
import de.krien.game.survivalists.model.entities.IGameEntity;
import de.krien.game.survivalists.model.entities.util.PositionUtil;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.transform.Rotate;

public enum PlayState implements IGameState {

	INSTANCE;

	private void rotate(GraphicsContext gc, double angle, double px, double py) {
		Rotate r = new Rotate(angle, px, py);
		gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
	}

	public void draw() {
		List<IGameEntity> gameEntities = GameEntities.INSTANCE.getEntityList();
		GraphicsContextFactory.createGraphicsContext();
		
		for(IGameEntity entity : gameEntities) {
			GraphicsContext graphicsContext = GraphicsContextFactory.createNewGraphicsContext();
			rotate(
				graphicsContext, 
				entity.getRotation(), 
				PositionUtil.getCenterPosition(entity).getX(), 
				PositionUtil.getCenterPosition(entity).getY()
			);
			graphicsContext.drawImage(
				entity.getImage(), 
				entity.getPosition().getX(), 
				entity.getPosition().getY()
			);
		}

//		graphicsContext.strokeRect(player.getPosition().getX(), player.getPosition().getY(), player.getImage().getWidth(),player.getImage().getHeight());
//		GraphicsContext gc = GraphicsContextFactory.createNewGraphicsContext();
//		double mouseX = InputHandler.INSTANCE.getMousePosition().getX();
//		double mouseY = InputHandler.INSTANCE.getMousePosition().getY();
//		gc.fillOval(mouseX - 2 , mouseY - 2, 4, 4);
//		gc.fillOval(player.getCenterPosition().getX() - 2, player.getCenterPosition().getY() - 2, 4, 4);
//		gc.strokeLine(player.getCenterPosition().getX(), player.getCenterPosition().getY(), mouseX, mouseY);
	}

	public void update(float secondsElapsed) {
		List<IGameEntity> gameEntities = GameEntities.INSTANCE.getEntityList();
		for(IGameEntity entity : gameEntities) {
			entity.update();
		}
	}
}
