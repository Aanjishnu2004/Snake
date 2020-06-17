import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JComponent;
import java.awt.Color;
public class DEngine
{
    int sh , sw ;
    int sch , scw;
    JFrame j;
    Toolkit t;
    DEngine()
    {
        sh = sw = 700 ;
        j = new JFrame("ClassicSnake");
        Toolkit t = Toolkit.getDefaultToolkit();
        AssetLoader as = new AssetLoader();as.loadImage("icon.png");
        j.setIconImage(as.i);
        sch = (int)t.getScreenSize().getHeight();
        scw = (int)t.getScreenSize().getWidth();
    }

    public void init()
    {
        j.setSize(sw , sh);
        j.setLocation(scw/2-sw/2 , sch/2-sh/2);
        j.setResizable(false);
        j.setUndecorated(true);
    }

    public void add(JComponent j)
    {
        this.j.add(j);
    }

    public void visibility()
    {
        this.j.setVisible(true);
        this.j.toFront();
        this.j.requestFocus();
    }

    public void kill()
    {
        j.dispose();
    }
}
