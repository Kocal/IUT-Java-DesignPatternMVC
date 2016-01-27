package app.model;

import app.controller.Controller;

import java.util.Observable;

/**
 * Created by kocal on 07/12/15.
 */
public class Model extends Observable {

    /**
     * Controller lié au Model
     */
    private Controller controller;

    /**
     * Lie un Controller au Model
     *
     * @param controller Controller à lier
     */
    public void setController(Controller controller) {
        this.controller = controller;
    }

    /**
     * Retourne le Controller lié au Model
     *
     * @return Controller
     */
    public Controller getController() {
        return this.controller;
    }
}
