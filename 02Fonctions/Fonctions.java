/*
ABSTRACTION
Cacher les détails de comment quelque chose fonctionne derrière une structure plus simple
et facile à manipuler.


FONCTION
Abstraction qui cache un paquet de déclarations derrière un seul nom intuitif.
> On appelle seulement le nom et le programme fera tout ce que le nom cache.


SIGNATURE d'une fonction
------------------------
<type de retour> <nom>(<paramètres>)

Le fonctions peuvent :
* avoir ou ne pas avoir de paramètres. Il faut inclure des parenthèses 
    vides () après le nom s'il n'y a aucun paramètre.
* avoir ou ne pas avoir de valeur de retour. Il faut spécifier le 
    type "void" s'il n'y a aucune valeur de retour.


STRUCTURE d'une fonction
------------------------
signature
{
    corps -> le code à exécuter en appelant la fonction
             (remarquer que le corps est enfermé par une
              paire d'accolades {})
}

*/

public class Fonctions
{
    /** Main est une fonction
     * Il ne retourne rien... En Java, il faut spécifier le type "void" dans ce cas
     * Il a un paramètre de type String[] qui s'appelle args
    */
    public static void main(String[] args) 
    {    
        System.out.println(3);
        /*  La "signature" de println dans ce cas :
            void java.io.PrintStream.println(int x)

            PARAMÈTRE. Le paramètre de la fonction println est int x
            ARGUMENT. Quand on appelle println, on lui a donné la valeur 3. La valeur passée
            quand on appelle une fonction s'appelle l'argument.

            En appelant la fonction, on complète l'assignation de variable suivante :
            int x = 3;
        */

        // appel de la fonction funcNoParameters
        funcNoParameters();

        // appel de la fonction funcOneParams
        funcOneParam(5);

        // appel de la fonction funcTwoParams
        funcTwoParam(13, 21);

        // appel de la fonction funcTwoParamsWithReturn
        int sum = funcTwoParamWithReturn(13, 21);
        funcOneParam(sum); // appel "bonus" de funcOneParam

    }

    /** Notre propre fonction qui ne prend pas de paramètre 
     * 
     * On le définit à l'intérieur de la classe, mais à l'extérieur de main.
     * L'ordre ne dérange pas parce que Java est une langue compilée.
    */
    static void funcNoParameters()
    {
        System.out.println("You called a function with no parameters and no return value.");
    }

    /** Notre propre fonction avec un paramètre */
    static void funcOneParam(int a)
    {
        System.out.println("double your value is: " + 2*a);
    }

    /** Notre propre fonction avec deux paramètres 
     * les paramètres sont séparés par des virgules entre les parenthèses
    */
    static void funcTwoParam(int a, int b)
    {
        int sum = a + b;
        System.out.println("the sum of your values is: " + sum);
    }

    /** Notre propre fonction avec deux paramètres ET une valeur de retour
     * les paramètres sont séparés par des virgules entre les parenthèses
     * 
     * On est limité à UNE SEULE VALEUR DE RETOUR par fonction
    */
    static int funcTwoParamWithReturn(int a, int b)
    {
        return a + b;
    }
}