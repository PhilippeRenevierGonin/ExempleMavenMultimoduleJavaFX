package ihm;

import controleur.ControleurSuivantPrécédent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import modele.ModelePourLaVue;

public class VueImages implements Vue{

    ModelePourLaVue modele;
    ControleurSuivantPrécédent ctrl;
    ImageView imageView;

    public VueImages(ModelePourLaVue modele, ControleurSuivantPrécédent ctrl) {
        this.modele = modele;
        this.ctrl = ctrl;
    }



	public Scene getScene() {
		// le conteneur principal
        BorderPane primaryPane = new BorderPane();
        Scene primaryScene = new Scene(primaryPane);

        // le haut de la fenêtre
        HBox entete = new HBox();
        Label titre = new Label("exemple resources et javafx");
        titre.setFont(Font.font("Courier New", FontWeight.BOLD, 28));
        entete.setAlignment(Pos.CENTER);
        entete.getChildren().add(titre);
        entete.setBackground(new Background(new BackgroundFill(Color.BEIGE, CornerRadii.EMPTY,null)));

        primaryPane.setTop(entete);
        

        
        
        // le bas de la fenêtre
        Button quitter = new Button("quitter");
        HBox piedDePage = new HBox();
        piedDePage.getChildren().add(quitter);
        piedDePage.setAlignment(Pos.CENTER_RIGHT);
        piedDePage.setBackground(new Background(new BackgroundFill(Color.BEIGE, CornerRadii.EMPTY,null)));
        BorderStroke borderStrokePiedDePage = new BorderStroke(null,BorderStrokeStyle.NONE,new CornerRadii(0),new BorderWidths(0),new Insets(10));
		Border borderPiedDePage = new Border(borderStrokePiedDePage );
		piedDePage.setBorder(borderPiedDePage );
		
		
		quitter.setOnAction(event -> {
			Platform.exit();
		});

        primaryPane.setBottom(piedDePage);
        
        
        // zone de gauche
        Button prec = new Button(ControleurSuivantPrécédent.PREC);
        prec.setOnAction((e) -> {
            ctrl.prevenirLeControleur(ControleurSuivantPrécédent.PREC);
        });
        primaryPane.setLeft(prec);


        // zone de gauche
        Button suiv = new Button(ControleurSuivantPrécédent.SUIV);
        suiv.setOnAction((e) -> {
            ctrl.prevenirLeControleur(ControleurSuivantPrécédent.SUIV);
        });
        primaryPane.setRight(suiv);


        imageView = new ImageView();
        primaryPane.setCenter(imageView);

        modele.addVue(this);

        return primaryScene;
	}


    @Override
    public void miseAJour(Image image) {
        imageView.setImage(image);
    }
}
