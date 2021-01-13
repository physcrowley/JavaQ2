/**
 * Exemples pour montrer comment gérer les déclarations qui seront exécutées
 * durant l'exécution du programme, notamment un utilisant :
 * > les conditions et 
 * > les boucles
 * 
 * David Crowley, crowlda@ecolecatholique.ca
 * 2020-11-24
 */
class Flow
{
    public static void main(String[] args) 
    {
        //----------OPÉRATEURS----------//
        
        /*
        Mathématiques : + - / * , fonctions de la class Math

        Comparaison : > < >= <= == !=

        Logique : && (et), || (ou), ! (not)

        */


        //----------CONDITIONS---------//
        /*
        if, else if, else --> USAGE : générale

        switch-case --> USAGE : comparer avec une liste de choix fixe

        */

        /* STRUCTURE if / else if / else

        <mot-clé> (<condition entre parenthèses>)
        {
            <déclarations si la condition est true>;
        }
        else
        {
            <déclaration si aucune autre condition n'est true>;
        }
        */

        int A = 1;
        int B = 3;
        if (A == B)
        {
            System.out.println("A est égale à B");
        } 
        else if (A < B)
        {
            System.out.println("A est moins grand que B");
        } 
        else 
        {
            System.out.println("A est plus grand que B");
        }

        /* STRUCTURE switch-case

        switch (<variable>)
        {
            case <valeur1> : <déclarations si la variable est égale à valeur 1>;
            case <valeur2> : <déclarations si la variable est égale à valeur 2>;
            default : <déclarations si la variable ne correspond à aucun cas>;
        }

        ATTENTION! Le premier cas qui est true est le POINT D'ENTRÉE pour l'exécution.
        Toutes les déclarations qui suivent le 1e cas true seront exécutées.

        Si on veut changer ce comportement, il faut inclure une déclaration "break;" à la
        fin de chaque cas.

        */

        String couleur = "vert";
        switch (couleur)
        {
            case "rouge": 
                System.out.println("la couleur est rouge"); 
                break;
            case "vert" : 
                System.out.println("la couleur est vert");
                break;
            case "bleu": 
            case "mauve":
                System.out.println("une couleur haute fréquence");
                break;
            default: 
                System.out.println("ta couleur n'est pas dans la liste");
        }
        // voir aussi https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html



        //--------------BOUCLES---------------//

        /*
        for --> USAGE : générale quand on connaît la quantité de répétitions

        "for each" --> USAGE : pour lire les structures de données comme les tableaux et les listes

        while --> USAGE : répétition générale (fin inconnue)
        
        */

        /* STRUCTURE  for
        
        for (int i = <début>; <condition de fin>; <opération pour changer i>) {}

        Exemples:
            for (int i = 0; i < 2000; i++) {} --> i++ veut dire i = i + 1
            for (int bla = 10; bla > 0; bla--) {} --> bla-- veut dire bla = bla - 1
            for (int j = 0; j < 256; j = j*2) {} --> on peut modifier la variable de boucle comme on veut

        Notez que la variable de boucle est toujours de type int.

        */
        for (int i = 0; i < 5; i++)
        {
            System.out.println(i);
        }
        /* Sortie
        0
        1
        2
        3
        4
        */


        /* STRUCTURE "for each"
        
        for (<type des éléments dans le tableau> <variable qui représente un élément> : <tableau>) {}

        Exemples:
            int[] nums --> les crochets [] après le type indique que c'est un tableau ("array") de ce type
            for (int n : nums)

            String[] args
            for (String a : args)

        ATTENTION! on peut seulement observer les éléments : les afficher ou utiliser leurs valeurs
        pour faire un calcul. On ne peut pas modifier les valeurs avec ce type de boucle. Pour modifier
        les valeurs, utiliser une boucle for avec la structure suivante :

        for (int i = 0; i < <tableau>.length; i++)
        {
            // accéder aux éléments avec <tableau>[i]
        }

        */
        int[] nums = {1, 1, 2, 3, 5, 8, 13, 21}; // fibonacci
        for (int e : nums)
        {
            System.out.print(e + " ");
        }
        System.out.println();
        /* Sortie
        1 1 2 3 5 8 13 21 

        */


        /* STRUCTURE while

        while (<condition>)
        {
            <déclarations à répéter tant que la condition reste true>;
        }

        ATTENTION! C'est facile de créer des boucles while infinies si on ne fournit
        pas un moyen de changer la valeur de la variable utilisée dans la condition
        ou, alternativement, une déclaration "break;" dans une condition à l'intérieur 
        de la boucle.

        */
        double test = 0.0;

        // afficher tous les nombres jusqu'à temps d'en avoir un >= 0.8
        while (test < 0.8)
        {
            test = Math.random(); // génerer un nombre aléatoire (entre 0.0 et 1.0)
            System.out.print(test + ", ");
        }
        System.out.println();
    }
}