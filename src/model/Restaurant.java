package model;

public class Restaurant {
	private CentraleReservation<EntiteReservable<FormulaireRestaurant>, FormulaireRestaurant> centrale = new CentraleReservation<>(
			new Table[100]);

	public int ajouterTable(int nbChaises) {
		return centrale.ajouterEntite(new Table(nbChaises));
	}

	public int[] donnerPossibilites(FormulaireRestaurant formulaire) {
		return centrale.donnerPossibilites(formulaire);
	}

	public Reservation reserver(int numEntite, FormulaireRestaurant form) {
		return centrale.reserver(numEntite, form);
	}

	private static class Table extends EntiteReservable<FormulaireRestaurant> {
		private int nbChaise = 0;
		private CalendrierAnnuel calenDeuxieme = new CalendrierAnnuel();

		public Table(int nbChaise) {
			this.nbChaise = nbChaise;
		}

		@Override
		public boolean compatible(FormulaireRestaurant formulaire) {
			boolean Service1 = false;
			boolean Service2 = false;
			if (estLibre(formulaire) && formulaire.getNumService() == 1) {
				Service1 = true;
			}
			if (calenDeuxieme.estLibre(formulaire.getJour(), formulaire.getMois())) {
				Service2 = true;
			}

			boolean answer = (nbChaise == formulaire.getNombrePersonnes())
					|| (nbChaise == formulaire.getNombrePersonnes() + 1);
			return answer;
		}

		@Override
		public Reservation reserver(FormulaireRestaurant formulaire) {
			if (formulaire.getNumService() == 1) {
				calendrier.reserver(formulaire.getJour(), formulaire.getMois());
			} else {
				calenDeuxieme.reserver(formulaire.getJour(), formulaire.getMois());
			}
			return new ReservationRestaurant(formulaire.getJour(), formulaire.getMois(), formulaire.getNumService(),
					formulaire.getNombrePersonnes());
		}

	}
}
