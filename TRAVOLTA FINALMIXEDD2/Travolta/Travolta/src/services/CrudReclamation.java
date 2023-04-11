/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import models.Reclamation;
import models.Utilisateur;
import utils.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class CrudReclamation implements IUtilisateur<Reclamation> {

    private Connection cnx = DataSource.getInstance().getCnx();

    public void Ajouter(Reclamation u) {

        String req = "INSERT INTO reclamation(ref, objet, MSG) VALUES('" + u.getRef() + "', '" + u.getObjet() + "', '" + u.getMSG() + "');";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Reclamation ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Reclamation u) {
        String req = "UPDATE  reclamation SET  objet='" + u.getObjet() + "', MSG= '" + u.getMSG() + "' WHERE ref=" + u.getRef() + "";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Reclamation modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Reclamation u) {
        String req = "DELETE FROM reclamation WHERE id=" + u.getRef();
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Reclamation supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Reclamation> afficher() {
        List<Reclamation> list = new ArrayList<>();

        
        String req = "SELECT * FROM reclamation ORDER BY objet";
        try {
            Statement st = cnx.createStatement();
            ResultSet result = st.executeQuery(req);
            while (result.next()) {
                list.add(new Reclamation(result.getInt("ref"), result.getString("objet"), result.getString("MSG")));
            }
            System.out.println("Reclamation récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

   public boolean reclamationExists(Reclamation reclamation) {
    boolean exists = false;

    try {
        Connection conn = DataSource.getInstance().getCnx();
        Statement stmt = conn.createStatement();
        String query = "SELECT * FROM Reclamation WHERE objet='" + reclamation.getObjet() + "' AND MSG='" + reclamation.getMSG() + "'";
        ResultSet rs = stmt.executeQuery(query);

        if (rs.next()) {
            exists = true;
        }

        rs.close();
        stmt.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return exists;
}



    
}
