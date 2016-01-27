/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view;

import app.model.Promotion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 *
 * @author p1402118
 */
public class Fenetre extends JFrame {

    /**
     * Conteneur principal
     */
    private JDesktopPane desktop;

    /**
     * La View Camembert
     */
    private ViewCamembert viewCamembert;

    /**
     * La View Formulaire
     */
    private ViewFormulaire viewFormulaire;

    /**
     * La View Histogramme
     */
    private ViewHistogramme viewHistogramme;

    /**
     * La View Liste
     */
    private ViewListe viewListe;

    public Fenetre() {

        this.desktop = new JDesktopPane();

        this.setContentPane(this.desktop);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(new Dimension(1180, 720));
        this.setResizable(true);
        this.setVisible(true);

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                Fenetre.this.refreshBounds();
            }
        });
    }

    public void refreshBounds() {
        // Calculs des dimensions
        int containerWidth = this.getContentPane().getWidth();
        int containerHeight = this.getContentPane().getHeight();

        int formulaireWidth = (int) (containerWidth * .75);
        int formulaireHeight = (int) (containerHeight * .3);

        int camembertWidth = (int) (formulaireWidth * .7);
        int camembertHeight = (int) (containerHeight * .7) + 1;

        int histogrammeWidth = (int) (formulaireWidth * .3) + 1;
        int histogrammeHeight = camembertHeight;

        int listeWidth = containerWidth - formulaireWidth;
        int listeHeight = containerHeight;

        // Définitions des dimensions
        this.viewCamembert  .setBounds(              0, formulaireHeight,   camembertWidth,   camembertHeight);
        this.viewFormulaire .setBounds(              0,                0,  formulaireWidth,  formulaireHeight);
        this.viewHistogramme.setBounds( camembertWidth, formulaireHeight, histogrammeWidth, histogrammeHeight);
        this.viewListe      .setBounds(formulaireWidth,                0,       listeWidth,       listeHeight);
    }

    /**
     * Attache les Views au conteneur principal
     */
    public void attachViews() {
        this.refreshBounds();

        // Par défaut, toutes les Views sont visibles
        this.viewCamembert.setVisible(true);
        this.viewFormulaire.setVisible(true);
        this.viewHistogramme.setVisible(true);
        this.viewListe.setVisible(true);

        // Par défaut, toutes les Views sont resizables
        this.viewCamembert.setResizable(true);
        this.viewFormulaire.setResizable(true);
        this.viewHistogramme.setResizable(true);
        this.viewListe.setResizable(true);

        // On ajoute les Views au conteneur principal
        this.desktop.add(this.viewCamembert);
        this.desktop.add(this.viewFormulaire);
        this.desktop.add(this.viewHistogramme);
        this.desktop.add(this.viewListe);
    }



    /**
     * Ajoute la View Camembert
     *
     * @param viewCamembert
     */
    public void setViewCamembert(ViewCamembert viewCamembert) {
        this.viewCamembert = viewCamembert;
        this.viewCamembert.makePanel();
    }

    /**
     * Ajoute la View Formulaire
     *
     * @param viewFormulaire
     */
    public void setViewFormulaire(ViewFormulaire viewFormulaire) {
        this.viewFormulaire = viewFormulaire;
        this.viewFormulaire.makePanel();
    }

    /**
     * Ajoute la View Histogramme
     *
     * @param viewHistogramme
     */
    public void setViewHistogramme(ViewHistogramme viewHistogramme) {
        this.viewHistogramme = viewHistogramme;
        this.viewHistogramme.makePanel();
    }

    /**
     * Ajoute la View Liste
     *
     * @param viewListe
     */
    public void setViewListe(ViewListe viewListe) {
        this.viewListe = viewListe;
        this.viewListe.makePanel();
    }
}