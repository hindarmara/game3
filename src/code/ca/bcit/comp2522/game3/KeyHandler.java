package ca.bcit.comp2522.game3;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener
{
    public boolean upPressed, downPressed, leftPressed, rightPressed;

    @Override
    public void keyTyped(KeyEvent e)
    {
        // not used
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        int code = e.getKeyCode(); // return the number of the key that was pressed

        if(code == KeyEvent.VK_W)
        {
            upPressed = true;
        }

        if(code == KeyEvent.VK_S)
        {
            downPressed = true;
        }

        if(code == KeyEvent.VK_A)
        {
            leftPressed = true;
        }

        if(code == KeyEvent.VK_D)
        {
            rightPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W)
        {
            upPressed = false;
        }

        if(code == KeyEvent.VK_S)
        {
            downPressed = false;
        }

        if(code == KeyEvent.VK_A)
        {
            leftPressed = false;
        }

        if(code == KeyEvent.VK_D)
        {
            rightPressed = false;
        }
    }
}
