package de.game.main;

import de.ben.engine.GameObject;

public abstract class BoardPlatz extends GameObject{

	protected Game g;
	protected GameManager gm;

	public BoardPlatz(String tag, float posX, float posY, int width, int height, GameManager gm, Game g) {
		this.g = g;
		this.gm = gm;
		this.tag = "";
		this.width = width;
		this.height = height;
		this.posX = posX;
		this.posY = posY;
		gm.registerNewGameObject(this);
	}
	
}
