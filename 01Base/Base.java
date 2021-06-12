/*  Par: David Crowley, crowlda@ecolecatholique.ca 
    2020-11-17
*/

// Au début du fichier, avant la déclaration de classe...
// importer la définition de l'objet Scanner 
import java.util.Scanner;

/** Exemples sur les types et les entrées et sorties au console */
class Base
{
    public static void main(String[] args) 
    {
        //----------TYPES DE DONNÉES----------//

        // Il faut déclarer le TYPE des variables
        // Format : <type> <nom> = <valeur assignée>;

        String s = "45"; // texte -> usage général
        int n = 3; // nombres entiers -> pour compter
        double d = 3.1415; // nombres décimaux -> pour les calculs

        // conversions de type (texte -> nombre)
        n = Integer.parseInt(s);
        d = Double.parseDouble(s);

        // casting entre types numériques
        n = (int) 0.691;
        d = (double) 365;


        //-----------SORTIE À LA CONSOLE-----------//
        
        // System.out 
        // est la console définit par ton système d'exploitation

        // .println() ajoute automatiquement un retour de ligne
        System.out.println(s); 

        //.print() affiche seulement le texte (sans retour de ligne)
        System.out.print(s); 
        System.out.print(", " + n);
        System.out.print(", " + d + "\n"); // \n est le caractère pour un retour de ligne

        
        //-----------ENTRÉES À LA CONSOLE------------//

        // Tu dois créer UN SEUL objet de type Scanner

        // System.in 
        // est la console définit par ton système d'exploitation
        Scanner input = new Scanner(System.in);

        // Indiquer à l'utilisateur d'entrer quelque chose
        System.out.println("Taper un nombre décimal ('.' est le symbole décimal)");

        // Saisir le texte entré avec la méthode .nextLine()
        String getNum = input.nextLine();

        // Convertir le texte capté en valeur numérique (de type double)
        // --> cette étape peut générer une erreur si le texte n'a pas 
        //     le format approprié
        double num = Double.parseDouble(getNum);
        
        // Confirmer le résultat avec un message à la console
        System.out.println("Tu as inscrit le nombre " + num);
        
        // À la fin de la méthode main()...
        // fermer/tuer le Scanner qui observe la console / System.in
        input.close(); 
    }
}