package model;

public abstract class EntiteReservable<T extends Formulaire> {
    private int numero;
    protected CalendrierAnnuel calendrier = new CalendrierAnnuel();

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public boolean estLibre(T formulaire) {
        return calendrier.estLibre(formulaire.getJour(), formulaire.getMois());
    }

    public boolean estLibre(int jour, int mois) {
        return calendrier.estLibre(jour, mois);
    }

    public void reserver(int jour, int mois) {
        calendrier.reserver(jour, mois);
    }

    public abstract boolean compatible(T formulaire);
    public abstract Reservation reserver(T formulaire);
}