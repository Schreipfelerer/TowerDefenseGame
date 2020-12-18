package de.game.main;
import de.ben.engine.Renderer;

import java.util.ArrayList;

import de.ben.engine.GameContainer;
import de.ben.engine.GameObject;
import de.ben.engine.Input;

public class Tower extends GameObject{
	
	private int damage = 10;
	private Game game;
	private GameManager gm;
	private int speed = 5;
	private int range = 800;
	private float timeSinceLastShoot = -1;
	
	public Tower(String Tag, float posX, float posY, int width, int height, Game game, GameManager gm) {
		this.game = game;
		this.gm = gm;
		this.tag = Tag;
		this.width = width;
		this.height = height;
		this.posX = posX;
		this.posY = posY;
		System.out.print("Tower");
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
	public boolean clicked(GameContainer gc, Input arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void collision(GameContainer gc, GameObject arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer gc, Renderer r) {
		r.drawFilledRect((int)this.posX, (int)this.posY, this.width, this.height, 0xffe07b39);
	}

	@Override
	public void update(GameContainer gc, float dt) {
		if(timeSinceLastShoot == -1) {
			ArrayList<Enemy> allEnemies = this.game.getEnemielist();
			Enemy closestEnemy = null;
			float closestEnemyDistance = Float.MAX_VALUE;
			for(int i = 0; i < allEnemies.size(); i++){
				Enemy e = allEnemies.get(i);
				float dx = (posX+(width/2))  - e.getPosX();
				float dy = (posY+(height/2)) - e.getPosY();
				float d = (float) Math.sqrt((dx*dx)+(dy*dy));
				if(closestEnemyDistance > d){
					closestEnemy = e;
					closestEnemyDistance = d;
				}
			}
			
			if(this.range >= closestEnemyDistance){
				if(closestEnemy != null) {
					timeSinceLastShoot = 0;
					System.out.println("Boom");
					Bullet b = new Bullet(closestEnemy, (posX+(width/2)), (posY+(height/2)), "E"+game.getBulletCounter());
					gm.registerNewGameObject(b);
					game.incrementBulletCounter();
				}
			}
		}
		else{
			timeSinceLastShoot += dt;
			if(10/speed <= timeSinceLastShoot){
				timeSinceLastShoot = -1;
			}
		}
			
	}
}