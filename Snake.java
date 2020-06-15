import java.awt.Graphics2D;
import java.awt.Color;
import java.util.LinkedList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Font;
import javax.swing.border.LineBorder;

public class Snake extends GEngine
{
    LinkedList<Box> snake = new LinkedList<Box>();
    Box food;
    Collision foo; 
    Collision Bounds ;
    static int s = 15;
    int vx = 0;
    int vy = 0;
    KeyState key ;
    boolean loop = true;
    Snake()
    {
        key = new KeyState();
        Bounds = new Collision(0,0,d.sw,d.sh);
        food = new Box( d.sw/2 , d.sh/2 , Color.YELLOW);
        foo = new Collision(food.x , food.y , food.x+s-1 , food.y+s-1);
        setBorder(new LineBorder(Color.BLACK , 3 , true));
    }

    public void init()
    {
        Box head = new Box(d.sw/2, d.sh/2 , Color.RED);
        snake.push(head);
    }

    public void updater()
    {
        for(int i = snake.size()-1; i>=1   ; i--)
        {
            snake.get(i).x = snake.get(i-1).x;
            snake.get(i).y = snake.get(i-1).y;
        }
        snake.getFirst().x += vx*s ;
        snake.getFirst().y += vy*s ;
    }

    public void update(Graphics2D g)
    {
        //render

        g.setColor(Color.YELLOW);
        g.fillOval(food.x , food.y , s-1 ,s-1);

        for(int i = 0 ; i < snake.size() ;i++)
        {
            g.setColor(snake.get(i).c);
            g.fillRect(snake.get(i).x,snake.get(i).y,s-1,s-1);
        }

        //eating ham 

        if(foo.inXY((2*snake.getFirst().x+s)/2,(2*snake.getFirst().y+s)/2))
        {
            //System.out.println("food!!");
            food();
        }

        //logic 
        if(Bounds.X(snake.getFirst().x) || Bounds._X(snake.getFirst().x))
        {
            loop = false;
        }
        if(Bounds.Y(snake.getFirst().y) || Bounds._Y(snake.getFirst().y))
        {
            loop = false;
        }
        if(loop)
            updater();
        if(!loop)
        {
            gameOver(g);
        }
    }

    public void gameOver(Graphics2D g)
    {
        g.clearRect(0,0,d.sw,d.sh);
        g.setColor(Color.ORANGE);
        g.setFont(new Font("castellar" , Font.BOLD , 48));
        g.drawString("GAME OVER",d.sw/2-175,d.sh/2 - 30);
        g.setFont(new Font("castellar" , Font.BOLD , 36));
        g.setColor(Color.MAGENTA);
        g.drawString("Score: "+(snake.size()-1),d.sw/2-100,d.sh/2+26);
    }

    public void food()
    {
        int x = 0;
        int y = 0;
        x = (int)(Math.random()*650) + (int)(Math.random()*650)%s ;y =(int)(Math.random()*650) + (int)(Math.random()*650)%s;
        food = new Box(x, y , Color.YELLOW);
        foo = new Collision(food.x , food.y , food.x+s , food.y+s);
        add();
    }

    public void add()
    {
        snake.getFirst().setColor(Color.GREEN);
        snake.push(new Box(snake.getFirst().x+s*vx , snake.getFirst().y+s*vy , Color.RED));
    }

    public static void main(String args[])
    {
        Snake s = new Snake();
        s.init();
        s.create();
        s.initKeys(s.key);
    }

    class Box
    {
        int x , y ;
        Color c ;
        Box(int x , int y  ,Color c)
        {
            this.c = c;
            this.x = x;
            this.y = y;
        }

        void setColor(Color c)
        {
            this.c = c;
        }
    }

    private class KeyState implements KeyListener
    {
        public void keyReleased(KeyEvent e)
        {

        }

        public void keyPressed(KeyEvent e)
        {
            if(e.getKeyCode() == KeyEvent.VK_UP)
            {
                vy = -1;
                vx = 0;
            }

            if(e.getKeyCode() == KeyEvent.VK_DOWN)
            {
                vy = 1;
                vx = 0;
            }

            if(e.getKeyCode() == KeyEvent.VK_LEFT)
            {
                vy = 0;
                vx = -1;
            }

            if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            {
                vy = 0;
                vx = 1;
            }

            if(e.getKeyCode() == KeyEvent.VK_SPACE)
            {
                add();
            }

            if(e.getKeyCode() == KeyEvent.VK_ENTER)
            {
                d.kill();
                //JOptionPane.showMessageDialog(null,"THANKS FOR PLAYING!!","",JOptionPane.INFORMATION_MESSAGE);
            }
        }

        public void keyTyped(KeyEvent e)
        {

        }
    }
}