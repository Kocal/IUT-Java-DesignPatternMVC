package app.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kocal on 07/12/15.
 */
public class ModelCamembert extends Model {

    /**
     * La classe Promotion est liée à ce Model
     */
    private Promotion promotion;

    /**
     * Crée un nouvel objet ModelCamembert
     *
     * @param promotion Instance de la classe Promotion
     */
    public ModelCamembert(Promotion promotion) {
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
     * Retourne le nombre d'étudiants par départements
     *
     * @return Map sous le format &lt;Numéro département, Nombre d'étudiants&gt;
     */
    public Map<String, Integer> getStudentsPerDepartements() {
        Map<String, Integer> map = new HashMap<String, Integer>();

        for(Etudiant student: this.promotion.getListeEtudiants()) {
            if(map.get(student.getDpt()) == null) {
                map.put(student.getDpt(), 0);
            }

            map.put(student.getDpt(), map.get(student.getDpt()) + 1);
        }

        return map;
    }
}
