import java.util.ArrayList;

public class Conversation {
    private String titre;
    private ModeleIA modele;
    private ArrayList<Message> messages;

    public Conversation(String titre, ModeleIA modele) {
        this.titre = titre;
        this.modele = modele;
        this.messages = new ArrayList<Message>();
    }

    public void ajouterMessage(Message m) {
        messages.add(m);
    }

    // Calcule la somme des tokens de tous les messages (prompt systeme + echanges)
    public int getTokensTotaux() {
        int total = 0;
        for (int i = 0; i < messages.size(); i++) {
            total = total + messages.get(i).getNbTokens();
        }
        return total;
    }

    // Calcule le prix total de la conversation
    public double getPrixTotal() {
        return modele.calculerPrix(getTokensTotaux());
    }

    public String getTitre() {
        return titre;
    }

    public ModeleIA getModele() {
        return modele;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }
}
