package de.game.main;

import de.ben.engine.GameContainer;
import de.ben.engine.Input;
import de.ben.engine.Renderer;
import de.ben.engine.GameObject;

public class Enemy extends GameObject{
	private int health = 50;
	private int speed = 80;
	private int damage = 3;
	private int indexOfPoints;
	private Board b;
	private int[] nextPoint;
	private Game game;
	
	public Enemy(String tag, Board b, Game g) {
		this.tag = tag;
		this.width = 50;
		this.height = 50;
		this.posX = 10f;
		this.posY = 10f;
		this.indexOfPoints = 0;
		this.b = b;
		this.nextPoint = b.getPunkte(indexOfPoints);
		this.game = g;
	}

	@Override
	public void render(GameContainer gc, Renderer render) {
		//long ct = System.nanoTime();
		render.drawFilledRect((int)posX-(width/2), (int)posY-(height/2), width, height, 0xffff9f19);
		//ct = System.nanoTime() - ct;
		//System.out.println(this.tag+"_R: "+ct);
	}
	@Override
	public void update(GameContainer arg0, float dt) {
		
		//long ct = System.nanoTime();
		if(nextPoint == null) {
			this.setDead(true);
			return;
		}
		if(nextPoint[0]*100+50 > this.posX) {
			this.posX = this.posX + (dt) * speed;
		}
		if(nextPoint[1]*100+50 > this.posY) {
			this.posY = this.posY + (dt) * speed;
		}
		if(nextPoint[1]*100+50 < this.posY && nextPoint[0]*100+50 < this.posX) {
			nextPoint = b.getPunkte(indexOfPoints);
			this.indexOfPoints++;
		}
		//ct = System.nanoTime() - ct;
		//System.out.println(this.tag+": "+ct);
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

	
	public void damage(int damage){
		this.health -= damage;
		if(this.health <= 0) {
			this.kill();
		}
	}
	
	public void kill(){
		game.getEnemielist().remove(this);
		this.setDead(true);
	}
}
