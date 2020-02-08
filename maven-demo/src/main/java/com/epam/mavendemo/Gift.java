package com.epam.mavendemo;
import java.util.ArrayList;
import giftitems.Candies;
import giftitems.Chocolates;

public abstract class Gift {
	protected String name;
	protected double cost;
	protected double weight;
	protected double totalWeight;
	protected double totalCost;
	protected ArrayList<Chocolates> chocolates;
	protected ArrayList<Candies> candies;
}
