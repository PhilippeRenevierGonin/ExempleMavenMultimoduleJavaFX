package ihm;

import controleur.ControleurSuivantPrécédent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import modele.ModeleImages;

public class FenetrePrincipale extends Application {


    ModeleImages modele = new ModeleImages();
    ControleurSuivantPrécédent ctrl;

    VueImages vue ;



	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("exemple resources et javafx");
		primaryStage.setWidth(400);
		primaryStage.setHeight(200);

        ctrl = new ControleurSuivantPrécédent(modele);
        vue = new VueImages(modele, ctrl);

        Scene primaryScene = vue.getScene();
        primaryStage.setScene(primaryScene);
		// le conteneur principal

        primaryStage.show();
	}



    public static void lancement(String[] args) {
		FenetrePrincipale.launch(args);
		
	}


}
