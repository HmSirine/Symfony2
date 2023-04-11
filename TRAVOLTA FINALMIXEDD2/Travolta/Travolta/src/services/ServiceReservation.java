/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import models.Reservation;
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
public class ServiceReservation implements IService<Reservation>{
 private Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(Reservation r) {
       
       String req = "INSERT INTO reservation ( Adresse, price,Checkin,Checkout,dure_sejour,status) VALUES('"+r.getAdresse()+"','"+r.getPrice()+"','"+r.getCheckin()+"','"+r.getCheckout()+"','"+r.getDure_sejour()+"','"+r.getStatus()+"')";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Reservation ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Reservation r) {
    
       String req = "UPDATE  reservation SET Adresse='"+r.getAdresse()+"', price= '"+r.getPrice()+"',Checkin='"+r.getCheckin()+"',Checkout='"+r.getCheckout()+"',Dure_sejour='"+r.getDure_sejour()+"',Status='"+r.getStatus()+"' WHERE reservation_id="+r.getReservation_id()+"";
       try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("reservation modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Reservation r) {
        String req = "DELETE FROM reservation WHERE reservation_id="+r.getReservation_id(); 
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("reservation supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Reservation> afficher() {
          List<Reservation> list = new ArrayList<>();
           String req = "SELECT * FROM reservation";
    try {
            Statement st = cnx.createStatement();
            ResultSet result = st.executeQuery(req);
            while(result.next()) {
                list.add(new Reservation(result.getInt("reservation_id"),result.getFloat("price"),result.getString("Adresse"), result.getString("Checkin"), result.getString("Checkout"),result.getInt("dure_sejour"),result.getInt("status")   ));
            }
            System.out.println("Reservation récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }

  
   
}
