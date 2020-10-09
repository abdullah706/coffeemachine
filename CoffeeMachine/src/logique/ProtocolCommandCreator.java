package logique;

public class ProtocolCommandCreator {
	private CustomerInteraction orderGlobalInfo;
	private Report dailyReport;
	private String drinkMakerOrder;
	private StringBuilder message = new StringBuilder();
	private boolean orderIsConform;
	
	public ProtocolCommandCreator(CustomerInteraction orderGlobalInfo,Report dailyReport) {
		this.orderGlobalInfo=orderGlobalInfo;
		this.dailyReport=dailyReport;
		orderIsConform=checkOrderConformity();
		drinkMakerOrderConstructor();
	}
	
	private boolean testRawLiquidEnough() {
		
	}
	
	private boolean checkOrderConformity(){
		if(testRawLiquidEnough()) {
			if( checkSugarConformity() && checkMoneyConformity())
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
	private boolean checkSugarConformity() {
		int sugarNB=orderGlobalInfo.getSugarNumber();
		if(sugarNB>2 || sugarNB<0) {
			message.append("Sugar amount is incorrect, chose sugar in range 0-2; \n");
			return false;
		}
		else 
			return true;
	}
	
	private boolean checkMoneyConformity() {
		int remainingMoney=orderGlobalInfo.getCustomerMoney() - orderGlobalInfo.getDrink().getPrice() ;
		if(remainingMoney<0) {
			message.append("Not enought money to order your drink, you need to add "+Math.abs(remainingMoney)+" cents;");
			return false;
		}
		else 
			return true;
	}
	
	// first part is about the id of the drink (first letter) and extra hot option
	private String commandConstructorFirstPart() {
		return (orderGlobalInfo.getDrink().getCanBeExtraHot()==true && orderGlobalInfo.getExtraHot()==true) ? orderGlobalInfo.getDrink().getIdLetter()+"h:" : orderGlobalInfo.getDrink().getIdLetter()+":" ;
	}
	
	// second part is about the number of sugar and the possibility of adding sugar in the drink
	private String commandConstructorSecondPart() {
		return (orderGlobalInfo.getSugarNumber()==0 || orderGlobalInfo.getDrink().getCanBeSugary()==false) ? ":" : orderGlobalInfo.getSugarNumber()+":0";
	}
	
	private void drinkMakerOrderConstructor() {
		if(orderIsConform) {
			drinkMakerOrder = commandConstructorFirstPart()+commandConstructorSecondPart();
			dailyReport.drinkConsumed(orderGlobalInfo.getDrink());
		}
		
	}
	
	public void showOrderOrMessage() {
		if(orderIsConform)
			System.out.println(drinkMakerOrder);
		else
			System.out.println(message.toString());
	}
}