package application;

public class Bullet extends GameObject {
	public boolean isOutOfCanvas;
	Bullet(double x, double y, double vectorX, double vectorY, double radius, double maxSpeed, boolean isMoving){
		this.centerX = x;
		this.centerY = y;
		this.radius = radius;
		this.isMoving = true;
		double speedRate = maxSpeed / getVectorAbs(vectorX, vectorY);
		this.vectorX = vectorX * speedRate;
		this.vectorY = vectorY * speedRate;
		this.maxSpeed = maxSpeed;
		this.isOutOfCanvas = false;
	}
	
	@Override
	protected void move(double flameTime) {
		centerX = centerX + vectorX * flameTime;
		centerY = centerY + vectorY * flameTime;
		if (getX() < -radius / 2 || getX() > 800 || getY() < -radius / 2 || getY() > 600) {
			isOutOfCanvas = true;
		}
	}
	
	public void updateBullet(double flameTime) {
		move(flameTime);
	}
}
