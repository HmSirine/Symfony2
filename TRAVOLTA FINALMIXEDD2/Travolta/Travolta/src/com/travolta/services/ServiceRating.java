/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travolta.services;
import com.travolta.entities.Rating;
import com.travolta.entities.Evenement;
import com.travolta.utils.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author aghx0
 */
public class ServiceRating   implements IService<Rating> {
    private Connection cnx = DataSource.getInstance().getCnx();
   public void ajouter(Rating r) {
        String req = "INSERT INTO rating(id_evenement, etat) VALUES('" + r.getId_evenement() + "', '" + r.getEtat() + "')";
 try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Rating ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Rating r) {
        String req = "UPDATE  rating SET  etat= '"+r.getEtat() +"' WHERE id_evenement="+r.getId_evenement()+"";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Rating modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Rating r) {
        String req = "DELETE FROM rating WHERE id_rating="+r.getId_rating();
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Rating supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Rating> afficher() {
        List<Rating> list = new ArrayList<>();
        
        String req = "SELECT * FROM rating";
        try {
            Statement st = cnx.createStatement();
            ResultSet result = st.executeQuery(req);
            while(result.next()) {
                list.add(new Rating(result.getInt("id_rating"), result.getInt("id_evenement"), result.getString("etat")));
                
            }
            System.out.println("Rating récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
}