package application;

public class Enemy extends GameObject {
	private final int speedCorrection = 60000;	// スピードの補正値(60000 or 400)
	Enemy(double x, double y, double radius, double maxSpeed, boolean isMoving){
		this.centerX = x;
		this.centerY = y;
		this.radius = radius;
		this.isMoving = true;
		this.vectorX = 0;
		this.vectorY = 0;
		this.maxSpeed = maxSpeed;
	}
	
	@Override
	protected void updateVector(double newVectorX, double newVectorY) {
		vectorX = newVectorX;
		vectorY = newVectorY;
	}
	
	/**
	 * 移動ベクトルの決定
	 * 
	 * @param mouseX
	 * @param mouseY
	 * @param flameTime
	 */
	public void updateEnemy(Player player, double windowSizeX, double windowSizeY, double flameTime) {
		if (isMoving) {
			double wallVectorX = windowSizeX / 2 - centerX;
			double wallVectorY = windowSizeY / 2 - centerY;
			double distanceFromPlayer = Math.max(distance(player), 0.1);
			// speedCorrection / distanceFromPlayer or speedCorrection
			double fromPlayerVectorX = (centerX - player.centerX) / distanceFromPlayer * speedCorrection / distanceFromPlayer;
			double fromPlayerVectorY = (centerY - player.centerY) / distanceFromPlayer * speedCorrection / distanceFromPlayer;
			updateVector(wallVectorX + fromPlayerVectorX, wallVectorY + fromPlayerVectorY);
			move(flameTime);
		}
	}
}
