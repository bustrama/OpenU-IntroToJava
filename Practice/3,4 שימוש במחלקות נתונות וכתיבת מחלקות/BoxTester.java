public class BoxTester
{
    public static void main(String [] args)
    {
        Box box1=new Box(2,3,4);
        int box1Area=box1.calculateArea();
        System.out.println("The volume of box1 is:"+box1.calculateVolume());
        Box box2=new Box(10,10,10);
        int volbox2=box2.calculateVolume();
        System.out.println("The volume of box2 is:"+volbox2);
        Box box3=new Box();
       
    }
    
}