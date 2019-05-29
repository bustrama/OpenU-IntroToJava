public class TrainTester
{
     public static void main (String[]args)
     {
         Date date1=new Date(1,3,2011);
         Date date2=new Date(23,3,2011);
         Train rail1=new Train(100,date1,"Rome","Paris");
         Train rail2=new Train(100,date2,"London","Paris");
         Train rail3=new Train(rail1);
         if (rail1.equals(rail2))
                 System.out.println("rail1,rail2 alternative trips");
         else
                   System.out.println("rail1,rail2 not alternative trips");
         if (rail1.equals(rail3))
                 System.out.println("rail1,rail3 alternative trips");
         else
                   System.out.println("rail1,rail3 not alternative trips");
         
         System.out.println(rail1.toString()); 
         System.out.println(rail2.toString()); 
         System.out.println(rail3.toString()); 
         date1.setDay(2);
         if (rail1.equals(rail3))
                 System.out.println("rail1,rail3 alternative trips");
         else
                   System.out.println("rail1,rail3 not alternative trips");
         rail1.setTrainDate(date1);
         if (rail1.equals(rail3)) 
                   System.out.println("rail1,rail3 alternative trips");
           else
                   System.out.println("rail1,rail3 not alternative trips");
                  
          System.out.println(rail1.getTrainDate().getYear()); 
          Date tempDate=rail1.getTrainDate();
          int tempMonth=tempDate.getMonth();
          if (tempMonth==12){
                   tempMonth=1;
                   int tempYear=tempDate.getYear();
                   tempYear++;
                   tempDate.setYear(tempYear);
                }
          else 
                   tempMonth++;
          tempDate.setMonth(tempMonth);
          rail1.setTrainDate(tempDate);
          System.out.println(rail1.toString()); 
          rail1.book(5);
          System.out.println("Places left on rail1 trip :"+rail1.placesLeft());
          System.out.println("Train rail1 is: " + (rail1.full()?"full":"not full"));
/*

rail1,rail2 not alternative trips
rail1,rail3 alternative trips
 Date : 1/3/2011
Destination: Rome
Origin: Paris
Capacity :100
Booked: 0
 Date : 23/3/2011
Destination: London
Origin: Paris
Capacity :100
Booked: 0
 Date : 1/3/2011
Destination: Rome
Origin: Paris
Capacity :100
Booked: 0
rail1,rail3 alternative trips
rail1,rail3 not alternative trips
2011
 Date : 2/4/2011
Destination: Rome
Origin: Paris
Capacity :100
Booked: 0
Places left on rail1 flight :95
Train rail1 is: not full

*/     
                   
                  
                }
            }