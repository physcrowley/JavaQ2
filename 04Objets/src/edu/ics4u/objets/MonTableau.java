package edu.ics4u.objets;
/**
 * contient un tableau et une méthode pour trouver la valeur maximum
 * 
 * David Crowley, crowlda@ecolecatholique.ca
 * 2020-12-08
 */
public class MonTableau 
{
    // les champs (ou attributs ou valeurs) de la classe
    
    int[] tab;


    // les méthodes de la classe

    /** obtenir la valeur maximale dans le tableau */
    int getMax()
    {
        int max = this.tab[0];
            // "this." réfère à l'objet qui appelle la fonction
            // et utilise donc les valeurs dans le tableau tab
            // spécifique à chaque objet en exécutant la méthode
        
        for (int n : this.tab)
        {
            if (n > max) max = n;
        }
        return max;
    }

    /** obtenir l'objet au milieu du tableau */
    int getMid()
    {
        // la valeur à l'indice du milieu, soit longueur / 2
        return this.tab[(this.tab.length-1)/2];
    }
    
    /** Définir comment afficher l'objet quand on fait un print
     * 
     * Cette méthode est définie par défaut dans Objet.java... le grand-parent de
     * tous les objets Java, mais produit une série de symboles au lieu de présenter
     * de l'information plus pertinente sur les valeurs de l'objet.
     * 
     * Il faut que la signature soit exactement pareil à ce que tu vois ci-dessous
     * 
     * @return le String à afficher -> ne pas imprimer dans cette méthode, mais
     *          plutôt définir le String qui sera afficher dans un print
     */
    public String toString()
    {
        String s = "[";
        for (int i = 0; i < this.tab.length; i++)
        {
            s += i < this.tab.length - 1 ? this.tab[i]+", " : this.tab[i];
        }
        s += "]";
        return s;
    }
}
