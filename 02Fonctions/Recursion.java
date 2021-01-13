import java.util.Scanner;

/** La récursivité est quand une fonction s'appelle elle-même */
public class Recursion 
{
    public static void main(String[] args) 
    {
        Scanner stdin = new Scanner(System.in);
        
        //System.out.println("3 is even? " + isEven(3));
        //System.out.println("4 is even? " + isEven(4));
        //System.out.println("1 is even? " + isEven(1));
        //System.out.println("2 is even? " + isEven(2));
        //System.out.println("1000757 is even? " + isEven(757));

        //System.out.println("3 is odd? " + isOdd(3));

        int n = getNum(stdin);
        System.out.println(n + " is even? " + isEven(n));

        stdin.close();
    }

    /** Détermine si un entier est pair */
    public static boolean isEven(int a)
    {
        if (a >= 2) {return isEven(a - 2);}
        if (a == 0) {return true;}
        return false;
    }

    public static boolean isOdd(int a)
    {
        return isEven(a+1);
    }


    /** utiliser la récursivité pour gérer les erreurs */
    static int getNum(Scanner input)
    {
        System.out.println("Entrer un nombre entier");

        if (input.hasNextInt())
        {
            String s = input.nextLine();
            return Integer.parseInt(s);
        }
        else
        {
            // communiquer avec l'utilisateur
            System.out.println("ce n'est pas un nombre entier");
            // consommer la ligne qui contient la valeur erronée
            input.nextLine(); 
            // essayer encore, récursivement
            return getNum(input);
        }
    }

}
