import javax.swing.JPanel;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.sound.sampled.Clip;
public class GEngine extends JPanel
{
    DEngine d;
    AEngine a;
    AssetLoader al;
    //Clip sound;
    //Clip sound_front;
    int fps ; 
    public GEngine()
    {
        d = new DEngine();
        a = new AEngine();
        al = new AssetLoader();
        al.loadImage("back.png");
        d.init();
        fps = 50;
    }

    public void update(Graphics2D g)
    {
        g.drawRect(0,0,100,100);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)(g);
        g2.clearRect(0,0,d.sw,d.sh);
        try
        {
            g2.drawImage(al.i,0,0,null);
        }
        catch(Exception e)
        {
            g2.setBackground(Color.BLACK);
        }
        update(g2);
        try{Thread.sleep(fps);}catch(Exception e){}
        repaint();
    }

    public void create()
    {
        //sound = a.music("music1.wav");
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