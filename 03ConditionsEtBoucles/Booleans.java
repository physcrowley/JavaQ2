/**
 * Exemples de booléens et de l'opération ternaire pour simplifier nos
 * conditions
 */
public class Booleans {
    public static void main(String[] args) {
        /*
            Un booléen peut seulement avoir 2 valeurs : true ou false

            UTILITÉ : indicateur / drapeau -> signaler un état

            NOMS : commencent généralement avec "est" ou "is"
        */

        boolean isOn = false;

        // code qui duplique le comportement d'un bouton (un "toggle swithch")
        if (isOn) // isOn doit être true
        {
            isOn = false;
            System.out.println("Off");
        }
        else // isOn est false
        {
            isOn = true;
            System.out.println("On");
        }

        isOn = toggle(isOn);
        System.out.println(isOn);
        isOn = toggle(isOn);
        System.out.println(isOn);


        /*
            Opération ternaire -> façon court de remplacer un if-else

            Exigence -> le résultat doit être assigné à une variable où utiliser par le
            programme directement

            STRUCTURE
            <expression conditionnelle > ? <valeur si vrai> : <valeur si faux>

            IMPLÉMENTATION -> les chiffriers comme Excel et Sheets
            =if(<expression conditionnelle>; <valeur si vrai>; <valeur si faux>)
        */

        String lightStatus = isOn ? "On" : "Off";
        System.out.println(lightStatus);
        isOn = toggle(isOn);
        System.out.println(isOn ? "On" : "Off");

        int a = 20;
        int b = 15;
        int biggest = a >= b ? a : b;
        System.out.printf("Nombres : %d, %d -> le plus grand : %d %d\n", a, b, biggest);
        /* printf te permet d'insérer des valeurs dans un String

           Utiliser :
            %d pour un int (et les autres comme long, byte)
            %f pour un double (ou un float)
            %s pour un String
            %b pour un boolean
            \n pour un retour de ligne
            \t pour une tabulation
        */
    }

    /** Méthode simple pour inverser la valeur d'un booléen, true <--> false */
    static boolean toggle(boolean b)
    {
        return !b;
    }
    
}
