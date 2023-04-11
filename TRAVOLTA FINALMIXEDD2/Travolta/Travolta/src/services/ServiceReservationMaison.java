/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import models.ReservationMaison;
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
 * @author Ghassen Chamakh
 */
public class ServiceReservationMaison implements IService1<ReservationMaison> {
    
    private Connection cnx = DataSource.getInstance().getCnx();

    
    public void ajouter(ReservationMaison rm) {
        try {
        String req = "INSERT INTO reservation_maison(date_arrivee,date_depart,nom,prenom,email,tarif,id_maison,user_id) VALUES(?,?,?,?,?,?,?,?);";
                                java.sql.PreparedStatement pst = cnx.prepareStatement(req);

          java.sql.Date sqldate_arrivee= java.sql.Date.valueOf(rm.getDate_arrivee());
         java.sql.Date sqldate_depart= java.sql.Date.valueOf(  rm.getDate_depart());
      
        pst.setDate(1, sqldate_arrivee);
        pst.setDate(2, sqldate_depart);
        pst.setString(3, rm.getNom());
        pst.setString(4, rm.getPrenom());
        pst.setString(5, rm.getEmail());
        pst.setFloat(6, rm.getTarif());
       pst.setInt(7, rm.getUser_id());
       pst.setInt(8, rm.getId_maison());
        

            pst.executeUpdate();
            System.out.println("reservation ajoutee !");
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        
    }

    
    public void modifier(ReservationMaison rm) {
         try {
        String req = "UPDATE  reservation_maison SET date_arrivee=?,date_depart=?,nom=?,prenom=?,email=?,tarif=?,id_maison=?,user_id=? WHERE id_reservation=?";
                               java.sql.PreparedStatement pst = cnx.prepareStatement(req);

          java.sql.Date sqldate_arrivee= java.sql.Date.valueOf(rm.getDate_arrivee());
         java.sql.Date sqldate_depart= java.sql.Date.valueOf(  rm.getDate_depart());
      
        pst.setDate(1, sqldate_arrivee);
        pst.setDate(2, sqldate_depart);
        pst.setString(3, rm.getNom());
        pst.setString(4, rm.getPrenom());
        pst.setString(5, rm.getEmail());
        pst.setFloat(6, rm.getTarif());
       pst.setInt(7, rm.getUser_id());
       pst.setInt(8, rm.getId_maison());
        

            pst.executeUpdate();
            System.out.println("reservation modifize !");
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        
    }

    @Override
    public void supprimer(ReservationMaison rm) {
        String req = "DELETE FROM reservation_maison WHERE id_reservation="+rm.getId_reservation();
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("reservation supprimee !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<ReservationMaison> afficher() {
        List<ReservationMaison> list = new ArrayList<>();
        
        String req = "SELECT * FROM reservation_maison";
        try {
            Statement st = cnx.createStatement();
            ResultSet result = st.executeQuery(req);
            while(result.next()) {
                java.sql.Date datearrivee =result.getDate("date_arrivee");//traduire date en date sql
                LocalDate Localdate_arrivee = datearrivee.toLocalDate();
                java.sql.Date datedepart =result.getDate("date_depart");
                LocalDate Localdate_depart = datedepart.toLocalDate();
                list.add(new ReservationMaison(result.getInt("id_reservation"), Localdate_arrivee,Localdate_depart, result.getString("nom"), result.getString("prenom"), result.getString("email"), result.getFloat("tarif"),result.getInt("id_maison"),result.getInt("user_id")));
            }
            System.out.println("Reservation recuperees !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
}


