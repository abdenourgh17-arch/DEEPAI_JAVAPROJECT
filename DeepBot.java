public class DeepBot {
    private String promptSysteme;

    public DeepBot() {
        this.promptSysteme = "Tu es DeepBot, un agent autonome.";
    }

    public void afficherMenuAgents() {
        System.out.println("Choix des agents disponibles :");
        System.out.println("  1. DeepFast   (0.10 $ / MTok)");
        System.out.println("  2. DeepMedium (0.50 $ / MTok)");
        System.out.println("  3. DeepThink  (1.00 $ / MTok)");
    }

    // Execute une mission avec l'agent choisi
    public void executerMission(Utilisateur u, ModeleIA agent, String mission) {
        System.out.println("--- Lancement agent autonome : " + agent.getNom() + " ---");

        Conversation c = new Conversation("Mission CLI - " + agent.getNom(), agent);
        c.ajouterMessage(new Message("SYSTEM", promptSysteme));

        // Message de mission utilisateur
        Message msgUser = new Message("USER", mission);
        c.ajouterMessage(msgUser);
        u.extraireDonneesPub(mission);

        System.out.println("Mission recue : " + mission);

        // Reponse de l'agent
        String reponse = "";
        if (mission.toLowerCase().contains("cours")) {
            reponse = "Agent " + agent.getNom() + " : J'ai analyse vos cours et prepare le resume.";
        } else {
            reponse = "Agent " + agent.getNom() + " : Mission executee avec succes.";
        }

        Message msgBot = new Message("AGENT", reponse);
        c.ajouterMessage(msgBot);

        System.out.println(reponse);

        // Facturation
        int totalTokens = c.getTokensTotaux();
        double prix = c.getPrixTotal();

        System.out.println("Tokens consommes : " + totalTokens);
        System.out.println("Prix de la mission : " + prix + " $");

        u.debiter(prix);
        u.ajouterConversation(c);
        System.out.println("Nouveau solde de " + u.getNom() + " : " + u.getSolde() + " $\n");
    }
}
