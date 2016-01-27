/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view;

import app.controller.ControllerCamembert;
import app.view.panel.PanelCamembert;

import java.util.Observable;

/**
 *
 * @author p1402118
 */
public class ViewCamembert extends View {

    /**
     * Panel lié à la View
     */
    private PanelCamembert panel;

    public ViewCamembert(Fenetre fenetre, String title) {
        super(fenetre, title);
    }

    @Override
    public void makePanel() {
        this.panel = new PanelCamembert(this);
        this.setContentPane(this.panel);
        this.panel.update();
    }

    @Override
    public void update(Observable observable, Object o) {
        this.panel.update();
    }
}