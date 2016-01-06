package de.krien.game.survivalists.controller.game;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class GraphicsContextFactory {

	public static GraphicsContext createGraphicsContext() {
		Group root = GameReferences.INSTANCE.getRoot();
		removeOldCanvas(root);
		GraphicsContext graphicsContext = createNewGraphicsContext();
		return graphicsContext;
	}

	public static GraphicsContext createNewGraphicsContext() {
		Group root = GameReferences.INSTANCE.getRoot();
		Canvas canvas = new Canvas(root.getScene().getHeight(), root.getScene().getWidth());
		GraphicsContext graphicalContext = canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);
		return graphicalContext;
	}

	private static void removeOldCanvas(Group root) {
		if (root.getChildren().size() > 0) {
			root.getChildren().clear();
		}
	}
	
}
