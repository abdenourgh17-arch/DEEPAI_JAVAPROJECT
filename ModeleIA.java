public abstract class ModeleIA {
    protected String nom;
    protected double tarifParMTok; // Prix pour 1 million de tokens

    public ModeleIA(String nom, double tarifParMTok) {
        this.nom = nom;
        this.tarifParMTok = tarifParMTok;
    }

    // Calcul simple du cout
    public double calculerPrix(int nbTokens) {
        return (nbTokens / 1000000.0) * tarifParMTok;
    }

    public String getNom() {
        return nom;
    }

    public double getTarifParMTok() {
        return tarifParMTok;
    }
}
