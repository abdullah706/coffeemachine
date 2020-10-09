package logique;

public enum TypeDrink {
	TEA('T',40,true,true),COFFEE('C',60,true,true),CHOCOLATE('H',50,true,true),ORANGE_JUICE('O',60,false,false);
	
	private final char firstLetter;
	private final int price;
	private final boolean canBeSugary;
	private final boolean canBeExtraHot;
	
	private TypeDrink(char firstLetter,int price,boolean canBeSugary,boolean canBeExtraHot) {
		this.firstLetter=firstLetter;
		this.price=price;
		this.canBeSugary=canBeSugary;
		this.canBeExtraHot=canBeExtraHot;
	}
	
	public char getIdLetter() {
		return this.firstLetter;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public boolean getCanBeExtraHot() {
		return this.canBeExtraHot;
	}
	
	public boolean getCanBeSugary() {
		return this.canBeSugary;
	}
}
