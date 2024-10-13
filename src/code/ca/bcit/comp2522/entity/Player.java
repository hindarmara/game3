package ca.bcit.comp2522.entity;

import ca.bcit.comp2522.game3.GamePanel;
import ca.bcit.comp2522.game3.KeyHandler;

import java.awt.*;

public class Player
        extends Entity
{
    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gamePanel,
                  KeyHandler keyHandler)
    {
        this.gp = gamePanel;
        this.keyH = keyH;


    }

    public void setDefaultValues()
    {
        x = 100;
        y = 100;
        speed = 4;
    }

    public void update()
    {
        if(keyH.upPressed == true)
        {
            y -= speed;
        }
        else if(keyH.downPressed == true)
        {
            y += speed;
        }
        else if(keyH.leftPressed == true)
        {
            x -= speed;
        }
        else if(keyH.rightPressed == true)
        {
            x += speed;
        }
    }

    public void draw(Graphics2D g2)
    {
        g2.setColor(Color.white);

        g2.fillRect(x, y, gp.getTileSize(), gp.getTileSize()); // position of the character
    }
}
