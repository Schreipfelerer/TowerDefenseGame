package de.game.main;

import de.ben.engine.GameContainer;
import de.ben.engine.Input;
import de.ben.engine.Renderer;
import de.ben.engine.GameObject;


public class Board extends GameObject{
	
	final int X_SIZE = 13;
	final int Y_SIZE = 6;
	final int X_POS = 0;
	final int Y_POS = 0;
	private int[][] weg_punkte = {{0,0}, {0, 2}, {4, 2}, {4, 5}, {12, 5}};
	private TowerPlatz[][] boardPlätze;
	//private int[][][][] wege = new int[X_SIZE][Y_SIZE][30][2];
	
	public Board(GameManager gm, Game g) {
		boardPlätze = new TowerPlatz[X_SIZE][Y_SIZE]; 
		this.tag = "Board";
		for(int i = 0; i<X_SIZE; i++){
			for(int j = 0; j<Y_SIZE; j++){
				boardPlätze[i][j] = new TowerPlatz("TP."+(i + (j*Y_SIZE)), i*100+2+X_POS, j*100+2+Y_POS, 96, 96, gm, g);
			}
		}
	}
	
	@Override
	public boolean clicked(GameContainer arg0, Input arg1) {
		return false;
	}
	
	
	@Override
	public void collision(GameContainer arg0, GameObject arg1) {}
	
	@Override
	public void render(GameContainer gc, Renderer r) {
		for(int i = 0; i<X_SIZE; i++){
			for(int j = 0; j<Y_SIZE; j++){ // Zeichnet Schwarze Linine zwischen den Plätzen
				r.drawFilledRect(i*100+X_POS, j*100+Y_POS, 100, 1, 0xff000000);
				r.drawFilledRect(i*100+X_POS, (j+1)*100+Y_POS-1, 100, 1, 0xff000000);
				r.drawFilledRect(i*100+X_POS, j*100+Y_POS, 1, 100, 0xff000000);
				r.drawFilledRect((i+1)*100+X_POS-1, j*100+Y_POS, 1, 100, 0xff000000);
			}
		}
		
	}
	@Override
	public void update(GameContainer arg0, float arg1) {
		// TODO Auto-generated method stub
		
	}

	public int[] getPunkte(int index) {
		if(index >= this.weg_punkte.length) {
			return null;
		}
		return weg_punkte[index];
	}
	
	public boolean[][] getPassable(){
		boolean[][] tmp = new boolean[X_SIZE][Y_SIZE];
		for(int i = 0; i<X_SIZE; i++){
			for(int j = 0; j<Y_SIZE; j++){
				tmp[i][j] = !boardPlätze[i][j].isMounted();
			}
		}
		return tmp;
	}
	
	public void updateWegPunkte() {
		//boolean[][] pass = getPassable();
	}
}
