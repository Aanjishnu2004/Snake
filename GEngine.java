import javax.swing.JPanel;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;

public class GEngine extends JPanel
{
    DEngine d;
    int fps ; 

    public GEngine()
    {
        d = new DEngine();   
        d.init();
        fps = 60;
    }

    public void update(Graphics2D g)
    {
        g.drawRect(0,0,100,100);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)(g);
        g2.setBackground(Color.BLACK);
        g2.clearRect(0,0,d.sw,d.sh);
        update(g2);
        try{Thread.sleep(fps);}catch(Exception e){}
        repaint();
    }

    public void create()
    {
        d.add(this);
        d.visibility();
    }

    public void initKeys()
    {
        KeyState key = new KeyState();
        addKeyListener(key);
        setFocusable(true);
        requestFocus();
    }

    public void initKeys(KeyListener key)
    {
        addKeyListener(key);
        setFocusable(true);
        requestFocus();
    }
    
    private class KeyState implements KeyListener
    {
        public void keyReleased(KeyEvent e)
        {

        }

        public void keyPressed(KeyEvent e)
        {
            if(e.getKeyCode() == KeyEvent.VK_SPACE)
            {
                d.kill();
            }
        }

        public void keyTyped(KeyEvent e)
        {

        }
    }
}