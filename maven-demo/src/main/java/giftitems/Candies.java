package giftitems;
public class Candies extends Sweets implements Comparable<Candies>{
	
	public Candies(String name, double cost, double weight) {
		this.name = name;
		this.cost = cost;
		this.weight = weight;
	}
	
	public Candies() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
        return "Candy { " +
                "Name = '" + name + '\'' +
                ", Cost = ₹" + cost +
                " /-, Weight = " + weight + " grams };";
    }
	@Override
	public int compareTo(Candies c) {
		return (this.getCost() < c.getCost() ? -1 : 
            (this.getCost() == c.getCost() ? 0 : 1));
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