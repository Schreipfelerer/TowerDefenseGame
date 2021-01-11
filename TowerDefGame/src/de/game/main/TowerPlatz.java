package de.game.main;

import de.ben.engine.GameContainer;
import de.ben.engine.GameObject;
import de.ben.engine.Input;
import de.ben.engine.Renderer;

public class TowerPlatz extends BoardPlatz{

	private Tower mountedTower = null;

	public TowerPlatz(String tag, float posX, float posY, int width, int height, GameManager gm, Game g) {
		super(tag, posY, posY, height, height, gm, g);
	}
	
	@Override
	public boolean clicked(GameContainer arg0, Input arg1) {
		if(!isMounted()){
			mountedTower = new Tower(this.tag+"_T",this.posX, this.posY, this.width, this.height, this.g, this.gm);
			this.gm.registerNewGameObject(mountedTower);
		}
		return false;
	}

	@Override
	public void collision(GameContainer arg0, GameObject arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer gc, Renderer r) {
		if(!isMounted()){
			r.drawFilledRect((int)this.posX, (int)this.posY, this.width, this.height, 0xffb97455);
		}
		
	}

	@Override
	public void update(GameContainer arg0, float arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean isMounted() {
		return mountedTower != null;
	}

}
