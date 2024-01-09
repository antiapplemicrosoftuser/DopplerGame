package application;
import java.lang.Math;

public class GameObject {
	public double centerX;	// 位置(X)
	public double centerY;	// 位置(Y)
	public double radius;	// オブジェクトの半径
	public boolean isMoving;	// 移動しているかどうか
	public double vectorX;	// 移動ベクトル(X)
	public double vectorY;	// 移動ベクトル(Y)
	public double maxSpeed;	// オブジェクトの最高速度
	public double preX;	// 1つ前のフレームのXの値
	public double preY;	// 1つ前のフレームのYの値
	
	/**
	 * オブジェクトの位置更新
	 * 
	 * @param flameTime
	 */
	private void move(double flameTime) {
		centerX = Math.min(Math.max(centerX + vectorX * flameTime, 0), 800);
		centerY = Math.min(Math.max(centerY + vectorY * flameTime, 0), 600);
	}
	
	/**
	 * ベクトルの更新
	 * 
	 * @param newVectorX
	 * @param newVectorY
	 */
	protected void updateVector(double newVectorX, double newVectorY) {
		
	}
	
	/**
	 * ベクトルの更新と位置更新を同時に
	 * 
	 * @param newVectorX
	 * @param newVectorY
	 * @param flameTime
	 */
	public void updateObject(double newVectorX, double newVectorY, double flameTime) {
		if (isMoving) {
			preX = centerX - radius / 2;
			preY = centerY - radius / 2;
			updateVector(newVectorX, newVectorY);
			move(flameTime);
		}
	}
	
	/**
	 * 左上のXを返す
	 * @return
	 */
	public double getX() {
		return centerX - radius / 2;
	}
	
	/**
	 * 左上のYを返す
	 * @return
	 */
	public double getY() {
		return centerY - radius / 2;
	}
}
