/**
 * A simple class to represents a passenger.
 */
public class Passenger
{
   private String name;
   private int destination;

   public Passenger(String name, int dest) { this.name = name;  destination = dest; }
   public int getDestination() { return destination; }
   public String toString() { return name + "->" + destination; }
}
