public class Main {
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("          TEST DEEPAI         ");
        System.out.println("=========================================\n");

        // Cas a : Creation de l'utilisateur
        System.out.println(">>> 1. Creation de l'utilisateur");
        Utilisateur user = new Utilisateur("Abdenour", 10.0); // solde de 10 $
        user.afficherProfil();

        // Cas b : Conversation fictive avec DeepChat
        System.out.println(">>> 2. Test DeepChat (Chatbot Web)");
        DeepChat chat = new DeepChat();
        ModeleIA modeleChat = new DeepMedium(); // Choix du modele

        System.out.println("Modele choisi : " + modeleChat.getNom());
        Conversation conv = chat.demarrerConversation("Discussion revision", modeleChat);

        // Echange 1 : Bonjour
        chat.envoyerMessage(user, conv, "Bonjour");

        // Echange 2 : Cours
        chat.envoyerMessage(user, conv, "J'ai besoin d'aide pour mon cours de Java");

        // Fin de conversation et facturation
        chat.finConversation(user, conv);

        // Cas c : Utilisation d'un agent avec DeepBot
        System.out.println(">>> 3. Test DeepBot (Agent Autonome)");
        DeepBot bot = new DeepBot();
        bot.afficherMenuAgents();

        // Choix de l'agent DeepThink
        ModeleIA agentChoisi = new DeepThink();
        System.out.println("\nAgent selectionne : " + agentChoisi.getNom());

        // Execution de la mission
        bot.executerMission(user, agentChoisi, "Besoin d'aide pour resumer le cours de POO");

        // Bilan final
        System.out.println(">>> 4. Profil final du client");
        user.afficherProfil();

        System.out.println("=========================================");
        System.out.println("             FIN DU TEST                 ");
        System.out.println("=========================================");
    }
}
