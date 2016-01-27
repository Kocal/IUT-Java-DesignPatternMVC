/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view;

import app.controller.ControllerListe;
import app.view.panel.PanelListe;

import java.util.Observable;

/**
 *
 * @author p1402118
 */
public class ViewListe extends View {

    /**
     * Panel lié à la View
     */
    private PanelListe panel;

    public ViewListe(Fenetre fenetre, String title) {
        super(fenetre, title);
    }

    @Override
    public void makePanel() {
        this.panel = new PanelListe(this);
        this.setContentPane(this.panel);
        this.panel.update();
    }

    @Override
    public void update(Observable observable, Object o) {
        this.panel.update();
    }
}