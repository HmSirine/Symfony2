/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import models.Locations;
import models.Locations;
import java.sql.Date;
import utils.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mr.rhimi
 */
public class ServiceLocation implements IService<Locations>{
     private Connection cnx = DataSource.getInstance().getCnx();

     
     @Override
    public void ajouter(Locations r) {
         java.sql.Date sqldate_arrivee= java.sql.Date.valueOf(r.getDebut_location());
        java.sql.Date sqldate_fin= java.sql.Date.valueOf(   r.getFin_location());
         String req = "INSERT INTO location ( debut_location, fin_location,destination,montant,status,client_id,vehicule_id) VALUES('"+sqldate_arrivee+"','"+sqldate_fin+"','"+r.getDestination()+"','"+r.getMontant()+"','"+r.getStatus()+"','"+r.getClient_id()+"','"+r.getVehicule_id()+"')";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("location ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Locations r) {
        
        String req = "UPDATE  location SET debut_location='"+r.getDebut_location()+"', fin_location= '"+r.getFin_location()+"',destination='"+r.getDestination()+"',montant='"+r.getMontant()+"',status='"+r.getStatus()+"',status='"+r.getVehicule_id()+"',status='"+r.getClient_id()+"' WHERE location_id="+r.getLocation_id()+"";
       try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("location modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Locations r) {
       String req = "DELETE FROM location WHERE location_id="+r.getLocation_id(); 
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("location supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Locations> afficher() {
        List<Locations> list = new ArrayList<>();
           String req = "SELECT * FROM location";
            
    try {
            Statement st = cnx.createStatement();
            ResultSet result = st.executeQuery(req);
            while(result.next()) {
                 java.sql.Date datearrivee = result.getDate("debut_location") ;
                  LocalDate Localdatearrivee= datearrivee.toLocalDate();
                 java.sql.Date datefin = result.getDate("fin_location") ;
                  LocalDate Localdatefin = datefin.toLocalDate();
                list.add(new Locations(result.getInt("location_id"),result.getInt("vehicule_id"),result.getInt("client_id") ,Localdatearrivee,Localdatefin, result.getString("destination"),result.getFloat("montant"),result.getInt("status")  ));
            }
            System.out.println("location récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }



    
}
