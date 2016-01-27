package app;

import app.controller.ControllerCamembert;
import app.controller.ControllerFormulaire;
import app.controller.ControllerHistogramme;
import app.controller.ControllerListe;
import app.model.*;
import app.view.*;

public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Promotion promotion = new Promotion();
        Fenetre fenetre = new Fenetre();

        promotion.loadFileCSV();

        if(promotion.getListeEtudiants().isEmpty()) {
            System.out.println("Fin du programme.");
            System.exit(1);
        }

        // Initialisation des controllers
        ControllerCamembert controllerCamembert     = new ControllerCamembert();
        ControllerFormulaire controllerFormulaire   = new ControllerFormulaire();
        ControllerHistogramme controllerHistogramme = new ControllerHistogramme();
        ControllerListe controllerListe             = new ControllerListe();

        // Initialisation des models
        controllerCamembert  .setModel(new ModelCamembert(promotion));
        controllerFormulaire .setModel(new ModelFormulaire(promotion));
        controllerHistogramme.setModel(new ModelHistogramme(promotion));
        controllerListe      .setModel(new ModelListe(promotion));

        // Initialisation des vues
        controllerCamembert  .setView(new ViewCamembert(fenetre, "Titre"));
        controllerFormulaire .setView(new ViewFormulaire(fenetre, "Saisie d'étudiants"));
        controllerHistogramme.setView(new ViewHistogramme(fenetre, "Bacs d'origine"));
        controllerListe      .setView(new ViewListe(fenetre, "Liste des étudiants"));

        // Ajout des observers
        promotion.addObserver(controllerCamembert  .getView());
        promotion.addObserver(controllerFormulaire .getView());
        promotion.addObserver(controllerHistogramme.getView());
        promotion.addObserver(controllerListe      .getView());


        // Ajout des views à la fenêtre
        fenetre.setViewCamembert((ViewCamembert) controllerCamembert.getView());
        fenetre.setViewFormulaire((ViewFormulaire) controllerFormulaire.getView());
        fenetre.setViewHistogramme((ViewHistogramme) controllerHistogramme.getView());
        fenetre.setViewListe((ViewListe) controllerListe.getView());

        fenetre.attachViews();
    }
}