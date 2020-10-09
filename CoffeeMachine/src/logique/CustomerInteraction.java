package logique;

//this class give a description about global information of an order
public class CustomerInteraction {
	private TypeDrink drink;
	private int sugarNumber;
	private int customerMoney; // the amount of money put in the machine by the customer in cents
	private boolean extraHot;
	
	public CustomerInteraction(TypeDrink drink,int sugarNumber,int customerMoney,boolean extraHot) {
		this.drink=drink;
		this.sugarNumber=sugarNumber;
		this.customerMoney=customerMoney;
		this.extraHot=extraHot;
	}

	public TypeDrink getDrink() {
		return this.drink;
	}

	public int getSugarNumber() {
		return this.sugarNumber;
	}

	public int getCustomerMoney() {
		return this.customerMoney;	
	}
	
	public boolean getExtraHot() {
		return this.extraHot;
	}
}