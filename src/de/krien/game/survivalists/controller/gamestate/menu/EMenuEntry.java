package de.krien.game.survivalists.controller.gamestate.menu;

public enum EMenuEntry {

    PLAY("Play"), SETTINGS("Settings"), QUIT("Quit");

    private String text;

    private EMenuEntry(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
