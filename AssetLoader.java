import java.awt.Image;
import java.awt.Toolkit;
public class AssetLoader
{
    Image i;
    public void loadImage(String s)
    {
        i = Toolkit.getDefaultToolkit().createImage(s);
    }
}