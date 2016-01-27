package app.controller;

import app.model.Etudiant;
import app.model.ModelListe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by kocal on 07/12/15.
 */
public class ControllerListe extends Controller {

    /**
     * Retourne le Model lié au Controller
     *
     * @return ModelListe
     */
    public ModelListe getModel() {
        return (ModelListe) super.getModel();
    }

    /**
     * Retourne un tableau d'étudiants, trié par leur identifiant
     *
     * @return Tableau d'étudiants
     */
    public Object[] getStudentsList() {
        ArrayList<Etudiant> students = this.getModel().getStudents();

        Collections.sort(students, new Comparator<Etudiant>() {
            @Override
            public int compare(Etudiant etudiant1, Etudiant etudiant2) {
                return Integer.parseInt(etudiant1.getId()) - Integer.parseInt(etudiant2.getId());
            }
        });

        return students.toArray(new Object[students.size()]);
    }
}
