package ca.bcit.comp2522.game3;

import ca.bcit.comp2522.entity.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel
        extends JPanel
    implements Runnable
{
    // SCREEN SETTINGS
    final int originalTileSize = 16; // 16 X 16 tile for characters
    final int scale = 3;

    private final int tileSize = originalTileSize * scale; // 48 X 48, actual tile size shown in game screen
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 48 X 16 = 768 pixels
    final int screenHeight = tileSize * maxScreenRow; // 48 X 12 = 576 pixels

    // FPS
     int FPS = 60;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    Player player = new Player(this, keyH);

    // Set player's default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public int getTileSize()
    {
        return tileSize;
    }

    public void startGameThread()
    {
        gameThread = new Thread(this); // passing GamePanel to Thread
        gameThread.start();
    }

//    @Override
//    public void run()
//    {
//        double drawInterval = 1000000000/FPS; // 0.01666 seconds
//        double nextDrawTime = System.nanoTime() + drawInterval;
//
//
//        // as long this gameThread exist, it will repeat the process that is written in the while loop
//        while(gameThread != null)
//        {
//            // 1. Update information such as character positions
//            update();
//
//            // 2. Draw the screen with the updated information
//            repaint(); // calling paintComponent method
//
//            try
//            {
//                double remainingTime = nextDrawTime - System.nanoTime();
//                remainingTime = remainingTime / 1000000;
//
//                if(remainingTime < 0)
//                {
//                    remainingTime = 0;
//                }
//
//                Thread.sleep((long)remainingTime);
//
//                nextDrawTime += drawInterval;
//            }
//            catch(InterruptedException e)
//            {
//                e.printStackTrace();
//            }
//        }
//
//    }

    public void run()
    {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null)
        {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1)
            {
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if(timer >= 1000000000)
            {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }

        }
    }

    public void update()
    {
        player.update();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g; // casting Graphics g to Graphics2D

        player.draw(g2);

        g2.dispose();
    }
}
