/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import models.Vehicule;
import utils.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mr.rhimi
 */
public class ServiceVehicule implements IService<Vehicule>{

    private Connection cnx = DataSource.getInstance().getCnx();
    @Override
    public void ajouter(Vehicule r) {
         String req = "INSERT INTO vehicule ( marque, matricule,couleur,prix,nb_place,status,image) VALUES('"+r.getMarque()+"','"+r.getMatricule()+"','"+r.getCouleur()+"','"+r.getPrix()+"','"+r.getNb_place()+"','"+r.getStatus()+"','"+r.getImage()+"')";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("vehicule ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Vehicule r) {
        String req = "UPDATE  vehicule SET marque='"+r.getMarque()+"', matricule= '"+r.getMatricule()+"',couleur='"+r.getCouleur()+"',prix='"+r.getPrix()+"',nb_place='"+r.getNb_place()+"',status='"+r.getStatus()+"',image='"+r.getImage()+"' WHERE vehicule_id="+r.getVehicule_id()+"";
       try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("vehicule modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Vehicule r) {
        String req = "DELETE FROM vehicule WHERE vehicule_id="+r.getVehicule_id(); 
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("vehicule supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Vehicule> afficher() {
        List<Vehicule> list = new ArrayList<>();
           String req = "SELECT * FROM Vehicule";
            
    try {
            Statement st = cnx.createStatement();
            ResultSet result = st.executeQuery(req);
            while(result.next()) {
                list.add(new Vehicule(result.getInt("vehicule_id"),result.getString("marque"), result.getString("matricule"), result.getString("couleur"),result.getFloat("prix"),result.getInt("nb_place"),result.getInt("status"),result.getString("image")   ));
            }
            System.out.println("Vehicule récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }

   
    
}
