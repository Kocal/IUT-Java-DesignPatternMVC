package app.controller;

/**
 * Created by kocal on 07/12/15.
 */
public class ControllerFormulaire extends Controller {

    /**
     * Retourne un tableau des baccalauréats français
     *
     * @return Tableau de baccalauréats
     */
    public Object[] getBacsList() {
        return new Object[] {"---", "Autre", "ES", "ES", "Etranger", "STI"};
    }

    /**
     * Retourne un tableau des départements français (Corse et DOM-TOM inclus)
     *
     * @return Tableau de départements
     */
    public Object[] getDepartementsList() {
        int i = 0;
        int nbDepartements = 95;
        Object[] departements = new Object[nbDepartements + 1 + 2 + 5];

        departements[i++] = "---";

        for(;i <= nbDepartements; i++) {
            departements[i] = String.format("%02d", i);
        }

        // Les 2 départements de la Corse
        departements[i++] = "2A";
        departements[i++] = "2B";

        // Les 5 départements Outre-mere
        departements[i++] = "971";
        departements[i++] = "972";
        departements[i++] = "973";
        departements[i++] = "974";
        departements[i++] = "976";

        return departements;
    }
}
