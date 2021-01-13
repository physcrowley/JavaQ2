package edu.ics4u.objets;
/**
 * un objet qui contient des éléments de vecteurs en 2 dimensions
 * 
 * David Crowley, crowlda@ecolecatholique.ca
 * 2020-12-08
 */
public class Vecteurs2D 
{
    // les champs (ou attributs ou valeurs) de la classe

    int[] position = {0, 0}; // {px, py}
    int[] vitesse = {0, 0}; // {vx, vy}


    // les méthodes de la classe

    /** modifier la position de chaque dimension selon le vecteur vitesse */
    void bouger()
    {
        this.position[0] += this.vitesse[0]; // les x
        this.position[1] += this.vitesse[1]; // les y
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
        return String.format("pos=[%d, %d] v=[%d, %d]",
            this.position[0], this.position[1],
            this.vitesse[0], this.vitesse[1]);
    }
}
