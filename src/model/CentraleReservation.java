package model;

public class CentraleReservation<E extends EntiteReservable<F>, F extends Formulaire> {
    private E[] entites;
    private int taille;

    public CentraleReservation(E[] entites) {
        this.entites = entites;
        this.taille = 0;
    }

    public int ajouterEntite(E entite) {
        entite.setNumero(taille + 1);
        entites[taille] = entite;
        return ++taille;
    }

    public int[] donnerPossibilites(F formulaire) {
        int[] result = new int[entites.length];
        for (int i = 0; i < taille; i++) {
            if (entites[i].compatible(formulaire)) {
                result[i] = entites[i].getNumero(); 
            } else {
                result[i] = 0;
            }
        }
        return result;
    }

    public Reservation reserver(int numero, F formulaire) {
        for (int i = 0; i < taille; i++) {
            E entite = entites[i];
            if (entite.getNumero() == numero) {
                if (entite.compatible(formulaire)) {
                    return entite.reserver(formulaire);
                } else {
                    return null;
                }
            }
        }
        return null;
    }
}