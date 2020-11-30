import java.util.Scanner;

/*

Types natifs : int, double, etc. --> seulement une valeur

Objets : String, cette classe Objets 
    --> valeurs (champs/attributs) et 
    --> comportements (méthodes/fonctions)

* Objets, incluant toutes les classes que vous écrivez, commencent
par une lettre majuscule (A-Z).
* Variables > commencent avec une lettre minuscule
* Fonctions > lettre minuscule
* Types natifs > lettre minuscule

*/

public class Objets
{
    static Scanner input = new Scanner(System.in); // valeur de la classe Objets
    
    public static void main(String[] args) // comportement de la classe Objets
    {
        
        String s = "WoHoOoO!"; // "WoHoOoO!" est la valeur de l'objet s (type String)

        s = s.toLowerCase(); // toLowerCase() est un comportement défini pour l'objet s
        //System.out.println(s);

        // TABLEAUX
        // type fixe, taille fixe, valeurs accessibles avec un indice
        // --> pour des structures de taille connue; très rapide
        int[] nums = {1,1,2,3,5,8,13,21,34}; // tableau intialisé avec des valeurs

        for (int i = 0; i < nums.length; i++)
        {
            System.out.print(nums[i] + ", "); // accéder aux valeurs avec un indice
        }

        String[] noms = new String[6]; // tableau vide de taille 6
        noms[0] = "Wesley";
        noms[1] = "Simon";
        noms[2] = "Zachary";

        for (String n : noms) // pour lire les valeurs dans un tableau
        {
            System.out.println(n);
        }

        // HashMap
        // types fixes, taille flexible, valeurs accessibles avec une clé
        // --> pour accéder aux valeur par quelque chose d'autre qu'un chiffre
        // --> accès rapide avec une taille flexible


        // LinkedList
        // types fixes, taille flexible, valeurs accessibles par recherche
        // --> si on doit ajouter/enlever des éléments souvent
        // --> si on veut trier souvent les éléments (les bouger)


        //--------STRUCTURE<-->LOGIQUE-------------//
        //--------STRUCTURE-ALGORITHME-------------//

        // le choix de structure affecte comment tu écris la logique
        // de ton programme. La bonne structure peut simplifier ton
        // code énormément et le rendre plus facile à maintenir/modifier.

    }
}