# Les types de données
Dans Java, chaque variable peut avoir un seul type durant toute la vie du programme. On doit déclarer explicitement le type de chaque variable dans nos programmes. Java est donc un langage de programmation avec des **types statiques**.

Le format pour cette déclaration de variable est la suivante :

```java
<type> <nom> = <valeur>;
```

Où :
* `<type>` est le type de donnée (comme `String`, `int`, `double`), 
* `<nom>` est le nom de la variable et 
* `<valeur>` est une valeur du type approprié.

Voici trois exemples :

```java
String uneChaineDeTexte = "Une chaîne de texte";
int unNombreEntier = 42;
double unNombreDecimal = 3.1415;
```

>Noter que les `String` doivent être déclarés entre guillemets (`" "`). 
>
>En Python, les apostrophes (`' '`) pouvaient aussi être utilisés, mais les apostrophes sont réservés pour autre chose en Java.

## Utilisations recommandées pour chaque type

Type | Usage
---|---
`String`| général : noms, valeurs saisies à la console
`int`| nombre pour compter ou indexer
`double`| nombre pour calculer des valeurs
`boolean`| comme drapeau pour signaler quand quelque chose est `true` ou `false`

>Il y a plusieurs autres types dans Java, mais ceux-ci sont les plus couramment utilisés.

## Conversions de texte vers un autre type


## Casting entre types numériques


# La sortie standard (à la console)
La console à utiliser **pour afficher du texte** est définie par par Java dans l'objet `System.out`. Généralement, `System.out` réfère à la même console utilisée pour lancer la commande `java`. Cette console s'appelle **la sortie standard**.

Il y a quelques méthodes possibles pour utiliser la sortie standard.