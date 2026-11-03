public class DeepChat {
    private String promptSysteme;

    public DeepChat() {
        this.promptSysteme = "Tu es DeepAI, un assistant virtuel intelligent.";
    }

    // Demarre une conversation avec le prompt systeme inclus
    public Conversation demarrerConversation(String titre, ModeleIA modele) {
        Conversation c = new Conversation(titre, modele);
        c.ajouterMessage(new Message("SYSTEM", promptSysteme));
        return c;
    }

    // Envoi d'un message avec reponses simples
    public void envoyerMessage(Utilisateur u, Conversation c, String texte) {
        System.out.println("Utilisateur : " + texte);

        // 1. Ajouter le message de l'utilisateur
        Message msgUser = new Message("USER", texte);
        c.ajouterMessage(msgUser);

        // 2. Extraire info personnelle pour la pub
        u.extraireDonneesPub(texte);

        // 3. Reponse predefinie selon le message
        String reponse = "";
        String min = texte.toLowerCase();
        if (min.contains("bonjour")) {
            reponse = "Bonjour ! Comment puis-je t'aider ?";
        } else if (min.contains("cours")) {
            reponse = "Je peux t'aider avec tes cours, sur quelle matiere ?";
        } else {
            reponse = "Voici la reponse du modele " + c.getModele().getNom();
        }

        // 4. Ajouter la reponse du bot
        Message msgBot = new Message("BOT", reponse);
        c.ajouterMessage(msgBot);

        System.out.println(c.getModele().getNom() + " : " + reponse);

        // Tokens consommes sur cet echange
        int tokensTour = msgUser.getNbTokens() + msgBot.getNbTokens();
        System.out.println("-> Tokens pour cet echange : " + tokensTour);
        System.out.println();
    }

    // Fin de la conversation et facturation
    public void finConversation(Utilisateur u, Conversation c) {
        System.out.println("=== Fin de la conversation : " + c.getTitre() + " ===");
        int totalTokens = c.getTokensTotaux();
        double prix = c.getPrixTotal();

        System.out.println("Total de tokens consommes : " + totalTokens);
        System.out.println("Prix total a facturer : " + prix + " $");

        // Paiement et archivage
        u.debiter(prix);
        u.ajouterConversation(c);
        System.out.println("Nouveau solde de " + u.getNom() + " : " + u.getSolde() + " $\n");
    }
}
