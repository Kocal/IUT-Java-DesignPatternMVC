/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.panel;

import app.controller.ControllerFormulaire;
import app.listener.ListenerAddStudent;
import app.listener.ListenerDeleteStudent;
import app.model.Model;
import app.model.ModelFormulaire;
import app.model.Promotion;
import app.view.ViewFormulaire;
import layout.TableLayout;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author p1402118
 */
public class PanelFormulaire extends JPanel {

    /**
     * Controller lié à la View contenant ce panel
     */
    private ControllerFormulaire controller;

    /**
     * View contenant ce panel
     */
    private ViewFormulaire view;

    private JPanel panelAddStudent;

    private JPanel panelRemoveStudent;

    private JTextField inputNumeroAdd;

    private JTextField inputNumeroDel;

    private JTextField inputPrenom;

    private JTextField inputNom;

    private JComboBox inputBac;

    private JComboBox inputDepartement;

    private JButton buttonAdd;

    private JButton buttonRemove;

    /**
     * Initialise la classe PanelFormulaire en lui associant une View
     *
     * @param view
     */
    public PanelFormulaire(ViewFormulaire view) {
        super(null);

        this.view = view;
        this.controller = (ControllerFormulaire) this.view.getController();

        this.makePanel();
    }

    /**
     * Création du panel permettant l'ajout d'un étudiant
     */
    public void makeAddStudentPanel() {
        double border = 10;
        double size[][] = {
            { border, TableLayout.FILL, 130, border + 20}, // colonnes
            { // Lignes
                border,
                TableLayout.FILL,
                TableLayout.FILL,
                TableLayout.FILL,
                TableLayout.FILL,
                TableLayout.FILL,
                TableLayout.FILL,
                TableLayout.FILL,
                border
            }
        };

        this.panelAddStudent = new JPanel(new TableLayout(size));

        // Label "Ajout d'un étudiant"
        JLabel label = new JLabel("Ajout d'un étudiant");
        label.setFont(new Font(label.getFont().getName(), Font.PLAIN, 20));
        this.panelAddStudent.add(label, "1, 1, 2, 1");

        // Label "Numéro :"
        label = new JLabel("Numéro : ");
        this.panelAddStudent.add(label, "1, 2");

        // Input "Numéro"
        this.inputNumeroAdd = new JTextField();
        this.panelAddStudent.add(this.inputNumeroAdd, "2, 2");

        // Label "Prénom :"
        label = new JLabel("Prénom : ");
        this.panelAddStudent.add(label, "1, 3");

        // Input "Prénom"
        this.inputPrenom = new JTextField();
        this.panelAddStudent.add(this.inputPrenom, "2, 3");

        // Label "Nom :"
        label = new JLabel("Nom : ");
        this.panelAddStudent.add(label, "1, 4");

        // Input "Nom"
        this.inputNom = new JTextField();
        this.panelAddStudent.add(this.inputNom, "2, 4");

        // Label "Bac :"
        label = new JLabel("Bac :");
        this.panelAddStudent.add(label, "1, 5");

        // Input "Bac"
        this.inputBac = new JComboBox(this.controller.getBacsList());
        this.panelAddStudent.add(this.inputBac, "2, 5");

        // Label "Département : "
        label = new JLabel("Département : ");
        this.panelAddStudent.add(label, "1, 6");

        // Input "Département"
        this.inputDepartement = new JComboBox(this.controller.getDepartementsList());
        this.panelAddStudent.add(this.inputDepartement, "2, 6");

        // Bouton "Ajout"
        this.buttonAdd = new JButton("Ajouter");
        this.buttonAdd.addActionListener(new ListenerAddStudent() {

            @Override
            public String getStudentId() {
                return PanelFormulaire.this.inputNumeroAdd.getText();
            }

            @Override
            public String getStudentFirstName() {
                return PanelFormulaire.this.inputPrenom.getText();
            }

            @Override
            public String getStudentLastName() {
                return PanelFormulaire.this.inputNom.getText();
            }

            @Override
            public String getStudentBac() {
                return (String) PanelFormulaire.this.inputBac.getSelectedItem();
            }

            @Override
            public String getStudentDepartement() {
                return (String) PanelFormulaire.this.inputDepartement.getSelectedItem();
            }

            @Override
            public Promotion getPromotion() {
                ModelFormulaire model = (ModelFormulaire) PanelFormulaire.this.controller.getModel();
                return model.getPromotion();
            }
        });
        this.panelAddStudent.add(this.buttonAdd, "1, 7, 2, 7");
    }

    /**
     * Création du panel permettant la suppression d'un étudiant
     */
    public void makeRemoveStudentPanel() {
        double border = 10;
        double size[][] = {
            { 20 + border, 90, 130, 0, border} , // colonnes
            { // Lignes
                border,
                TableLayout.MINIMUM,
                TableLayout.MINIMUM,
                TableLayout.MINIMUM,
                border
            }
        };

        this.panelRemoveStudent = new JPanel(new TableLayout(size));

        // Label "Suppresion d'un étudiant :"
        JLabel label = new JLabel("Suppression étudiant");
        label.setFont(new Font(label.getFont().getName(), Font.PLAIN, 20));
        this.panelRemoveStudent.add(label, "1, 1, 3, 1");

        // Label "Numéro : "
        label = new JLabel("Numéro : ");
        this.panelRemoveStudent.add(label, "1, 2");

        // Input "Numéro"
        this.inputNumeroDel = new JTextField();
        this.panelRemoveStudent.add(this.inputNumeroDel, "2, 2");

        // Bouton "Supprimer"
        this.buttonRemove = new JButton("Supprimer");
        this.buttonRemove.addActionListener(new ListenerDeleteStudent() {
            @Override
            public String getStudentId() {
                return PanelFormulaire.this.inputNumeroDel.getText();
            }

            @Override
            public Promotion getPromotion() {
                ModelFormulaire model = (ModelFormulaire) PanelFormulaire.this.controller.getModel();
                return model.getPromotion();
            }
        });
        this.panelRemoveStudent.add(this.buttonRemove, "1, 3, 3, 3");
    }

    /**
     * Création du panel principal
     */
    public void makePanel() {
        this.setLayout(new BorderLayout());

        this.makeAddStudentPanel();
        this.makeRemoveStudentPanel();

        this.add(this.panelAddStudent, BorderLayout.WEST);
        this.add(this.panelRemoveStudent, BorderLayout.CENTER);
    }

    public void update() {
        // Rien
    }
}