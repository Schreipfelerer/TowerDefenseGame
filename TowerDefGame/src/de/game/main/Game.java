package de.game.main;
import java.util.ArrayList;

/**
 * Das Spiel oder so?
 * 
 * @author Thabo
 * @version 1.0
 */

public class Game{
    private int leben = 100;
    private int geld = 200;
    private ArrayList<Enemy> enemielist = new ArrayList<Enemy>();
    private GameManager gm;
    private WaveManager wm;
    private Board b;
    private int BulletCounter = 0;
    
    public Game(GameManager gm){
    	System.out.print("Start");
    	this.gm = gm;
    	b = new Board(gm, this);
    	gm.registerNewGameObject(b);
    	wm = new WaveManager(this, b);
    	wm.startNewWave();
    }
    
    public void update(float dt){
    	wm.update(dt);
    }
    
    public void spawnEnemy(Enemy e){
    	enemielist.add(e);
    	gm.registerNewGameObject(e);
    }
    
    public WaveManager getWm() {
		return wm;
	}
    
    public ArrayList<Enemy> getEnemielist(){
		return enemielist;
    }
    
    public int getBulletCounter() {
		return BulletCounter;
	}
    
    public void incrementBulletCounter() {
    	BulletCounter++;
    }
    
}
