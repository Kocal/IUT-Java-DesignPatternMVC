/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.panel;

import app.controller.ControllerListe;
import app.listener.ListenerDeleteStudent;
import app.model.Etudiant;
import app.model.ModelListe;
import app.model.Promotion;
import app.view.ViewListe;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author p1402118
 */
public class PanelListe extends JPanel {

    /**
     * Controller lié à la View contenant ce panel
     */
    private ControllerListe controller;

    /**
     * View contenant ce panel
     */
    private ViewListe view;

    /**
     * Liste contenant les étudiants
     */
    JList list;

    /**
     * Conteneur affichant la liste des étudiants
     */
    JScrollPane scrollPane;

    /**
     * Bouton pour supprimer un élève
     */
    JButton buttonRemove;

    /**
     * Initialise la classe PanelView en lui associant une View
     *
     * @param view View à associer
     */
    public PanelListe(ViewListe view) {
        super(null);

        this.view = view;
        this.controller = (ControllerListe) view.getController();

        this.makePanel();
    }

    /**
     * Création du bouton "Supprimer Eleve"
     */
    private void makeDeleteButton() {
        this.buttonRemove = new JButton("Supprimer");
        this.buttonRemove.setHorizontalAlignment(SwingConstants.CENTER);
        this.buttonRemove.setVerticalAlignment(SwingConstants.CENTER);

        this.buttonRemove.addActionListener(new ListenerDeleteStudent() {
            @Override
            public String getStudentId() {
                Etudiant student = (Etudiant) PanelListe.this.list.getSelectedValue();
                return student.getId();
            }

            @Override
            public Promotion getPromotion() {
                ModelListe model = (ModelListe) PanelListe.this.controller.getModel();
                return model.getPromotion();
            }
        });
    }

    /**
     * Création de la liste contenant les élèves
     */
    private void makeListe() {
        this.list = new JList();
        this.list.setLayoutOrientation(JList.VERTICAL);
        this.list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.list.setVisibleRowCount(-1);
    }

    /**
     * Met à jour la liste contenant les élèves
     */
    public void updateListe() {
        this.list.setListData(this.controller.getStudentsList());
    }

    /**
     * Création du panneau scrollable contenant la liste des élèves
     */
    private void makeScrollPane() {
        this.scrollPane = new JScrollPane(this.list);
        this.scrollPane.setSize(this.getSize());
    }

    /**
     * Création du Panel contenant le panneau scrollable et le bouton supprimer
     */
    public void makePanel() {
        this.setLayout(new BorderLayout());

        this.makeListe();
        this.makeScrollPane();
        this.makeDeleteButton();

        this.add(this.scrollPane, BorderLayout.CENTER);
        this.add(this.buttonRemove, BorderLayout.SOUTH);
    }

    /**
     * Est appelée pendant la mise-à-jour de la View
     */
    public void update() {
        this.updateListe();
    }
}