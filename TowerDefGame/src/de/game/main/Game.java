package de.game.main;
import java.util.ArrayList;

import de.ben.engine.*;

/**
 * Das Spiel oder so?
 * 
 * @author Thabo
 * @version 1.0
 */

public class Game{
    private int leben;
    private int geld;
    private ArrayList<Enemy> enemielist = new ArrayList<Enemy>();
    private GameManager gm;
    private WaveManager wm;
    private Board b;
    
    public Game(GameManager gm){
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
    
}
