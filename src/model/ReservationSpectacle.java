package model;

public class ReservationSpectacle extends Reservation {
	private int numZone;
	private int numChaise;
	
	public ReservationSpectacle(int jour, int mois, int numZone, int numChaise) {
		super(jour, mois);
		this.numZone = numZone;
		this.numChaise = numChaise;
	}
	
	@Override
	public String toString() {
		String str = new String();
		str = "Le " + jour + "/" + mois + " : zone n°" + numZone + " avec ";
		if(numChaise == 1) return str + "1 chaise";
		str = str + numChaise + " chaises";
		return str;
	}
}
