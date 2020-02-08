package com.epam.mavendemo;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import giftitems.Sweets;
public class Gift_prop {
	
    public static void main(String[] args) {
    	try {
	        Scanner scanner = new Scanner(System.in);
	        int choice = 0, type;
	        
	        System.out.println("<--! WELCOME TO NEW YEAR'S GIFT-->\n");
	        Range_gift gift = new Range_gift();
	        ArrayList<Sweets> gifts = new ArrayList<Sweets>();
	        gifts.add(gift.addDemoGift());
	        
	        while(choice != 5) {
	        	
		        System.out.println(
		        		"Total weight of gifts: " + getTotalWeight(gifts) + " grams\n"
		        		+ "Total Cost of gifts: ₹" + getTotalCost(gifts) + " /- \n\n"
		        		+ "			<--! MENU !-->\n"
		        		+"Enter 1 to add new gift :\n" 
		        		+ "Enter 2 to view all candies (low-high/high-low) cost :\n"
		        		+ "Enter 3 to view all chocolates (low-high/high-low) cost :\n"
		        		+ "Enter 4 to view items in specified cost range(X-Y) :\n"
		        		+ "Enter 5 to EXIT :\n"
		        		);
		        choice = scanner.nextInt();
		        if(choice == 5) {
		        	break;
		        }
		        switch(choice) {
		        	case 1:
		        		gifts.add(gift.addGift());
		        		break;
		        	case 2:
		        		System.out.println("Enter 1 to get High-Low Cost Candies\n"
		        							+ "Enter 2 to get Low-High Cost Candies");
		        		type = scanner.nextInt();
		        		for(Sweets sweet: gifts)
		        			gift.getCandies(sweet, type);  
		        		break;
		        	case 3:
		        		System.out.println("Enter 1 to get High-Low Cost Chocolates\n"
								+ "Enter 2 to get Low-High Cost Chocolates");
		        		type = scanner.nextInt();
		        		for(Sweets sweet: gifts) 
		        			gift.getChocolates(sweet, type); 
		        		break;
		        	case 4:
		        		System.out.println("Select range type:\n"
					        				+ "1. Cost\n"
					        				+ "2. Weight");
		        		type = scanner.nextInt();
		        		int lower_bound, upper_bound;
		        		System.out.println("Enter the range (lower bound & upper bound)");
		        		lower_bound = scanner.nextInt();
		        		upper_bound = scanner.nextInt();
		        		
		        		for(Sweets sweet: gifts)	
		        			gift.calRange(sweet, type, lower_bound, upper_bound);  
		        		break;
		    		default:
		    			System.out.println("Inavlid Option. Please Try again\n");
		        }
		     
		        System.out.println("\n Would You Like To Continue? (y/n)\n");
		        char cont = scanner.next().charAt(0);
		        if(cont == 'y' || cont == 'Y') {
		        	continue;
		        }
	        }
	    	System.out.println("Closed");
	        scanner.close();
    	} catch(InputMismatchException e) {
    		System.out.println("Input not matched\n"
    				+ "Enter Valid Input");
    	}
    	catch(Exception e) {
    		System.out.println("Exception " + e + " Occurred");
    	}
    }
   
    public static double getTotalWeight(ArrayList<Sweets> sweets) {
    	double Weight = 0;
    	for(Sweets sweet: sweets) {
    		Weight += sweet.getTotalWeight();
    	}
    	return Weight;
    }
   
    public static double getTotalCost(ArrayList<Sweets> sweets) {
    	double Cost = 0;
    	for(Sweets sweet: sweets) {
    		Cost += sweet.getTotalCost();
    	}
    	return Cost;
    }
}