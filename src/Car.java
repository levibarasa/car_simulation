
import java.util.ArrayList;
/**
 * A simple car for a car-sharing simulation.
 */
public class Car
{
   private int idNo;
   private int destination;
   private int location;
   private ArrayList<Passenger> passengers = new ArrayList<>();

   private double faresCollected = 0.0;
   private int milesDriven = 0;

   final double FARE_PER_MILE = 1.0;
   final int MAX_PASSENGERS = 3;

   // Constructor
   public Car(int id, int station, int dest) 
   { 
      idNo = id;
      location = station;  
      destination = dest; 
   }
   
   // Accessor methods
   public int getLocation() { return location; }
   public int getDestination() { return destination; }
   public boolean hasArrived() { return location == destination; }
   public boolean hasRoom() { return passengers.size() < MAX_PASSENGERS; }
   public double getFares() { 
       
       return faresCollected;
   }
   public int getMilesDriven() { 
       
       return milesDriven;  
   }
   
   // Mutator methods
   
   /**
    * Drives to the next station.
    */
   public void drive()
   {
      if (location != destination)
      {
         milesDriven++;
         faresCollected += passengers.size() * FARE_PER_MILE;
         location = (location < destination) ? 
            location + 1 : location - 1;
      }
   }
   
   /**
    * Drop off any passengers who have arrived.
    */
   public boolean dropOff()
   {
       boolean droppedOff = false;
      for (int i = passengers.size() - 1; i >= 0; i--)
      {
         if (passengers.get(i).getDestination() == location)
         {
            passengers.remove(i);
            droppedOff = true;
         }
      }
      return droppedOff;
   }

   /**
    * Add a passenger if there is room.
    * @param p the passenger to add.
    * @return true if the passenger could be added.
    */
   public boolean add(Passenger p)
   {
      if (hasRoom())
      {
         passengers.add(p);
         return true;
      }
      return false;
   }

    public int getIdNo() {
        return idNo;
    }

    public void setIdNo(int idNo) {
        this.idNo = idNo;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    public double getFaresCollected() {
        return faresCollected;
    }

    public void setFaresCollected(double faresCollected) {
        this.faresCollected = faresCollected;
    }

   
   
   @Override
   public String toString()
   {
      return "Car[idNo=" + idNo + ", location=" + location + ", destination=" 
         + destination + ", passengers=" + passengers + "]";
   }
}
