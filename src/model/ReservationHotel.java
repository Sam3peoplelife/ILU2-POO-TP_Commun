package model;

public class ReservationHotel extends Reservation {
	private int numChambre;
	private int numLitSimple;
	private int numLitDouble;
	
	public ReservationHotel(int jour, int mois, int numChambre, int numLitSimple, int numLitDouble) {
		super(jour, mois);
		this.numChambre = numChambre;
		this.numLitSimple = numLitSimple;
		this.numLitDouble = numLitDouble;
	}
	
	@Override
	public String toString() {
		String str = new String();
		str = "Le " + jour + "/" + mois + " : chambre n°" + numChambre;
		if(numLitSimple > 0) {
			if(numLitSimple == 1) {
				str = str + "avec 1 lit simple";
			}
			else {
				str = str + "avec " + numLitSimple + " lits simples";
			}
		}
		
		if(numLitDouble > 0) {
			if(numLitDouble == 1) {
				str = str + "avec 1 lit double";
			}
			else {
				str = str + "avec " + numLitDouble + " lits doubles";
			}
		}
		
		
		return str;
	}
}
