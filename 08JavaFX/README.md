# Travailler avec JavaFX

JavaFX est un framework qui gère les interfaces de fenêtre en Java pour les applications de bureau et Web. Chaque programme JavaFX aura les composants suivants:

* un ** graphe scénique ** listant tous les éléments de la fenêtre de manière hiérarchique (avec relations parent-enfant)
* ** contrôles ** qui réagissent aux interactions des utilisateurs
* comme tous les autres programmes Java, un ** point d'entrée ** pour l'application. En Java, c'est la méthode `main ()`. En JavaFX, c'est la classe qui contient la méthode `main ()`. Cette classe `étend` une classe JavaFX` Application` et a une structure prédéfinie.

Pour les programmes JavaFX simples, le graphe de scène est défini dans la classe d'application.

Pour les programmes JavaFX plus volumineux ou qui utilisent plusieurs scènes ou fenêtres, le graphe de la scène est défini dans un fichier spécial avec l'extension `.fxml`. Le fichier `fmxl` est similaire aux fichiers` html` qui structurent les sites Web: ils utilisent tous les deux des balises imbriquées. De même, les styles peuvent être définis dans le fichier `fxml` directement ou avec un fichier` css`, tout comme `html`. Au lieu d'être * défini * dans la classe d'application, le graphe de scène est * chargé * à partir du fichier `fxml` par une fonction de chargeur spéciale dans la classe d'application.

Maven a des archétypes de projet pour les projets JavaFX * simple * et * fxml *. Dans la fenêtre Archétype de l'assistant de projet Maven dans Eclipse, commencez à taper "openjfx" dans la barre de recherche. Choisissez `javafx-archetype-simple` pour un projet de base ou` javafx-archetype-fxml` pour un projet basé sur fxml.

## e (fx) clipse et Scene Builder

L'extension ** e (fx) clipse ** Eclipse vous donnera accès à des outils particulièrement utiles pour gérer les fichiers `fxml`.

> Il est également livré avec un modèle de projet JavaFX que vous pouvez utiliser au lieu d'utiliser les archétypes Maven. <p>
> ATTENTION: il est beaucoup plus difficile de partager ce type de projet car chaque développeur a besoin de gérer lui-même les modules JavaFX, ce qui entraîne inévitablement des problèmes lors du push et du pull depuis GitHub si les configurations de projet sur chaque machine ne sont pas identiques.

L'application ** Scene Builder ** est un moyen d'écrire des fichiers `fxml` avec un éditeur visuel, en faisant glisser et déposer des éléments sur la scène et en éditant leurs propriétés dans des zones de texte. Le travail effectué visuellement dans Scene Builder est automatiquement traduit dans la syntaxe `fxml` qui vous convient. Alternativement, les fichiers `fxml` doivent être écrits comme tout autre code: des lignes de texte suivant la syntaxe spéciale.

Consultez les didacticiels vidéo suivants pour l'installation:

* [e (fx) clipse] (https://www.loom.com/share/7c38e86ac597464e82d354a35cefdd2d)
* [Générateur de scènes] (https://www.loom.com/share/057266251dc342249132d29f523d0f6b)
