package de.game.main;

public class WaveManager {
	private int enemiesToSpawn = 0;
	private final float SPAWN_EVERY_X_SECS = 1;
	private float sinceLastSpawn = 0;
	private Game g;
	private Board b;
	private int EnemyIndex = 0;
	public boolean isRunning = false;
	
	public WaveManager(Game game, Board board) {
		this.g = game;
		this.b = board;
	}
	
	public void startNewWave(){
		enemiesToSpawn = 8;
	}
	
	public void update(float dt){
		if(enemiesToSpawn > 0) {
			sinceLastSpawn = sinceLastSpawn + dt;
			while(sinceLastSpawn >= SPAWN_EVERY_X_SECS){
				sinceLastSpawn = sinceLastSpawn-SPAWN_EVERY_X_SECS;
				if(enemiesToSpawn != 0){
					isRunning = true;
					g.spawnEnemy(new Enemy("E"+EnemyIndex, b));
					EnemyIndex++;
					enemiesToSpawn--;
				}
			}
		}
	}
}
