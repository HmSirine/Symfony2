
package tests;

import models.*;

import services.*;


/**
 *
 * @author hp
 */
public class MainProg {

    public static void main(String[] args) {
        CrudUtilisateur cu = new CrudUtilisateur();
//
//        Utilisateur admin = new Utilisateur("travolta", "voyage", "travolta.voyage@gmail.com", "sirine123/", "ROLE_ADMIN");
//        cu.modifierRole(admin, "ROLE_ADMIN");
        //cu.Ajouter(admin);
        // cu2.ajouter(new Utilisateur("Sirine", "Hammami", "sirine@gmail.com","hdhhd"));
        cu.modifier(new Utilisateur(58, "travolta", "voyage", "travolta.voyage@gmail.com", "sirine123/", "ROLE_ADMIN"));
        //cu1.supprimer(new Utilisateur(1));
        //  System.out.println(cu2.afficher());
        //  ServicePersonne2 sp2 = new ServicePersonne2();
        //  sp2.ajouter(new Personne("Jasser", "Wissem"));

        CrudReclamation cr = new CrudReclamation();
        //cr.Ajouter(new Reclamation(123, "reservation", "pourquoi ma reseravation est annuler"));
        //  cr.modifier(new Reclamation(123, "reservation", "pourquoi ma reservation est annulée"));
        //  System.out.println(cr.afficher());

    }
}
