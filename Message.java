public class Message {
    private String role;    // SYSTEM, USER ou BOT
    private String texte;
    private int nbTokens;

    public Message(String role, String texte) {
        this.role = role;
        this.texte = texte;
        // Calcul simple : environ 1 token pour 4 caracteres (minimum 5)
        int calcul = texte.length() / 4;
        if (calcul < 5) {
            this.nbTokens = 5;
        } else {
            this.nbTokens = calcul;
        }
    }

    public String getRole() {
        return role;
    }

    public String getTexte() {
        return texte;
    }

    public int getNbTokens() {
        return nbTokens;
    }
}
