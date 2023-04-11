/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travolta.services;

import com.travolta.entities.Reclamation;
import com.travolta.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aghx0
 */
public class ServiceReclamation implements IService<Reclamation> {
    
    private Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(Reclamation r) {
        String req = "INSERT INTO reclamation(id_evenement, mail,description) VALUES('"+r.getId_evenement()+"', '"+r.getMail()+"', '"+r.getDescription()+"');";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Reservation Evenement ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Reclamation r) {
        String req = "UPDATE  reclamation SET  mail= ?, description=?  WHERE id_reclamation="+r.getId_reclamation();
        PreparedStatement st;
        try {
          
           st=new DataSource().getCnx().prepareStatement(req);
           st.setString(1, r.getMail());
           st.setString(2, r.getDescription());
           st.executeUpdate();
            System.out.println("reclamation modifiée !");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(Reclamation r) {
        String req = "DELETE FROM reclamation WHERE id_reclamation="+r.getId_reclamation();
             PreparedStatement st ;
        try {
       
            st=new DataSource().getCnx().prepareStatement(req);
            st.executeUpdate(req);
            System.out.println("reclamation supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Reclamation> afficher() {
        List<Reclamation> list = new ArrayList<>();
        
        String req = "SELECT * FROM reclamation";
      PreparedStatement st;
        try {
   

            
             st=new DataSource().getCnx().prepareStatement(req);
            ResultSet result = st.executeQuery(req);
            while(result.next()) {
                list.add(new Reclamation(result.getInt("id_evenement"), result.getString("mail"), result.getString("description")));
                
            }
            System.out.println("reclamation récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
}
