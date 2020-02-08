package com.epam.mavendemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import giftitems.Candies;
import giftitems.Chocolates;
import giftitems.Sweets;

public class Range_gift {
	int noOfChocolates, noOfCandies;
	double cost, weight;
	String name;
	static Scanner scanner;
	Range_gift() {
		scanner = new Scanner(System.in);
	}
	Sweets addDemoGift() {
		Sweets sweets = new Sweets();
		ArrayList<Chocolates> chocolates = new ArrayList<Chocolates>();
		ArrayList<Candies> candies = new ArrayList<Candies>();
		Chocolates c = new Chocolates("Cadbury", 85, 72);
		chocolates.add(c);
    	c = new Chocolates("Snickersr", 30, 20);
    	chocolates.add(c);
    	c = new Chocolates("Ferrero Rocher", 220, 250);
    	chocolates.add(c);

        sweets.addChocolates(chocolates);
        
        Candies cd = new Candies("Cotton candy", 100, 150);
    	candies.add(cd);
    	cd = new Candies("Lollipop", 30, 60);
    	candies.add(cd);
    	cd = new Candies("Melody", 50, 95);
    	candies.add(cd);

        sweets.addCandies(candies);
    	sweets.addTotalWeight(647);
    	sweets.addTotalCost(515);
        return sweets;
	}
	void addChocolates(Sweets sweets) {
		ArrayList<Chocolates> chocolates = new ArrayList<Chocolates>();
		
        System.out.println("Enter " + noOfChocolates + " chocolate Details (Name, Cost, weight(in grams))");
        
        for(int i = 0; i < noOfChocolates; i++) {
        	name = scanner.next();
        	cost = scanner.nextDouble();
        	weight = scanner.nextDouble();
        	sweets.addTotalWeight(weight);
        	sweets.addTotalCost(cost);
        	Chocolates c = new Chocolates(name, cost, weight);
        	chocolates.add(c);
        }
        sweets.addChocolates(chocolates);
	}	
	void addCandies(Sweets sweets) {
		ArrayList<Candies> candies = new ArrayList<Candies>();
		
        System.out.println("Enter " + noOfCandies + " candie Details (Name, Cost(in rupees), weight(in grams))");   
        for(int i = 0; i < noOfCandies; i++) {
        	name = scanner.next();
        	cost = scanner.nextDouble();
        	weight = scanner.nextDouble();
        	sweets.addTotalWeight(weight);
        	sweets.addTotalCost(cost);
        	Candies c = new Candies(name, cost, weight);
        	candies.add(c);
        }
        sweets.addCandies(candies);
	}
	
	Sweets addGift() {
		Sweets sweets = new Sweets();
        System.out.println("Enter Number of Chocolates(N) and Candies(M) ");
        noOfChocolates = scanner.nextInt();
        noOfCandies = scanner.nextInt();
        if(noOfChocolates > 0) {
            this.addChocolates(sweets);
        }
        if(noOfCandies > 0) {
	        this.addCandies(sweets);
        }
        return sweets;
	}
	
	void getChocolates(Sweets sweets, int type) {
		ArrayList<Chocolates> chocolates = sweets.getChocolates();
		
		switch(type) {
			case 1:
				Collections.sort(chocolates, Collections.reverseOrder());
				sweets.printChocolates();
				break;
			case 2:
				Collections.sort(chocolates);
				sweets.printChocolates();
				break;
			default:
				System.out.println("Invalid Choice");
		}
		
	}
	
	void getCandies(Sweets sweets, int type) {
		ArrayList<Candies> candies = sweets.getCandies();
		switch(type) {
			case 1:
				Collections.sort(candies, Collections.reverseOrder());
				for(Candies candie: candies) {
					System.out.println(candie.toString());
				}
				break;
			case 2:
				Collections.sort(candies);
				for(Candies candie: candies) {
					System.out.println(candie.toString());
				}
				break;
			default:
				System.out.println("Invalid Choice...");
		}
		
	}
	
	void calRange(Sweets sweet, int type, int lower_bound, int upper_bound) {
		ArrayList<Chocolates> chocolates = sweet.getChocolates();
		ArrayList<Candies> candies = sweet.getCandies();
		
		switch(type) {
			case 1:
				int ChocolatesCost = 0, CandiesCost = 0;
				System.out.println("	Chocolates in range [" + lower_bound + ", " + upper_bound + "] cost:\n");
				for(Chocolates choco: chocolates) {
					if(choco.cost >= lower_bound && choco.cost <= upper_bound) {
						System.out.println(choco.toString());
						ChocolatesCost += choco.cost;
					}
				}
				if(ChocolatesCost == 0) {
					System.out.println("No Chocolates in the given range ");
				}
				System.out.println("	Candies in range [" + lower_bound + ", " + upper_bound + "] cost:\n");
				for(Candies candie: candies) {
					if(candie.cost >= lower_bound && candie.cost <= upper_bound) {
						System.out.println(candie.toString());
						CandiesCost += candie.cost;
					}
				}
				if(CandiesCost == 0) {
					System.out.println("No Candies in the given range ");
				}
				if(CandiesCost > 0 && ChocolatesCost > 0)
					System.out.println("Total Cost of Sweets = ₹" + String.valueOf(CandiesCost + ChocolatesCost) + " /-\n");
				break;
			case 2:
				int ChocolatesWeight = 0, CandiesWeight = 0;
				System.out.println("	Chocolates in range [" + lower_bound + ", " + upper_bound + "] weight(in grams)\n");
				for(Chocolates choco: chocolates) {
					if(choco.weight >= lower_bound && choco.weight <= upper_bound) {
						System.out.println(choco.toString());
						ChocolatesWeight += choco.weight;
					}
				}
				if(ChocolatesWeight == 0) {
					System.out.println("No Chocolates in the given range ");
				}
				System.out.println("Candies in range [" + lower_bound + ", " + upper_bound + "] weight(in grams):\n");
				for(Candies candie: candies) {
					if(candie.weight >= lower_bound && candie.weight <= upper_bound) {
						System.out.println(candie.toString());
						CandiesWeight += candie.weight;
					}
				}
				if(CandiesWeight == 0) 
					System.out.println("No Candies in the given range \n");
				if(CandiesWeight > 0 && ChocolatesWeight > 0) 
					System.out.println("Total Weight of Sweets = " + String.valueOf(CandiesWeight + ChocolatesWeight) + " grams\n");
				break;
			default:
				System.out.println("Invalid Choice");
		}
	}
}