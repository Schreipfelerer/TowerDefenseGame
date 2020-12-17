package de.game.main;

import de.ben.engine.AbstractGame;
import de.ben.engine.GameContainer;
import de.ben.engine.Renderer;

public class GameManager extends AbstractGame{
	
	private Game game;
	
	@Override
	public void initialize(GameContainer gc) {
		// TODO Auto-generated method stub
		game = new Game(this);
	}

	@Override
	public void render(GameContainer gc, Renderer r) {
		// TODO Auto-generated method stub
	}

	@Override
	public void update(GameContainer gc, float dt) {
		// TODO Auto-generated method stub
		game.update(dt);
	}
	
	public static void main(String[] args) {
		GameContainer gc = new GameContainer(new GameManager());
		gc.setScale(1f);
		gc.setWidth(1300);
		gc.setHeight(768);
		gc.start();
	}	
}
