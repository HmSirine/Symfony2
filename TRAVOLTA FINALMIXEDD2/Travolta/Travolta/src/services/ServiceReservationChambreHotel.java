/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import models.ReservationChambreHotel;
import utils.DataSource;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Ghassen Chamakh
 */
public class ServiceReservationChambreHotel implements IService1<ReservationChambreHotel> {
    private Connection cnx = DataSource.getInstance().getCnx();
    
    public void ajouter(ReservationChambreHotel rh) {
      try {
        String req = "INSERT INTO reservation_hotel(date_arrivee,date_depart,nombre_chambre,nom,prenom,email,tarif,id_chambre,user_id) VALUES(?,?,?,?,?,?,?,?,?);";
                                java.sql.PreparedStatement pst = cnx.prepareStatement(req);

          java.sql.Date sqldate_arrivee= java.sql.Date.valueOf(rh.getDate_arrivee());
         java.sql.Date sqldate_depart= java.sql.Date.valueOf(   rh.getDate_depart());
      
        pst.setDate(1, sqldate_arrivee);
        pst.setDate(2, sqldate_depart);
        pst.setInt(3, rh.getNombre_chambre());
        pst.setString(4, rh.getNom());
        pst.setString(5, rh.getPrenom());
        pst.setString(6, rh.getEmail());
        pst.setFloat(7, rh.getTarif());
        pst.setInt(8, rh.getId_chambre());
       pst.setInt(9, rh.getId_user());
       
        

            pst.executeUpdate();
            System.out.println("reservation ajoutee !");
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
    }

    
    public void modifier(ReservationChambreHotel rh) {
        try {
       
        String req = "UPDATE  reservation_hotel SET date_arrivee=?,date_depart=?,nombre_chambre=?,nom=?,prenom=?,email=?,tarif=?,id_chambre=?,user_id=? WHERE id_reservation=?";
         PreparedStatement pst = cnx.prepareStatement(req);

       
    java.sql.Date sqldate_arrivee= java.sql.Date.valueOf(rh.getDate_arrivee());
         java.sql.Date sqldate_depart= java.sql.Date.valueOf( rh.getDate_depart());
          pst.setDate(1, sqldate_arrivee);
        pst.setDate(2, sqldate_depart);
        pst.setInt(3, rh.getNombre_chambre());
        pst.setString(4, rh.getNom());
        pst.setString(5, rh.getPrenom());
        pst.setString(6, rh.getEmail());
        pst.setFloat(7, rh.getTarif());
         pst.setInt(8, rh.getId_chambre());
       pst.setInt(9, rh.getId_user());
       pst.setInt(10, rh.getId_reservation());
      
        

        pst.executeUpdate();

        System.out.println(" reservation est modifiée !");
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    } catch (IllegalArgumentException ex) {
        System.err.println(ex.getMessage());
    }

    }
    @Override
    public void supprimer(ReservationChambreHotel rh) {
        String req = "DELETE FROM reservation_hotel WHERE id_reservation="+rh.getId_reservation();
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("reservation supprimee !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<ReservationChambreHotel> afficher() {
        List<ReservationChambreHotel> list = new ArrayList<>();
        
        String req = "SELECT * FROM reservation_hotel";
        try {
            Statement st = cnx.createStatement();
            ResultSet result = st.executeQuery(req);
            while(result.next()) {
                java.sql.Date datearrivee =result.getDate("date_arrivee");
                LocalDate Localdate_arrivee = datearrivee.toLocalDate();
                java.sql.Date datedepart =result.getDate("date_depart");
                LocalDate Localdate_deaprt = datedepart.toLocalDate();
                
                list.add(new ReservationChambreHotel(result.getInt("id_reservation"), Localdate_arrivee,Localdate_deaprt,result.getInt("nombre_chambre"),result.getString("nom"),result.getString("prenom"),result.getString("email"), result.getFloat("tarif"),result.getInt("id_chambre"),result.getInt("user_id")));
            }
            System.out.println("Reservation recuperees !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
    
}



