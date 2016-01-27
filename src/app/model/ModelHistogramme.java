package app.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kocal on 07/12/15.
 */
public class ModelHistogramme extends Model {

    /**
     * La classe Promotion est liée à ce Model
     */
    private Promotion promotion;

    /**
     * Crée un nouvel objet ModelHistogramme
     *
     * @param promotion Instance de la classe Promotion
     */
    public ModelHistogramme(Promotion promotion) {
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
     * Retourne le nombre d'étudiants par série de Bac
     *
     * @return Map sous le format &lt;Série de Bac, Nombre d'étudiants&gt;
     */
    public Map<String, Integer> getStudentsPerBac() {
        Map<String, Integer> map = new HashMap<String, Integer>();

        for(Etudiant student: this.promotion.getListeEtudiants()) {
            if(map.get(student.getSerieBac()) == null) {
                map.put(student.getSerieBac(), 0);
            }

            map.put(student.getSerieBac(), map.get(student.getSerieBac()) + 1);
        }

        return map;
    }
}
