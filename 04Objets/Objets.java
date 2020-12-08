/* Introduction au concept d'un objet en programmation

Types natifs : int, double, etc. 
    --> seulement une valeur

Objets : String, Scanner, cette classe "Objets", Integer, etc.
    --> valeurs (champs/attributs) et 
    --> comportements (méthodes/fonctions)

NOMS DES OBJETS
Commencent par une lettre majuscule (A-Z).
* Variables > commencent avec une lettre minuscule
* Fonctions > lettre minuscule
* Types natifs > lettre minuscule

Par : David Crowley, crowlda@ecolecatholique.ca
2020-11-30

*/

import java.util.HashMap;       // Noter que tous les objets (sauf l'exception String)
import java.util.LinkedList;    // doivent être importés.
import java.util.Random;
import java.util.Scanner;


public class Objets
{
    //---champs (ou attributs ou valeurs) de la classe Objets---
    
    // les champs sont tous des variables
    
    Scanner input = new Scanner(System.in);


    //---méthodes (comportements) de la classe Objets---

    /* 
       Normalement, quand on définit une classe qui sera utilisée 
        pour définir des objets, la classe n'inclut pas de méthode
        main().
       Une application typique inclut une seule classe principale
        (celle qu'on nomme quand on lance la commande `java`) avec 
        une méthode main() et les autres classes sont utilisées pour
        définir des objets utiles à l'application.
        
       Voir les exemples où ClassesEtObjets est la classe principale
        est MonTableau et Vecteurs2D sont des classes qui définissent
        des objets pour une structure et une relation plus typique entre
        les classes d'une application.
    */
    
    public static void main(String[] args)
    {
        
        String s = "WoHoOoO!"; // "WoHoOoO!" est la valeur de l'objet s (de type String)

        s = s.toLowerCase(); // toLowerCase() est un comportement défini pour l'objet s
        System.out.println(s);


        /*--------QUELQUES OBJETS UTILES-----------*/


        //-----------TABLEAUX-----------------
        // type fixe, taille fixe, valeurs accessibles avec un indice
        // --> pour des structures de taille connue; très rapide


        // Exemple. Tableau intialisé avec des valeurs
        int[] nums = {1,1,2,3,5,8,13,21,34}; // valeurs entre accolades, séparées par des virgules 

        for (int i = 0; i < nums.length; i++) // boucle typique pour TRAVAILLER avec les valeurs d'un tableau
        {
            System.out.print(nums[i] + ", "); // accéder aux valeurs avec un indice, i
            if (i == nums.length - 1) System.out.println(); // retour de ligne à la fin
        }

        // Exemple. Tableau vide de taille 6
        String[] noms = new String[6]; 
        // mot-clé "new" crée un objet du type qui le suit; la taille est spécifiée entre crochets

        noms[0] = "Wesley"; // assigner les valeurs individuelles par la suite
        noms[1] = "Simon";
        noms[2] = "Zachary";
        noms[3] = "Ali";
        noms[4] = "Luccin";
        noms[5] = "Charles";

        for (String n : noms) // boucle pour LIRE les valeurs dans un tableau
        {
            System.out.println(n); // n prend la valeur de chaque élément du tableau, en séquence
        }


        /*---------AUTRES OBJETS UTILES-----------*/

        // HASHMAP
        // types fixes, taille flexible, valeurs accessibles avec une clé
        // --> pour accéder aux valeur par quelque chose d'autre qu'un chiffre
        // --> accès rapide avec une taille flexible
        
        HashMap<String, Double> gradeBook = new HashMap<String, Double>();
        // HashMap est un objet qui contient d'autres types d'objets. Des objets comme
        // des HashMap sont appelés "génériques". On ajoute les types spécifiques
        // qu'ils contiennent entre les chevrons <>. Dans le cas de HashMap, il faut
        // indiquer les types pour la clé (key) et pour la valeur (V) : HashMap<K, V>

        for (String n : noms)
        {
            gradeBook.put(n, 100.0);
        }

        System.out.println(gradeBook.get("Zachary"));
        System.out.println(gradeBook.values());


        // LINKEDLIST
        // types fixes, taille flexible, valeurs accessibles par recherche
        // --> si on doit ajouter/enlever des éléments souvent
        // --> si on veut trier souvent les éléments (les bouger)

        LinkedList<Integer> values = new LinkedList<Integer>();
        // LinkedList est aussi un type générique qui peut contenir une
        // variété de types (T) : LinkedList<T>

        Random new_num = new Random(); // un objet pour générer des valeurs aléatoires

        // Créer et afficher une liste de 10 valeurs aléatoires
        for (int i = 0; i < 10; i++) values.add(new_num.nextInt(100));
        System.out.println(values);

        
        // Exemple d'algorithme de tri (Insertion Sort)
        for (int i = 0; i < values.size() - 1; i++) // jusqu'à l'avant-dernier élément
        {
            // l'élément après l'indice i (jusqu'au dernier élément)
            int sortMe = values.get(i+1);

            // comparer des paires de valeurs de reculons à travers la partie déjà triée
            for (int j = i; j >= 0; j--) 
            {
                if (sortMe < values.get(j))
                {
                    // change les valeurs de place
                    int temp = values.get(j);
                    values.set(j, sortMe);
                    values.set(j+1, temp);
                }
                else break; // passe au prochain élément i dans la liste
            }
        }
        System.out.println(values);



        /*----------STRUCTURE<-->LOGIQUE---------------//
                   STRUCTURE<-->ALGORITHME

        Le choix de structure affecte comment tu écris la logique
        de ton programme. 

        La bonne structure peut simplifier ton code énormément et le 
        rendre plus facile à maintenir/modifier. */

    }
}