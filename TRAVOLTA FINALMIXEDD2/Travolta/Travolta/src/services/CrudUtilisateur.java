/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import models.Admin;
import models.Utilisateur;
import utils.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.DropMode.INSERT;

/**
 *
 * @author hp
 */
public class CrudUtilisateur implements IUtilisateur<Utilisateur> {

    private Connection cnx = DataSource.getInstance().getCnx();

    private static String role = "ROLE_USER";

    @Override
    public void Ajouter(Utilisateur u) {
        if (role == null || role.isEmpty()) {
            role = "ROLE_USER";
        }
        //  u.setRole(role);
        String req = "INSERT INTO utilisateur(nom, prenom, adresse, mdp, role) VALUES('" + u.getNom() + "', '" + u.getPrenom() + "', '" + u.getAdresse() + "', '" + u.getMdp() + "', '" + u.getRole() + "');";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Utilisateur ajouté !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Utilisateur u) {
        String req = "UPDATE  utilisateur SET  nom='" + u.getNom() + "', prenom= '" + u.getPrenom() + "', adresse= '" + u.getAdresse() + "', mdp= '" + u.getMdp() + "', role='" + u.getRole() + "'  WHERE id=" + u.getId() + "";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Utilisateur modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void modifierRole(Utilisateur u, String role) {
        u.setRole(role);
        String req = "UPDATE utilisateur SET role = '" + u.getRole() + "' WHERE id = " + u.getId() + ";";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Rôle modifié !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Utilisateur u) {
        String req = "DELETE FROM utilisateur WHERE id=" + u.getId();
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Utilisateur supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Utilisateur> afficher() {
        List<Utilisateur> list = new ArrayList<>();

        String req = "SELECT * FROM utilisateur ORDER BY nom";

        try {
            Statement st = cnx.createStatement();
            ResultSet result = st.executeQuery(req);
            while (result.next()) {
                list.add(new Utilisateur(result.getInt("id"),result.getString("nom"), result.getString("prenom"), result.getString("Adresse")));
            }
            System.out.println("Utilisateur récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    public boolean ValidateLogin(String adresse, String mdp) {
        //chercher l'utilisateur avec email et password
        String LoginVerif = "SELECT count(1) FROM utilisateur WHERE adresse= '" + adresse + "'AND mdp ='" + mdp + "'";
        try {
            Statement stm = cnx.createStatement();
            ResultSet queryResult = stm.executeQuery(LoginVerif);

            // verifier et afficher si l'utilisateur existe
            while (queryResult.next()) {
                if (queryResult.getInt(1) != 1) {
                    return false;
                }
            }

        } catch (Exception e) {
            Logger.getLogger(CrudUtilisateur.class.getName()).log(Level.SEVERE, null, e);
        }
        return true;
    }

    //verifier si l'email existe deja lors de l'inscription 
    public boolean ValidateEmail(String adresse) {
        String EmailVerif = "SELECT count(1) FROM utilisateur WHERE adresse = '" + adresse + "' ";
        try {
            Statement stm = cnx.createStatement();
            ResultSet queryResult = stm.executeQuery(EmailVerif);

            // verifier et afficher si l'email existe
            while (queryResult.next()) {
                if (queryResult.getInt(1) != 1) {
                    return true;
                }
            }

        } catch (Exception e) {
            Logger.getLogger(CrudUtilisateur.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    // details d'une session pour la connexion/session
    public Utilisateur SessionDetails(String adresse, String nom, String prenom) {
        String query = "SELECT * from utilisateur WHERE adresse='" + adresse + "' nom='"+ nom +"' prenom='" + prenom + "'";

        Utilisateur u = new Utilisateur();
        try {
            Statement stm = cnx.createStatement();
            ResultSet rst = stm.executeQuery(query);
            while (rst.next()) {
                u.setId(rst.getInt("id"));
                u.setNom(rst.getString("nom"));
                u.setPrenom(rst.getString("Prenom"));
                u.setAdresse(rst.getString("adresse"));
                u.setMdp(rst.getString("mdp"));
                u.setRole(rst.getString("role"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(CrudReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return u;

    }
    
        // details d'une session pour la connexion/session
    public Utilisateur SessionDetails1(String adresse) {
        String query = "SELECT * from utilisateur WHERE adresse='" + adresse +"'";

        Utilisateur u = new Utilisateur();
        try {
            Statement stm = cnx.createStatement();
            ResultSet rst = stm.executeQuery(query);
            while (rst.next()) {
                u.setId(rst.getInt("id"));
                u.setNom(rst.getString("nom"));
                u.setPrenom(rst.getString("Prenom"));
                u.setAdresse(rst.getString("adresse"));
                u.setMdp(rst.getString("mdp"));
                u.setRole(rst.getString("role"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(CrudReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return u;

    }

    // mot  de passe oublié avec mail 
    // generer un code pour l'envoyer 
    public Utilisateur CodeConf(String adresse) {

        Random rand = new Random();
        int code = rand.nextInt(999999);

        String query = "SELECT * from Utilisateur WHERE Adresse='" + adresse + "'";
        String query2 = "UPDATE Utilisateur SET Code ='" + code + "' WHERE email ='" + adresse + "'";

        Utilisateur u = new Utilisateur();
        try {
            Statement stm = cnx.createStatement();
            stm.executeUpdate(query2);

            ResultSet rst = stm.executeQuery(query);

            while (rst.next()) {

                u.setNom(rst.getString("Nom"));
                u.setCode(rst.getInt("Code"));

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return u;
    }

    public boolean VerifCode(String adresse, int Code) {
        String query = "SELECT * from Utilisateur WHERE Email='" + adresse + "'";
        try {
            Statement stm = cnx.createStatement();
            ResultSet rst = stm.executeQuery(query);

            while (rst.next()) {
                if (rst.getInt("Code") == Code) {
                    return true;
                }

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;

    }

    public void NewPw(String adresse, String mdp) {

        String query = "update Utilisateur set mdp='" + mdp + "', confirm_password='" + mdp + "'  where adresse='" + adresse + "' ";

        try {

            Statement stm = cnx.createStatement();

            stm.executeUpdate(query);
            System.out.println("Mot de passe changé ");

        } catch (SQLException ex) {
            System.out.println("Echec");
            System.out.println(ex);
        }
    }

}
