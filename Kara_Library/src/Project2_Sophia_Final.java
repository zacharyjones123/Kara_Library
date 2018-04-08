import java.util.*;
import java.io.*;

      public class Project2_Sophia_Final {//driver program opens

         public static void main(String[] args) throws IOException {//main opens
   
   		File file = new File("VehicleInformation.txt");
   
   		Scanner input = new Scanner(file);

             String type;
             String make;
             int year=0;
             double finalPrice=0.0;
             double price=0.0;
             char option='Y';
             double totalCost=0.0;
             final int FEE=2500;
               
     
         ArrayList<Vehicle> vehicle= new ArrayList<Vehicle>();

            while (input.hasNext()) {
   			// initalize and declare variables from file
   			type = input.next();
   			make = input.next();
   		   year = input.nextInt();
   		   //System.out.println(year);
   			price = input.nextDouble();
   			String optionString = input.next();
   			option = optionString.charAt(0);

        

         Vehicle vehicle1 = new Vehicle(type, make, year , price, option, finalPrice);

			vehicle.add(vehicle1);

         //for (int i = 0; i < vehicle.size(); i++) {

			System.out.println("\nType: " + vehicle1.getType()); // instance method - returns the
																				// customer type
			System.out.println("\nMake: " + vehicle1.getMake()); // instance method - returns the course
																				// number
			System.out.printf("\nYear: " + vehicle1.getYear()); // instance method - returns the contact
																			// hours
		
			System.out.printf("\nBase Price: $%.2f ", vehicle1.getPrice());
         
			System.out.printf("\nOptions Package: %c", vehicle1.getOption());
         
			System.out.printf("\nFinal Price: $%.2f ", vehicle1.getFinalPrice(vehicle1.getPrice())); // method that
																									// returns the
																									// tuition for
																									// each course
			System.out.println();

         totalCost += vehicle1.getFinalPrice( vehicle1.getPrice());
			System.out.print("______________________________________________________________");
        //}
		   } // close 
		   input.close();

		   System.out.println();
         
         System.out.printf("Total price of all orders: $%.2f", totalCost);
		   System.out.println();
		// an average function is added here
		   System.out.printf("Average of all the orders: $%.2f", Vehicle.calcAverage(vehicle, totalCost));

	   


         }// close main
         
         }