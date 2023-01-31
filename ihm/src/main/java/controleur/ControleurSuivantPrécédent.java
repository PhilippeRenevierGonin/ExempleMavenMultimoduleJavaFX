package controleur;

import modele.ModelPourLeControleur;

public class ControleurSuivantPrécédent
{
    public static final String SUIV = "suivante";
    public static final String PREC = "précédente";
    private final ModelPourLeControleur modele;

    public ControleurSuivantPrécédent(ModelPourLeControleur m) {
        this.modele = m;
    }

    public void prevenirLeControleur(String action) {
                if (action.equals(SUIV)) {
                    modele.imageSuivante();
                }
                else  if (action.equals(PREC)) {
                    modele.imagePrécédente();
                }
    }
}
