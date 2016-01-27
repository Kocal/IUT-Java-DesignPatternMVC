package app.view;

import app.controller.Controller;
import com.sun.org.apache.xpath.internal.SourceTree;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutionException;

/**
 * Created by kocal on 07/12/15.
 */
public class View extends JInternalFrame implements Observer {

    /**
     * Controller lié à la View
     */
    private Controller controller;

    /**
     * Fenêtre principale
     */
    private Fenetre fenetre;

    /**
     * Initialise une View
     *
     * @param fenetre Fenêtre principale
     * @param title Titre de la mini-fenêtre
     */
    public View(Fenetre fenetre, String title) {
        super(title);

        this.setFenetre(fenetre);
    }

    /**
     * Lie un Controller à la View
     *
     * @param controller
     */
    public void setController(Controller controller) {
        System.out.println("View::setController() : " + controller);
        this.controller = controller;
    }

    /**
     * Retourne le Controller lié à la View
     *
     * @return Controller
     */
    public Controller getController() {
        System.out.println("View::getController() : " + this.controller);
        return this.controller;
    }

    /**
     * Permet d'accéder à la fenêtre principale
     *
     * @param fenetre
     */
    private void setFenetre(Fenetre fenetre) {
        this.fenetre = fenetre;
    }

    /**
     * Retourne la fenêtre principale
     *
     * @return Instance de la classe Fenetre
     */
    public Fenetre getFenetre() {
        return this.fenetre;
    }

    /**
     * La classe fille doit surcharger cette méthode
     */
    public void makePanel() {
        throw new UnsupportedOperationException("La méthode makePanel() doit être surchargée");
    }

    /**
     * La classe fille doit surcharger cette méthode
     * @param observable Objet observable
     * @param o aaaaaaaaa^^=)
     */
    @Override
    public void update(Observable observable, Object o)  {
        throw new UnsupportedOperationException("la méthode update() doit êtr surchargée");
    }
}
