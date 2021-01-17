package edu.ics4u.boutons;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App pour montrer comment utiliser les contrôles avec les expressions lambda
 */
public class App extends Application {

    @Override
    public void start(Stage stage) 
    {

        // ------CONTRÔLES-------
        var label = new Label("Voici un exemple avec un champ de texte et un bouton.");
        var text = new TextField(); // un contrôle
        var button = new Button(); // un autre contrôle
        // TODO écrire des étiquettes pour nos contrôles
        // TODO écrire l'action pour le bouton
        
        // ----------MISE EN PAGE------
        var hbox = new HBox(text, button); 
            // ou: var hbox = new HBox(); hbox.getChildren().addAll(text, button);
        var root = new VBox(label, hbox); 
            // ou: var root = new VBox(); root.getChildren().addAll(label, hbox);

        // ----------MISE EN SCÈNE---------
        var scene = new Scene(root, 600, 200); 
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) 
    {
        launch();
    }

}