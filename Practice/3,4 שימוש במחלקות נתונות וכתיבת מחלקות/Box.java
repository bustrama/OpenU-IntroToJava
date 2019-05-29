public class Box
{
    private int _length;
    private int _width;
    private int _height;
    
    public Box(int l,int w,int h)
    {
        _length=l;
        _width=w;
        _height=h;
    }
    public Box(){
        _length=2;
        _width=2;
        _height=2;
    }
    public int calculateVolume()
    {
        return _length*_width*_height;
    }
    public int calculateArea()
    {
        int a,b,c;
        a=_length*_width;
        b=_length*_height;
        c=_width*_height;
        return 2*(a+b+c);
    }
}