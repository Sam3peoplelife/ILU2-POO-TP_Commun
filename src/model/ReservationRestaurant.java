package model;

public class ReservationRestaurant extends Reservation{
	
	private int numService;
	private int numTable;
	
	public ReservationRestaurant(int jour, int mois, int numService, int numTable) {
		super(jour, mois);
		this.numService = numService;
		this.numTable = numTable;
	}
	
	@Override
	public String toString() {
		String str = new String();
		str = "Le " + jour + "/" + mois +'\n' + "Table " + numTable + " pour le ";
		if(numService == 1) return str + "premier service.";
		return str + "deuxième service.";
	}
	
}
