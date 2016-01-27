package app.model;

/**
 * Created by kocal on 14/12/15.
 */
public class ModelFormulaire extends Model {

    /**
     * La classe Promotion est liée à ce Model
     */
    private Promotion promotion;

    /**
     * Crée un nouvel objet ModelCamembert
     *
     * @param promotion Instance de la classe Promotion
     */
    public ModelFormulaire(Promotion promotion) {
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
}
