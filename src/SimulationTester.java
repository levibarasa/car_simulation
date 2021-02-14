
import java.util.Random;

public class SimulationTester
{
   public static void main(String[] args)
   {
      Simulation sim = new Simulation(new Random(1000));
      
      Station s = new Station(10);
      s.add(new Passenger("Fred", 3));  // Fred is headed to 3
      s.add(new Passenger("Sally", 7)); // Sally is headed to 7
      s.add(new Passenger("Homer", 15)); // Homer is headed to 15
      s.add(new Passenger("Moe", 19)); // Moe is headed to 19
      s.add(new Passenger("Bart", 1)); // Bart is headed to 1
      
      Car c1 = new Car(1, 10, 2); 
      sim.loadPassengers(s, c1);   // load the passengers at the station
      System.out.println(c1);
      System.out.println("Expected: Car[idNo=1, location=10, destination=2, passengers=[Sally->7, Fred->3]]"); 
      System.out.println("Waiting at #10 " + s);
      System.out.println("Expected: Waiting at #10 [Homer->15, Moe->19, Bart->1]"); 

      Car c2 = new Car(2, 10, 30); // Starting at 10, going to 30
      sim.loadPassengers(s, c2);
      System.out.println(c2);
      System.out.println("Expected: Car[idNo=2, location=10, destination=30, passengers=[Moe->19, Homer->15]]");
      System.out.println("Waiting at #10 " + s);
      System.out.println("Expected: Waiting at #10 [Bart->1]");
      
      Car c3 = new Car(3, 10, 1); // Starting at 10, going to 1
      sim.loadPassengers(s, c3);
      System.out.println(c3);
      System.out.println("Expected: Car[idNo=3, location=10, destination=1, passengers=[Bart->1]]");
      System.out.println("Waiting at #10 " + s);
      System.out.println("Expected: Waiting at #10 []");
   }
}