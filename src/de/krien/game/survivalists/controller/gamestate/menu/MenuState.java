package de.krien.game.survivalists.controller.gamestate.menu;

import de.krien.game.survivalists.controller.gamestate.IGameState;
import de.krien.game.survivalists.controller.input.InputHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public enum MenuState implements IGameState {

	INSTANCE;
	
	private EMenuEntry activeMenuEntry = EMenuEntry.PLAY;
	private static final int DISTANCE = 50;

	public void draw(GraphicsContext graphicalContext) {
		int count = 0;
		for (EMenuEntry menuEntry : EMenuEntry.values()) {
			// int positionX = getTextPositionX(graphics, menuEntry);
			// int positionY = getTextPositionY(graphics, menuEntry,
			// EMenuEntry.values().length, count++);

			if (menuEntry == activeMenuEntry) {
				graphicalContext.setFill(Color.RED);
			} else {
				graphicalContext.setFill(Color.BLUE);
			}
			graphicalContext.fillText(menuEntry.getText(), 100, 100*(++count));
		}
	}

	public void update(float secondsElapsed) {

	}

	// private int getTextPositionX(Graphics2D graphics, EMenuEntry menuEntry) {
	// int screenWidth = ScreenSettings.getInstance().getScreenWidth();
	// int textWidth =
	// graphics.getFontMetrics().stringWidth(menuEntry.getText());
	// int result = (screenWidth / 2) - (textWidth / 2);
	// return result;
	// }
	//
	// private int getTextPositionY(Graphics2D graphics, EMenuEntry menuEntry,
	// int size, int count) {
	// int screenHeight = ScreenSettings.getInstance().getScreenHeight();
	// int textHeight = getTextHeight(graphics, menuEntry.getText());
	// int blockSize = textHeight * size + DISTANCE * (size - 1);
	// int topPosition = (screenHeight/2) + (blockSize/2);
	// int result = topPosition + (DISTANCE + textHeight) * count;
	// return result;
	// }
	//
	// private int getTextHeight(Graphics2D graphics, String text) {
	// Font font = graphics.getFont();
	// FontRenderContext fontRenderContext =
	// graphics.getFontMetrics().getFontRenderContext();
	// GlyphVector glyphVector = font.createGlyphVector(fontRenderContext,
	// text);
	// int textHeight = (int) glyphVector.getVisualBounds().getHeight();
	// return textHeight;
	// }
}
