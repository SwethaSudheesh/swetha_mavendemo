package giftitems;

public class Chocolates extends Sweets implements Comparable<Chocolates>{

	public Chocolates(String name, double cost, double weight) {
		this.name = name;
		this.cost = cost;
		this.weight = weight;
	}
	
	public Chocolates() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compareTo(Chocolates c) {
		return (this.getCost() < c.getCost() ? -1 :
            (this.getCost() == c.getCost() ? 0 : 1));
	}
	
	@Override
	public String toString() {
        return "Chocolate { " +
                "Name = '" + name + '\'' +
                ", Cost = ₹" + cost +
                " /-, Weight = " + weight + " grams };";
    }
	
	@Override
	public void addTotalWeight(double weight) {
		this.totalWeight += weight;
	}
	
	@Override
	public double getTotalWeight() {
		return this.totalWeight;
	}
	
	@Override
	public void addTotalCost(double weight) {
		this.totalCost += cost;
	}
	
	@Override
	public double getTotalCost() {
		return this.totalCost;
	}
}