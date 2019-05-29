public class Train
{
   private int _seats;
   private int _booked;
   private Date _trainDate;
   private String _destination;
   private String _origin;
  
   public Train (int seats, Date date,String dest,String origin)
   {
       _seats=seats;
       _booked=0;
       _trainDate=new Date(date);
       _destination=dest;
       _origin=origin;
    }
    //Copy constructor
    public Train (Train other)
   {
       _seats=other._seats;
       _booked=other._booked;
       _trainDate=new Date(other._trainDate);
       _destination=other._destination;
       _origin=other._origin;
    }
    
    public int getSeats()
    { 
         return _seats;
        }
    public int getBooked()
    { 
         return _booked;
        }
     public Date getTrainDate()
    { 
         return new Date (_trainDate);
        }
     public String getDestination()
    { 
         return _destination;
        }
     public String getOrigin()
    { 
         return _origin;
        }   
     public void setSeats(int seats)
    { 
          _seats=seats;
        }
    public void  setBooked(int booked)
    { 
          _booked=booked;
        }
     public void setTrainDate(Date newDate)
    { 
         _trainDate=new Date(newDate);
        }
     public void setDestination(String dest)
    { 
         _destination=dest;
        }
     public void setOrigin(String origin)
    { 
         _origin=origin;
        }   
        
      public String toString()
    {
      return (" Date : "+_trainDate+"\nDestination: "+_destination+
      "\nOrigin: "+_origin+ "\nCapacity :"+  _seats+ "\nBooked: "+_booked);
    }
    public boolean equals(Train other){
            if (_trainDate.equals(other._trainDate)&&_destination.equals(other._destination)&&_origin.equals(other._origin))
                      return true;
            return false;
            }
     public boolean full(){
         if (_booked==_seats )
                  return true;
         return false;
        }
     public int placesLeft(){
              return _seats-_booked;
            }
     public boolean book(int places)
         { 
             if (places <=placesLeft())
                     {
                         _booked+=places;
                         return true;
                        }   
              return false;
            }
        }
    
       
   