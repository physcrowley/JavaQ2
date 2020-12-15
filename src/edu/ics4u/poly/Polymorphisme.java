package edu.ics4u.poly;

/**
 * POLYMORPHISME - un objet peut bénéficier de comportements variés
 * au moment de l'exécution du programme en utilisant intelligement
 * la hierarchie des classes dans laquelle elle se trouve.
 * <p>
 * Il y a deux techniques pour atteindre le polymorphisme :
 * 1- l'HÉRITAGE; 
 * 2- la COMPOSITION.
 * <p>
 * HÉRITAGE - L'héritage en programmation est comme l'héritage chez les 
 * êtres vivants: il y a un arbre généologique avec des parents et des 
 * enfants. Sauf, en programmation Java, chaque classe peut seulement 
 * avoir UN parent, ce qu'on appelle la "classe mère". Les enfants s'appellent 
 * les "classes filles".
 * <p>
 * On dit à Java qu'une classe hérite d'une autre avec le mot-clé `extends`
 * après le nom de la classe dans sa signature. Par exemple :
 * <p>
 * {@code public class Bird extends Animal {}}
 * <p>
 * Les classes filles incluent tous les champs et toutes les méthodes de la
 * classe mère. Les classes filles peuvent s'en servir directement ou 
 * inclure une nouvelle déclaration pour ces méthodes (ce qui s'appelle un
 * Override). La définition dans la classe fille sera toujours utilisée si
 * elle est présente, sinon on ira trouver la définition dans la classe mère.
 * <p>
 * Les classes filles peuvent aussi définir d'autres champs et méthodes qui
 * ne sont pas dans la classe mère, mais c'est généralement déconseillé. On
 * verra pourquoi dans quelques exemples.
 * <p>
 * COMPOSITION - la composition est lorsqu'une classe inclut dans ces champs
 * une INTERFACE qui peut avoir plusieurs implémentations différentes. Une
 * classe qui bénéficie de la composition n'a rien de différent à déclarer
 * dans sa signature. Tout le travail d'ajouter un comportement polymorphique
 * vient dans la déclaration de l'interface et des classes qui l'implémentent.
 * <p>
 * On déclare une INTERFACE avec la signature :
 * <p>
 * {@code public interface MyInterface {}}
 * <p>
 * Le corps d'une interface est simplement une liste de signatures de méthodes
 * vides comme {@code void crier();}. Noter le ";" à la fin de la ligne. Une
 * interface est UN CONTRAT -> toutes les classes qui implémentent une interface
 * DOIVENT écrire un corps pour chaque méthode annoncée dans l'interface. C'est
 * comme ça qu'on atteint des comportements différents en incluant une seule
 * interface dans notre classe : on appelle toujours la même méthode, mais l'action
 * qui se produit dépend de la classe qui a implémenté l'interface.
 * <p>
 * UN RETOUR SUR LE POLYMORPHISME
 * <p>
 * Dans les deux cas - de l'héritage et de la composition - le polymorphisme est
 * évident lors de la déclaration d'un objet. Pour l'héritage, on a une classe
 * mère Animal et des classes filles Bird, Dog, Cat. Dans notre application, on
 * déclare alors nos objets comme ceci :
 * <p>
 * {@code 
 * Bird duck = new Bird();
 * Dog ruff = new Dog();
 * Cat whiskers = new Cat();
 * Animal[] menagerie = {duck, ruff, whiskers}; // polymorphisme: Bird est un Animal, etc.
 * }
 * <p>
 * Pour la composition, dans notre classe Animal, on déclare un champs qui est l'interface
 * FaireUnSon, par exemple:
 * <p>
 * {@code 
 * public class Animal { FaireUnSon monSon; }
 * }
 * <p>
 * Si l'interface FaireUnSon est implémenté dans des classes Sing, Bark, Meow, on peut alors
 * avoir cette déclaration dans les classes filles Bird, Cat et Dog: 
 * <p>
 * {@code
 * public class Bird extends Animal
 * {
 *      Bird()
 *      {
 *          this.monSon = new Sing();
 *      }
 * }
 * public class Cat extends Animal
 * {
 *      Cat()
 *      {
 *          this.monSon = new Meow();
 *      }
 * }
 * public class Dog extends Animal
 * {
 *      Dog()
 *      {
 *          this.monSon = new Bark();
 *      }
 * }
 * }
 */
public class Polymorphisme
{
    public static void main(String[] args) 
    {
        // Voir les classes pour des exemples d'héritage ("extends")
        // et de composition (inclusion d'une interface comme champ)
        Animal unknown = new Animal();
        Bird tweety = new Bird();
        Cat fluffy = new Cat();
        Dog patches = new Dog();

        // polymorphisme via héritage
        //      Bird, Cat et Dog sont aussi de type Animal
        //      car ils sont des classes filles de la classe Animal
        Animal[] menagerie = {unknown, tweety, fluffy, patches};

        // polymorphisme via composition
        //      On n'a pas écrit de code qui change le comportement
        //      de chaque animal. On a simplement déclaré une implémentation
        //      d'interface différente pour son champ "son"
        for (Animal a : menagerie) a.son.monSon();

        /* 
        La composition est super utile, car le comportement n'est pas caché dans
        une classe mais bien accessible à toutes les classes et c'est facile
        d'écrire une nouvelle implémentation de l'interface si on veut ajouter
        des nouveaux comportements.
        */
    }
}