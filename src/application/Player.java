package application;

public class Player extends GameObject {
	private final int speedCorrection = 4;	// スピードの補正値(カーソルに付近の速度が遅すぎたため)
	Player(double x, double y, double radius, double maxSpeed, boolean isMoving){
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
		double speedRate;
		double newVecterAbs = Math.pow(newVectorX * newVectorX + newVectorY * newVectorY, 0.5) / speedCorrection;
		if (maxSpeed < newVecterAbs) {
			speedRate = maxSpeed / newVecterAbs;
		} else {
			speedRate = speedCorrection;
		}
		vectorX = newVectorX * speedRate;
		vectorY = newVectorY * speedRate;
	}
}
