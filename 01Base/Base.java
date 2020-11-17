// Ajouter la définition pour notre objet Scanner
import java.util.Scanner;

class Base
{
    public static void main(String[] args) 
    {
        // Il faut déclarer le TYPE des variables
        // Format : <type> <nom> = <valeur assignée>;

        String s = "45"; // texte -> usage général
        int n = 3; // nombres entiers -> pour compter
        double d = 3.1415; // nombres décimaux -> pour les calculs

        // conversions de type
        n = Integer.parseInt(s);
        d = Double.parseDouble(s);

        // casting entre types numériques

        n = (int) d;
        d = n;

        // SORTIE AU CONSOLE
        // System.out est la console définit par ton système d'exploitation

        System.out.println(s); // .println() ajoute automatiquement un retour de ligne

        System.out.print(s); //.print() affiche seulement le texte (sans retour de ligne)

        
        // ENTRÉES AU CONSOLE
        // Tu dois créer un objet de type Scanner
        // System.in est aussi la console définit par ton système d'exploitation
        Scanner input = new Scanner(System.in);

        // Indiquer à l'utilisateur d'entreer quelque chose
        System.out.println("Taper un nombre décimal ('.' est le symbole décimal)");
        String getNum = input.nextLine(); // .nextLine() est la méthode pour capter une ligne de texte à la console
        double num = Double.parseDouble(getNum); // convertir la valeur saisie en double
    
        System.out.println("Tu as inscrit le nombre " + num);
        
        System.out.

        input.close(); // fermer / détruire le Scanner sur la console (System.in)
    }
}