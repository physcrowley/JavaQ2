import java.util.Arrays;
/**
 * Exemples avec les tableaux
 */
public class Tableaux 
{
    public static void main(String[] args) 
    {
        String abc = "abcdefghijklmnopqrstuvwxyz";
    // Longueur d'un String : .length() <-- une méthode
    // Indexe d'un charactère dans un String: .indexOf("texte")
    // Caractère à un indexe : .charAt(index)
    int lenAbc = abc.length();
    int i = abc.indexOf("c");
    char c = abc.charAt(abc.length() - 2);


    char[] lettres = abc.toCharArray();
    // lettres est un tableau ("array")
    // Longueur du tableau : .length <-- un attribut
    // indexe d'un caractère : recherche avec une boucle
    // caractère à un indexe : [index]
    int len_lettres = lettres.length;
    for (int j = 0; j < len_lettres; j++)
    {
        if (lettres[j] =='g') {int i_g = j;}
    }

    double[] notes = new double[6];
    notes[0] = 72.3;
    notes[1] = 61.0;
    //.
    //.
    //.
    notes[notes.length - 1] = 100.0;
    }
}
