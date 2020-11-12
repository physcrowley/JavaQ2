# Structure de dossiers

## Workspace
C'est ton dossier maître où tu places tous tes projets pour le cours.
Ici le workspace est `JavaQ2`

## Projet
Chaque projet va dans un dossier séparé. Ce projet est dans le dossier `0Structure`.

Lorsque tu travailles sur un projet, tu devrais ouvrir le dossier du projet directement dans VS Code et non le dossier du workspace. Cela place la racine du projet au bon endroit et te sauve d'avoir à spécifier des chemins inutilement à la ligne de commande.


# Composants du langage Java

## Déclarations `;`
Chaque déclaration faite en Java se termine par le point-virgule, `;`. La fin de la ligne est sans importance, contrairement à Python.

## Blocs de code `{}`
Les blocs de code en Java sont entourés par des accolades `{}`. En Python, c'est l'indentation suivant un deux-points (`:`) qui désignait un bloc de code. 
>En Java, l'indentation n'a aucune importance en termes du sens logique du code, mais c'est toujours nécessaire pour rendre le programme lisible et pour simplifier la recherche de l'erreur commune d'accolades oubliés ou mal placés.

## Commentaires de ligne `//` et de bloc `/*  */`
Les commentaires de ligne sont désignés par deux barres obliques `//`. Pour un commentaire qui fait plusieurs lignes, c'est possible d'utiliser un commentaire de bloc qui est entouré par les symboles `/* ... */`.

Ces commentaires sont utilisés pour expliquer la logique du prochain algorithme ou de la prochaine déclaration dans le programme.

## Documentation `/**  */`
On peut créer un commentaire spécial en l'entourant avec les symboles suivants : `/** ... */`. Noter qu'il y a deux astérisques (*) après la première barre oblique. Ce commentaire spécial est de la documentation qui peut être ajoutée par le compilateur à une base de données qui s'appelle le `javadoc`.

Ces commentaires spéciaux sont seulement inclus à trois endroits dans notre code : 
1. Avant la déclaration d'une classe.
2. Avant la déclaration d'une méthode (fonction).
3. Avant la déclaration d'un attribut (explications à venir quand on discute de la programmation orienté objet)

>La documentation sert à décrire le pourquoi de chaque classe, méthode et attribut et l'utilisation recommandée de chacun. 

>Dans un éditeur de code (comme VS Code) ou dans un EDI (comme Eclipse) ces commentaires sont ajoutés automatiquement et en continu au `javadoc` du projet. La documentation est la source de l'information qui apparaît dans les pop-up quand la souris est par-dessus un mot-clé dans ton code. Si tu écris de la documentation pour tes classes et tes méthodes, il y aura des pop-ups pour tes créations aussi!

## Un exemple (avec trop de commentaires)

```java
/* Exemple de structure de base d'un fichier Java
   
   par : David Crowley, crowlda@ecolecatholique.ca

   p.s. toujours créer un en-tête dans un commentaire de bloc comme ça
        au début de chacun de tes fichiers Java
*/


/** La classe principale du programme (contient la méthode main) */
public class App
{
    /** Cette fonction est appelée en premier lors de l'exécution du programme Java.
     *  Tout programme Java doit avoir une méthode main avec exactement cette signature.
     *
     *  @param args les arguments passés à la ligne de commande - pas utilisé ici
     */
    public static void main(String[] args)
    {
        System.out.prinln("Hello world!"); // ; -> la seule instruction passée par le programme
    }
} // {} noter les accolades au début et à la fin de la classe et au début et à la fin de main

```

Noter l'usage des différents types de commentaires :
* **bloc**, `/* ... */` : pour créer un en-tête pour le fichier
* **ligne**, `//` : pour des petits commentaires explicatifs
* **documentation**, `/** ... */` : devant la classe et la méthode