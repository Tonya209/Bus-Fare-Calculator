package transitCalculator;

import java.util.*;

public class Calculator {

    // set fare options and prices: Pay-per-Ride is $2.75, 7-day Unlimited - $33, 30-day Unlimited is $127
    String[] fareOptions = {"Pay-per-ride", "7-day Unlimited", "30-day Unlimited"};
    double[] fares = {2.75, 33.0, 127.0};

   static int rides;
   static int days;
    
    

    //calculate price per ride for 7-day Unlimited
    public double unlimited7Price() {

        double sevenDayPurchases = Math.ceil(days / 7.0);
        double total7DayCost = sevenDayPurchases * fares[1];

        return total7DayCost / rides;

    }
    
    // put prices per 1 ride for different tariffs in an array
    public double[] getRidePrices() {

        double pprPrice = fares[0];
        double unlimited7Price = unlimited7Price();
        
        // calculate price per ride for 30-day unlimited
        double unlimited30Price = fares[2] / rides; 
      
        double prices[] = {pprPrice, unlimited7Price, unlimited30Price};
        return prices;
      
    }
    
    // calculate the chepest rate
    public String getBestFare() {

        double[] ridePrices = getRidePrices();
        int winningIndex = 0;

        for (int i = 0; i < ridePrices.length; i++) {
            
            if (ridePrices[i] < ridePrices[winningIndex]){

                winningIndex = i;
            }
        }
        return "You should get the " + fareOptions[winningIndex] + " option at $" 
                + Math.round(ridePrices[winningIndex] * 100.0) / 100.0 + " per ride.";
    }

    public static void main(String[] args) {

       // get the number of days and number of rides from the user
    Scanner sc = new Scanner(System.in);
  
    System.out.print("How many days are you going to stay: ");
    days = sc.nextInt();
    
    System.out.print("How many rides are you going to make: ");
    rides = sc.nextInt();

    Calculator calc = new Calculator();
        
        System.out.println(calc.getBestFare());

    }

}