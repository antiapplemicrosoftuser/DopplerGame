package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.animation.AnimationTimer;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Main extends Application {
	private GraphicsContext graphicsContext;
	private long preNanoTime;	// 1つ前のフレームの秒数
	private double mouseX;	// マウスのX座標
	private double mouseY;	// マウスのY座標
	private final double defaultPlayerX = 200;
	private final double defaultPlayerY = 200;
	private Player player;
	
	@Override
	public void start(final Stage stage) {
		try {
			Group root = new Group();
			 
			//描画用キャンバスノードの作成
			Canvas cvs = new Canvas(800, 600);
			root.getChildren().add(cvs);
			player = new Player(defaultPlayerX, defaultPlayerY, 20, 300, true);
			mouseX = defaultPlayerX;
			mouseY = defaultPlayerY;
			preNanoTime = -100;
		    
	 
			this.graphicsContext = cvs.getGraphicsContext2D();
			Scene scene = new Scene(root, 800, 600, Color.WHITE);
			stage.setScene(scene);
			
			// マウスの位置更新
			scene.setOnMouseMoved(this::mouseUpdate);
			scene.setOnMouseDragged(this::mouseUpdate);
			
			
			new AnimationTimer() {
				// handleメソッドの処理が1秒に60回くらい行われる。
		        public void handle(long currentNanoTime) {
		        	if (preNanoTime < 0) {
		        		preNanoTime = currentNanoTime;
		        		return;
		        	}
		        	// playerの位置更新
		        	double flameTime = (currentNanoTime - preNanoTime) / 1000000000.0;
		            double newVectorX = mouseX - player.centerX;
		    		double newVectorY = mouseY - player.centerY;
		    		player.updateObject(newVectorX, newVectorY, flameTime);
		    		
		    		// 描画更新
		    		draw();
		    		
		    		// preNanoTimeの更新
		    		preNanoTime = currentNanoTime;
		    		
		    		// デバッグ
		    		// System.out.println(player.centerX + ", " + player.centerY);
		        }
		    }.start();
			
			stage.show();//ウィンドウの表示
			draw();
	 
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private void draw() {
		graphicsContext.setFill(Color.WHITE);
		graphicsContext.fillOval(player.preX - 1, player.preY - 1, player.radius + 2, player.radius + 2);
		graphicsContext.setFill(Color.BLACK);
		graphicsContext.fillOval(player.getX(), player.getY(), player.radius, player.radius);
	}
	
	/**
	 * マウスの位置の更新
	 * @param event
	 */
	private void mouseUpdate(MouseEvent event) {
		mouseX = event.getX();
		mouseY = event.getY();
	}
	
}
