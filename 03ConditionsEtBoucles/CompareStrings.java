public class CompareStrings {
    public static void main(String[] args) {
      // exemples de réponse saisie via le Scanner (p.ex. input)
      String inputFromScanner = "DroITe";
      
      String choix = inputFromScanner.toLowerCase(); //input.nextLine().toLowerCase();
      System.out.println("choix : " + choix);
      
      // == compare si les deux objets String sont les mêmes
      // objets en mémoire... compare des adresses, pas le texte dans l'objet
      
      System.out.println("Compare with == : choix == \"droite\"\n\t--> not recommended");
      System.out.println(choix == "droite"); // false
      
      
      // POUR COMPARER DU TEXTE, VOUS DEVRIEZ PLUTÔT UTILISER
      // la méthode s1.equals(s2) compare le texte dans les objets String
      // 
      // la méthode s1.equalsIgnoreCase(s2) compare le texte en ignorant la case
       
      System.out.println("\nCompare with .equals() or .equalsIgnoreCase() : choix.equals(\"droite\")\n\t-->recommanded");
      System.out.println(choix.equals("droite")); // true
      
    }
}
