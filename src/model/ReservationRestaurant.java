package model;

public class ReservationRestaurant extends Reservation {
	private int jour;
	private int mois;
	private int numService;
	private int numTable;

	public ReservationRestaurant(int jour, int mois, int numService, int numTable) {
		super(jour, mois);
		this.numService = numService;
		this.numTable = numTable;
	}

	@Override
	public String toString() {
		return "Le " + jour + "/" + mois + " Table " + numTable + " pour le "
				+ (numService == 1 ? "premier" : "deuxième") + " service.";
	}
}