package de.game.main;
import de.ben.engine.Renderer;
import de.ben.engine.GameContainer;
import de.ben.engine.GameObject;
import de.ben.engine.Input;

public class Tower extends GameObject{
	
	private int damage;
	private int speed;
	
	public Tower(String Tag, float posX, float posY, int width, int height) {
		this.tag = Tag;
		this.width = width;
		this.height = height;
		this.posX = posX;
		this.posY = posY;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
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
		r.drawFilledRect((int)this.posX, (int)this.posY, this.width, this.height, 0xffe07b39);
	}

	@Override
	public void update(GameContainer arg0, float arg1) {
		// TODO Auto-generated method stub
		
	}
}