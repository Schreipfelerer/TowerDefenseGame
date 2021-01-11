package de.game.main;

import de.ben.engine.GameContainer;
import de.ben.engine.GameObject;
import de.ben.engine.Input;
import de.ben.engine.Renderer;
import de.ben.engine.gfx.Image;

public class WegPlatz extends BoardPlatz{
	
	private Image i;

	public WegPlatz(String tag, float posX, float posY, int width, int height, GameManager gm, Game g) {
		super(tag, posX, posY, width, height, gm, g);
		i = new Image("/weg.png");
	}

	@Override
	public boolean clicked(GameContainer arg0, Input arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void collision(GameContainer arg0, GameObject arg1) {
		// TODO Auto-generated method stub
	}

	@Override
	public void render(GameContainer arg0, Renderer r) {
		r.drawImage(i, (int) posX, (int) posY);
	}

	@Override
	public void update(GameContainer arg0, float arg1) {
		// TODO Auto-generated method stub
	}

}
