package giftitems;

import java.util.ArrayList;

import com.epam.mavendemo.Gift;

public class Sweets extends Gift{
	
	public Sweets() {
		chocolates = new ArrayList<Chocolates>();
		candies = new ArrayList<Candies>();
	}

	public void addChocolates(ArrayList<Chocolates> chocolates) {
		this.chocolates = chocolates;
	}
	
	public void addCandies(ArrayList<Candies> candies) {
		this.candies = candies;
	}
	
	public void addTotalWeight(double weight) {
		this.totalWeight += weight;
	}
	
	public void addTotalCost(double cost) {
		this.totalCost += cost;
	}
	
	public ArrayList<Chocolates> getChocolates() {
		return chocolates;
	}
	
	public ArrayList<Candies> getCandies() {
		return candies;
	}
	
	double getCost() {
		return cost;
	}
	
	public double getTotalCost() {
		return totalCost;
	}
	
	public double getTotalWeight() {
		return totalWeight;
	}
	
	public void printChocolates() {
		for(Chocolates choco: chocolates) {
			System.out.println(choco.toString());
		}
	}
	
	public void printCandies() {
		for(Candies candie: candies) {
			System.out.println(candie.toString());
		}
	}
}