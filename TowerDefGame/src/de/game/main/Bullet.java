package de.game.main;

import de.ben.engine.GameContainer;
import de.ben.engine.GameObject;
import de.ben.engine.Input;
import de.ben.engine.Renderer;

public class Bullet extends GameObject{
	private int damage = 10;
	private int speed = 500;
	private Enemy e;
	
	public Bullet(Enemy closestEnemy, float posX, float posY, String Tag) {
		this.tag = Tag;
		this.posX = posX-5;
		this.posY = posY-5;
		this.height = 10;
		this.width = 10;
		
		
		e = closestEnemy;
	}

	@Override
	public void render(GameContainer arg0, Renderer r) {
		r.drawFilledRect((int) this.getPosX(), (int) this.getPosY(), this.width, this.height, 0xffff0000); //WOW Ein Roter Punkt
	}

	@Override
	public void update(GameContainer arg0, float dt) {
		if(e.isDead()) {               // Wenn der getargete Gegner bereits Tod ist nicht mehr weiterfliegen
			this.setDead(true);
			return;
		}
		
		float dx = e.getPosX() - posX;
		float dy = e.getPosY() - posY;
		
		if(Math.abs(dx) + Math.abs(dy) >= (dt) * speed) {
			posX += (dx / (Math.abs(dx) + Math.abs(dy))) * (dt) * speed; // X Pos näher zum Gegner
			posY += (dy / (Math.abs(dx) + Math.abs(dy))) * (dt) * speed; // Y Pos näher zum Gegner
		}
		else{ // Wenn Gegner getroffen ist,  dann Ihm Schaden zufügen
			e.damage(this.damage);
			setDead(true);
		}
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
}
