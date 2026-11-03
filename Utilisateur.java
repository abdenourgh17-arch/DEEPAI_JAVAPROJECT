import java.util.ArrayList;

public class Utilisateur {
    private String nom;
    private double solde;
    private ArrayList<Conversation> historique;
    private ArrayList<String> donneesPersonnelles; // pour pub ciblee

    public Utilisateur(String nom, double soldeInitial) {
        this.nom = nom;
        this.solde = soldeInitial;
        this.historique = new ArrayList<Conversation>();
        this.donneesPersonnelles = new ArrayList<String>();
    }

    public void rechargerSolde(double montant) {
        this.solde = this.solde + montant;
        System.out.println(nom + " a recharge son solde de " + montant + " $. Nouveau solde : " + this.solde + " $");
    }

    public boolean debiter(double montant) {
        if (this.solde >= montant) {
            this.solde = this.solde - montant;
            return true;
        } else {
            System.out.println("Solde insuffisant pour " + nom + " !");
            return false;
        }
    }

    public void ajouterConversation(Conversation c) {
        this.historique.add(c);
    }

    // Extrait des centres d'interet simples pour la pub ciblee
    public void extraireDonneesPub(String message) {
        String msgMin = message.toLowerCase();
        if (msgMin.contains("cours") && !donneesPersonnelles.contains("Interet pour les cours")) {
            donneesPersonnelles.add("Interet pour les cours");
        }
    }

    public void afficherProfil() {
        System.out.println("--- Profil Utilisateur ---");
        System.out.println("Nom : " + nom);
        System.out.println("Solde actuel : " + solde + " $");
        System.out.println("Donnees personnelles (pub) : " + donneesPersonnelles);
        System.out.println("Nombre de conversations : " + historique.size());
        System.out.println("---------------------------\n");
    }

    public String getNom() {
        return nom;
    }

    public double getSolde() {
        return solde;
    }

    public ArrayList<Conversation> getHistorique() {
        return historique;
    }

    public ArrayList<String> getDonneesPersonnelles() {
        return donneesPersonnelles;
    }
}
