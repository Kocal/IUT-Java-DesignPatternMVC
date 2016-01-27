package app.listener;

import app.model.Etudiant;
import app.model.Promotion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by kocal on 14/12/15.
 */
public class ListenerDeleteStudent implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String studentId = this.getStudentId();
        Promotion promotion = (Promotion) this.getPromotion();
        Etudiant student;

        if(studentId.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Le numéro de l'étudiant ne doit pas être vide");
        } else {
            student = promotion.searchEtudiant(studentId);

            if(student == null) {
                JOptionPane.showMessageDialog(null, "Aucun étudiant n'a été trouvé");
            } else {
                // On peut supprimer l'étudiant
                promotion.removeEtudiant(student);
                JOptionPane.showMessageDialog(null, "La suppression de l'étudiant n°" + student.getId() + " s'est effectuée avec succès");
            }
        }
    }

    /**
     * Retourne l'identifiant de 'étudiant à supprimer
     *
     * @return Identifiant de l'étudiant
     */
    public String getStudentId() {
        throw new UnsupportedOperationException("La méthode getStudentId() doit être implémentée dans la classe fille");
    }

    /**
     * Retourne le prénom de l'étudiant à ajouter
     *
     * @return Prénom de l'étudiant
     */
    public Promotion getPromotion() {
        throw new UnsupportedOperationException("La méthode getPromotionModel() doit être implémentée dans la classe fille");
    }
}
