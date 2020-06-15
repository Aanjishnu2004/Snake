public class Collision
{
    int _boundX , _boundY , boundX , boundY ;
    Collision(int x0 , int y0 , int x , int y)
    {
        _boundX = x0;
        _boundY = y0;
        boundX = x; 
        boundY = y;
    }

    boolean X(int x)
    {
        if(x >= boundX)
            return true;
        return false;
    }


    boolean Y(int x)
    {
        if(x >= boundY)
            return true;
        return false;
    }


    boolean _X(int x)
    {
        if(x <= _boundX)
            return true;
        return false;
    }


    boolean _Y(int x)
    {
        if(x <= _boundY)
            return true;
        return false;
    }

    boolean inXY(double x, double y)
    {
        if((x >= _boundX && x <= boundX)&&(y >= _boundY && y <= boundY))
            return true;
        return false;
    }
}

