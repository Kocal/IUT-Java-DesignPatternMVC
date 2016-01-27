package app.listener;

import app.model.Etudiant;
import app.model.Promotion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by kocal on 14/12/15.
 */
public class ListenerAddStudent implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        boolean errors = false;

        String studentId = this.getStudentId();
        String studentFirstName = this.getStudentFirstName();
        String studentLastName = this.getStudentLastName();
        String studentBac = this.getStudentBac();
        String studentDepartement = this.getStudentDepartement();

        Promotion promotion = (Promotion) this.getPromotion();

        System.out.println(studentId + " ; " + studentFirstName + " ; " + studentLastName + " ; " + studentBac + " ; " + studentDepartement);

        // Traitement sur l'identifiant de l'étudiant
        if(studentId.isEmpty()) {
            JOptionPane.showMessageDialog(null, "L'identifiant de l'étudiant ne peut être vide");
            errors = true;
        } else {
            try {
                Integer.parseInt(studentId);
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "L'identifiant doit être un entier");
                errors = true;
            }
        }

        // Traitement sur le prénom de l'étudiant
        if(studentFirstName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Le prénom de l'étudiant ne peut être vide");
            errors = true;
        }

        // Traitement sur le nom de l'étudiant
        if(studentLastName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Le nom de l'étudiant ne peut être vide");
            errors = true;
        }

        // Traitement sur le bac de l'étudiant
        if(studentBac.equals("---")) {
            JOptionPane.showMessageDialog(null, "L'étudiant a du faire un bac avant d'arriver ici");
            errors = true;
        }

        // Traitement sur le département de l'étudiant
        if(studentDepartement.equals("---")) {
            JOptionPane.showMessageDialog(null, "L'étudiant doit habiter dans un département");
            errors = true;
        }

        // On peut ajouter l'étudiant !
        if(!errors) {
            // Enfin, sauf si l'id est déjà prit
            if(promotion.searchEtudiant(studentId) != null) {
                JOptionPane.showMessageDialog(null, "L'identifiant est déjà affecté à un étudiant !");
            } else {
                promotion.addEtudiant(
                        new Etudiant(studentId, studentLastName, studentFirstName, studentBac, studentDepartement)
                );
            }
        }
    }

    /**
     * Retourne l'identifiant de l'étudiant à ajouter
     *
     * @return Identifiant de l'étudiant
     */
    public String getStudentId() {
        throw new UnsupportedOperationException("La méthode getStudentId() doit être surchargée");
    }

    /**
     * Retourne le prénom de l'étudiant à ajouter
     *
     * @return Prénom de l'étudiant
     */
    public String getStudentFirstName() {
        throw new UnsupportedOperationException("La méthode getStudentFirstName() doit être surchargée");
    }

    /**
     * Retourne le nom de l'étudiant à ajouter
     *
     * @return Nom de l'étudiant
     */
    public String getStudentLastName() {
        throw new UnsupportedOperationException("La méthode getStudentLastName() doit être surchargée");
    }

    /**
     * Retourne le baccalauréat de l'étudiant à ajouter
     *
     * @return Baccalauréat de l'étudiant
     */
    public String getStudentBac() {
        throw new UnsupportedOperationException("La méthode getStudentBac() doit être surchargée");
    }

    /**
     * Retourne le département de l'étudiant à ajouter
     *
     * @return Département de l'étudiant
     */
    public String getStudentDepartement() {
        throw new UnsupportedOperationException("La méthode getStudentDepartement() doit être surchargée");
    }

    /**
     * Retourne une instance de la classe Promotion
     *
     * @return Instance de la classe Promotion
     */
    public Promotion getPromotion() {
        throw new UnsupportedOperationException("La méthode getPromotionModel() doit être implémentée dans la classe fille");
    }
}
