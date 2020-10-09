package logique;

import java.util.HashMap;

public class Report {

	private HashMap<TypeDrink,Integer> nbDrinkConsumed = new HashMap<TypeDrink, Integer>(); 
	private int moneyEarned;
	
	public Report() {
		this.moneyEarned=0;
		nbDrinkConsumed.put(TypeDrink.TEA, 0);
		nbDrinkConsumed.put(TypeDrink.COFFEE, 0);
		nbDrinkConsumed.put(TypeDrink.CHOCOLATE, 0);
		nbDrinkConsumed.put(TypeDrink.ORANGE_JUICE, 0);
	}
	
	public void drinkConsumed(TypeDrink drink) {
		this.moneyEarned+=drink.getPrice();
		int actualNbDrink = nbDrinkConsumed.get(drink);
		nbDrinkConsumed.put(drink, ++actualNbDrink);
	}
	
	public int getMoney() {
		return this.moneyEarned;
	}
	
	//private HashMap<TypeDrink,Integer> getNbDrinkConsumed(){
	//	return this.nbDrinkConsumed;
	//}
	
	public String showReport() {
		return "Tea: "+nbDrinkConsumed.get(TypeDrink.TEA)+"\n"+ 
			   "Coffee: "+nbDrinkConsumed.get(TypeDrink.COFFEE)+"\n"+
			   "Chocolate: "+nbDrinkConsumed.get(TypeDrink.CHOCOLATE)+"\n"+
			   "Orange juice: "+nbDrinkConsumed.get(TypeDrink.ORANGE_JUICE)+"\n"+
			   "Total money earned: "+(float)moneyEarned/100+"€";
		
	}
	
	
}
