package application;
import java.lang.Math;
import javafx.scene.canvas.GraphicsContext;

public class GameObject {
	public double centerX;	// 位置(X)
	public double centerY;	// 位置(Y)
	public double radius;	// オブジェクトの半径
	public boolean isMoving;	// 移動しているかどうか
	public double vectorX;	// 移動ベクトル(X)
	public double vectorY;	// 移動ベクトル(Y)
	public double maxSpeed;	// オブジェクトの最高速度
	
	/**
	 * オブジェクトの位置更新
	 * 
	 * @param flameTime
	 */
	protected void move(double flameTime) {
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
	
	/**
	 * 別オブジェクトとの距離計算
	 * @param object
	 * @return
	 */
	protected double distance(GameObject object) {
		return getVectorAbs(this.centerX - object.centerX, this.centerY - object.centerY);
	}
	
	/**
	 * ベクトルの絶対値を計算
	 * @param x
	 * @param y
	 * @return
	 */
	protected double getVectorAbs(double x, double y) {
		return Math.pow(Math.pow(x, 2) + Math.pow(y, 2), 0.5);
	}
	
	/**
	 * 描画
	 * @param graphicsContext
	 */
	public void drawObject(GraphicsContext graphicsContext) {
		graphicsContext.fillOval(getX(), getY(), radius, radius);
	}
}
