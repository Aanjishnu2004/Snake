import java.io.*;
import javax.sound.sampled.*;
public class AEngine
{
    //static boolean loop = true;
    public void cringe(String s)
    {
        try
        {
            File f2 = new File(s);
            AudioInputStream ai2 = AudioSystem.getAudioInputStream(f2);
            Clip c2 = AudioSystem.getClip();
            c2.open(ai2);
            c2.start();
            //return c2;
        }
        catch(FileNotFoundException e3)
        {
            System.out.println("gg");
        }
        catch(Exception e)
        {
            System.out.println("HOI!!");
        }
        //return null;
    }

    public Clip music(String s)
    {
        try
        {
            File f = new File(s);
            AudioInputStream ai = AudioSystem.getAudioInputStream(f);
            Clip c = AudioSystem.getClip();
            c.open(ai);
            c.start();
            c.loop(-1);
            return c;
        }
        catch(FileNotFoundException e3)
        {
            System.out.println("gg");
        }
        catch(Exception e)
        {
            System.out.println("HOI!!");
        }
        return null;
    }

    public void terminate(Clip c)
    {
        c.close();
    }
}