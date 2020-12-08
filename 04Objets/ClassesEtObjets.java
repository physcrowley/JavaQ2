/**
 * Une classe est une définition
 * 
 * Un objet est quelque chose qui vit en mémoire, qui est créé selon
 * la définition dans une classe
 * 
 * Les objets ont donc tous un type qui commence avec une majuscule
 * en Java, parce que le type est le nom de la classe qui définit l'objet.
 * 
 * Dans une application, il y a aussi toujours une classe principale qui
 * définit la méthode main(). Cette classe est la classe principale d'une
 * mini application qui inclut aussi les classes MonTableau et Vecteurs2D.
 * 
 * David Crowley, crowlda@ecolecatholique.ca
 * 2020-12-08
 */
public class ClassesEtObjets 
{
    public static void main(String[] args) 
    {
        String s = "";
        /* 
        *   > String est une classe qui définit un type
        *   > s est un objet qui applique ces définitions et accède
        *   aux méthodes de la classe String
        */


        // Objets de type MonTableau

        MonTableau tableau = new MonTableau(), tab2 = new MonTableau();
            // le mot-clé new est utilisé pour créer un objet à partir d'une
            // définition dans la classe
        tableau.tab = new int[] {1, 3, 5, 8, 0};
        tab2.tab = new int[] {-2, 5, -100, 73};
        System.out.printf("max1=%d, milieu=%d\n",tableau.getMax(), tableau.getMid());
        System.out.println(tableau);
        System.out.printf("max2=%d, milieu=%d\n",tab2.getMax(), tab2.getMid());
        System.out.println(tab2);


        // Objet de type Vecteurs2D

        Vecteurs2D balle = new Vecteurs2D();
            // le mot-clé new est utilisé pour créer un objet à partir d'une
            // définition dans la classe
        balle.vitesse[1] = 12; // vy... vx reste 0 (comme définie dans la classe)
        balle.bouger();
        System.out.println(balle);
        balle.bouger();
        System.out.println(balle);
    }
}
