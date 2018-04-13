import java.util.Scanner;
import java.util.ArrayList;

   public class swimDemo
   {

      public static void main(String[] args)
      {

      Scanner input=new Scanner(System.in);

         char team='Y';
         String name="";
         int age=0;
         char gender='Y';
         int weight=0;
         String group="";
         double front=0.0;
         double back=0.0;
         double butterfly=0.0;
         char choice='Y';
         double totalSwimTime=0.0;
         char option='Y';
         String medal="";
         double totalTime=0.0;
         

         ArrayList<swim> swimmer= new ArrayList<swim>();

         while(option=='Y'||option=='y')
         {
             
             
             String teamString;
             
            System.out.print("Please enter your swim team(Varsity or Junior): ");
            teamString=input.next();
             
            
            while(!teamString.toUpperCase().equals("V") && !teamString.toUpperCase().equals("J"))
            {
                System.out.println("Error-invalid input");
                System.out.print("Please enter your swim team(Varsity or Junior): ");
                teamString=input.next();
            }
            
            team = teamString.charAt(0);
            
            
            System.out.print("Please enter your full name: ");
            name=input.next();
            name=" "+ input.next();
            input.nextLine();
            
            //input.nextLine();
            
            System.out.printf("Please enter your age: ");
            age=input.nextInt();
            input.nextLine();

            
            while(age<6 || age>18)
            {
            System.out.print("Error-Invalid Input");
            System.out.printf("Please enter your age: ");
            age=input.nextInt();
            input.nextLine();
            }
            
            
            
            System.out.print("Please enter your gender: ");
            String genderChoice=input.next();
            genderChoice.toLowerCase();
            
            while(!genderChoice.toUpperCase().equals("M") && !genderChoice.toUpperCase().equals("F"))
            {
                System.out.println("Error-invalid input");
                System.out.print("Please enter your swim team(Varsity or Junior): ");
                genderChoice=input.next();
            }
            
            gender=genderChoice.charAt(0);
            
            
            
            
            
            System.out.printf("Please enter your weight(lbs): ");
            weight=input.nextInt();
            input.nextLine();
            
            while(weight<1)
            {
            System.out.print("Error-Invalid Input");
            System.out.printf("Please enter your weight(lbs): ");
            weight=input.nextInt();
            input.nextLine();
            }

            
            System.out.print("Please enter your group name: ");
            group=input.nextLine();
            
      
            
            System.out.printf("Please enter the time it took to complete 500m front crawl: ");
            front=input.nextDouble();
            
            while(front<1.0)
            {
            System.out.print("Error-Invalid Input");
            System.out.printf("Please enter the time it took to complete 500m front crawl: ");
            front=input.nextDouble();
            }
            
            System.out.printf("Please enter the time it took to complete 500m back crawl: ");
            back=input.nextDouble();
            
            while(back<1.0)
            {
            System.out.print("Error-Invalid Input");
            System.out.printf("Please enter the time it took to complete 500m back crawl: ");
            back=input.nextDouble();
            }
            
            System.out.printf("Please enter the time it took to complete 500m butterfly race: ");
            butterfly=input.nextDouble();
            input.nextLine();
            
            while(butterfly<1.0)
            {
            System.out.printf("Please enter the time it took to complete 500m butterfly race: ");
            butterfly=input.nextDouble();
            input.nextLine();
            }
            
            
            System.out.printf("Please enter if you are eligible to register for next year's season: ");
            String choiceEligible=input.next();
            
            while(!choiceEligible.toUpperCase().equals("Y") && !choiceEligible.toUpperCase().equals("N"))
            {
                 System.out.print("Error");
                 System.out.printf("Please enter if you are eligible to register for next year's season: ");
                
                 choiceEligible=input.next();
            }
        
            choice=choiceEligible.charAt(0);
            
            System.out.print("Would you like to enter in another athlete log? : \n");
            String optionChoice=input.next();
            
            while(!optionChoice.toUpperCase().equals("Y") && !optionChoice.toUpperCase().equals("N"))
            {
            
            System.out.print("Would you like to enter in another athlete log? : \n");
            optionChoice=input.nextLine();
            }
            option=optionChoice.charAt(0);
         

            swimmer.add(new swim(team, name, age, gender, weight, group, front , back, butterfly, choice));
            
            }

         for (int i=0; i<swimmer.size(); i++)
         {
               System.out.println("Team: " + swimmer.get(i).getTeam());
               System.out.println("\nName: " + swimmer.get(i).getName());
               System.out.printf("\nAge: %d", swimmer.get(i).getAge());
               System.out.println("\nGender: " + swimmer.get(i).getGender());
               System.out.printf("\nWeight: %d lbs", swimmer.get(i).getWeight());
               System.out.println("\nGroup Name: " + swimmer.get(i).getGroup());
               System.out.printf("\nFront Crawl: %.2f secs", swimmer.get(i).getFront());
               System.out.printf("\nBack Crawl: %.2f secs", swimmer.get(i).getBack());
               System.out.printf("\nButterfly: %.2f secs", swimmer.get(i).getButterfly());
               System.out.printf("\nEligibility to register: " + swimmer.get(i).getChoice());
               System.out.printf("\nTotal race time: %.2f secs", swimmer.get(i).getTotalTime());
               System.out.println("\nStatus awarded: " + swimmer.get(i).getStatus());
               System.out.println();
               System.out.println();
               
             totalSwimTime+=swimmer.get(i).getTotalTime();
          
         }

            System.out.printf("Total swim time for Athletes: %.2f\n", totalSwimTime);

            System.out.printf("Average swim time for all athletes: %.2f", calcAverage(swimmer, totalSwimTime));


       }
       
       
       public static double calcAverage(ArrayList<swim>swimmer, double totalSwimTime)
      {

         return totalSwimTime/swimmer.size();

      }
       
     }


