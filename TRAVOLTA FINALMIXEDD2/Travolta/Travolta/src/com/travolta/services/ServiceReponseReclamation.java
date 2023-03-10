/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travolta.services;


import com.travolta.entities.ReponseReclamation;
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
public class ServiceReponseReclamation implements IService<ReponseReclamation> {
    
    private Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(ReponseReclamation re) {
        String req = "INSERT INTO reponse (reponse) VALUES( 1,'"+re.getReponse()+"');";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("reponse reclamation ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(ReponseReclamation re) {
        String req = "UPDATE  reponse SET reponse='"+re.getReponse()+"' WHERE id_reponse="+re.getId_reponse()+"";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("reponse reclamation modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(ReponseReclamation re) {
        String req = "DELETE FROM reponse WHERE id_reponse="+re.getId_reponse();
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("reponse reclamation supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<ReponseReclamation> afficher() {
        List<ReponseReclamation> list = new ArrayList<>();
        
        String req = "SELECT * FROM reponse";
        try {
            Statement st = cnx.createStatement();
            ResultSet result = st.executeQuery(req);
            while(result.next()) {
                list.add(new ReponseReclamation(result.getString("reponse")));
                
            }
            System.out.println("reponse reclamation récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
}
