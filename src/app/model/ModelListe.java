package app.model;

import java.util.ArrayList;

/**
 * Created by kocal on 07/12/15.
 */
public class ModelListe extends Model {

    /**
     * La classe Promotion est liée à ce Model
     */
    private Promotion promotion;

    /**
     * Crée un nouvel objet ModelHistogramme
     *
     * @param promotion Instance de la classe Promotion
     */
    public ModelListe(Promotion promotion) {
        this.promotion = promotion;
    }

    /**
     * Retourne une instance de la classe Promotion
     *
     * @return Instance de la classe Promotion
     */
    public Promotion getPromotion() {
        return this.promotion;
    }

    /**
     * Retourne la liste des étudiants
     *
     * @return ArrayList des étudiants
     */
    public ArrayList<Etudiant> getStudents() {
        return this.promotion.getListeEtudiants();
    }
}
