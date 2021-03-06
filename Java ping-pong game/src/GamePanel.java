import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable{
    // final so we dont change th variable later on
    static final int Game_Width = 1000;
    static final int Game_Height = (int)(Game_Width * (0.5555));
    static final Dimension Screen_Size = new Dimension(Game_Width,Game_Height);
    static final int Ball_Diameter = 20;
    static final int Paddle_Width = 25;
    static final int Paddle_Height = 100;
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Paddle paddle1;
    Paddle paddle2;
    Ball ball;
    Score score;
    GamePanel(){
        newPaddles();
        newBall();
        score = new Score(Game_Width, Game_Height);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(Screen_Size);

        gameThread = new Thread(this);
        gameThread.start();
    }
    public void newBall(){

    }
    public void newPaddles(){
        paddle1 = new Paddle(0,(Game_Height/2) -(Paddle_Height/2), Paddle_Width, Paddle_Height,1);
        paddle1 = new Paddle(Game_Width-Paddle_Width,(Game_Height/2) -(Paddle_Height/2), Paddle_Width, Paddle_Height,2);
    }

    public void paint(Graphics g){
    image = createImage(getWidth(), getHeight());
    graphics = image.getGraphics();
    draw(graphics);
    g.drawImage(image, 0,0,this);
    }
    public void draw(Graphics g){
    paddle1.draw(g);
    paddle2.draw(g);
    }
    public void move(){

    }
    public void checkCollision(){

    }
    public void run(){
    // game loop:
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while(true){
            long now = System.nanoTime();
            delta += (now - lastTime)/ ns;
            lastTime = now;
            if(delta >=1 ){
                move();
                checkCollision();
                repaint();
                delta--;
            }
        }
    }
    public class AL extends KeyAdapter {
        public void keyPressed(KeyEvent e){

        }
        public void keyReleased(KeyEvent e){}

    }
}
