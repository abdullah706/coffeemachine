package logique;

public class Main {

	public static void main(String[] args) {
		
		Report dailyReport=new Report();
		
		CustomerInteraction order=new CustomerInteraction(TypeDrink.COFFEE, 2, 80,false);
		ProtocolCommandCreator protocol=new ProtocolCommandCreator(order,dailyReport);
		protocol.showOrderOrMessage();
		//System.out.println(dailyReport.showReport());
	}

}