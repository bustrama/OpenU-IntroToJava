public class DateTester
{
     public static void main (String[]args)
     {
       
         Date d1=new Date(3,5,1998);
         Date d2=new Date(4,2,2007);
         Date d3=new Date(d2);
         d1.setMonth(7);
         System.out.println( d1.getYear());
         if( d1.equals(d2))
            System.out.println("dates 1 and 2 are equal") ;
         else
            System.out.println("dates 1 and 2 are not  equal") ;
         if( d2.equals(d3))
            System.out.println("dates 2 and 3 are equal") ;
         else
            System.out.println("dates 2 and 3 are not equal") ;
         if(d1.before(d2))
             System.out.println("date 1 comes before date 2");
         if(d1.after(d2))
             System.out.println("date 1 comes after date 2");
             
         if(d1.lastCentury())
               System.out.println( "First date from previous century");
         else
               System.out.println( "First date from this century");
         System.out.println( d1);
         System.out.println( d2);
         System.out.println( d3);
        }
    }