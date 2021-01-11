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
	private int[][] weg_punkte = new int[100][2];
	private BoardPlatz[][] boardPlätze;
	private final String[][] BOARD_BLUEPRINT = {{"W","W","W","W","W","W","W","T","T","T","W","W","W"},
												{"T","T","T","T","T","T","W","T","T","T","W","T","W"},
												{"T","W","W","W","W","W","W","W","W","T","W","T","W"},
												{"T","W","T","T","T","T","T","T","T","T","W","T","W"},
												{"T","W","W","W","W","W","W","W","W","W","W","T","W"},
												{"T","T","T","T","T","T","T","T","T","T","T","T","W"}};
	
	//private int[][][][] wege = new int[X_SIZE][Y_SIZE][30][2];
	
	public Board(GameManager gm, Game g) {
		boardPlätze = new TowerPlatz[X_SIZE][Y_SIZE]; 
		this.tag = "Board";
		for(int i = 0; i<X_SIZE; i++){
			for(int j = 0; j<Y_SIZE; j++){
				if(BOARD_BLUEPRINT[i][j].equalsIgnoreCase("T")) {
					boardPlätze[i][j] = new TowerPlatz("TP."+(i + (j*Y_SIZE)), i*100+2+X_POS, j*100+2+Y_POS, 96, 96, gm, g);
				}
				else if(BOARD_BLUEPRINT[i][j].equalsIgnoreCase("W")) {
					boardPlätze[i][j] = new WegPlatz("W."+(i + (j*Y_SIZE)), i*100+2+X_POS, j*100+2+Y_POS, 96, 96, gm, g);
				}
			}
		}
		weg_punkte[0][0] = -1;
		weg_punkte[0][1] = 0;
		int x = -1;
		int y = 0;
		String last = "None";
		for(int i = 1; i < 100; i++){
			if(BOARD_BLUEPRINT[x+1][y].equalsIgnoreCase("W") && !last.equalsIgnoreCase("Left")) {
				last = "Right";
				weg_punkte[i][0] = x;
				weg_punkte[i][1] = y;
				
			}
			else if(BOARD_BLUEPRINT[x][y-1].equalsIgnoreCase("W") && !last.equalsIgnoreCase("Up")) {
				last = "Down";
				weg_punkte[i][0] = x;
				weg_punkte[i][1] = y;
			}
			else if(BOARD_BLUEPRINT[x][y+1].equalsIgnoreCase("W") && !last.equalsIgnoreCase("Down")) {
				last = "Up";
				weg_punkte[i][0] = x;
				weg_punkte[i][1] = y;
			}
			else if(BOARD_BLUEPRINT[x-1][y].equalsIgnoreCase("W") && !last.equalsIgnoreCase("Right")) {
				last = "Left";
				weg_punkte[i][0] = x;
				weg_punkte[i][1] = y;
			}
			if(weg_punkte[i][0] == X_SIZE && weg_punkte[i][1] == Y_SIZE) {
				
				weg_punkte[i+1][0] = X_SIZE+1;
				weg_punkte[i+1][1] = Y_SIZE;
				weg_punkte[i+2][0] = -1;
				weg_punkte[i+2][1] = -1;
				break;
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
}
