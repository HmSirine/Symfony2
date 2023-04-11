/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import models.ReservationExcursion;
import utils.DataSource;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author DELL
 */
public class ReservationService implements Iservices<ReservationExcursion> {
           
    Connection cnx = DataSource.getInstance().getCnx();

    


    @Override
    public void Ajouter(ReservationExcursion t) {
   /*private int  IdReservation ; 
   private String IdClient ; 
   private Date DateReservation ; 
   private  float PrixTotal ;*/
try{
            
        String requete = "INSERT INTO reservation(IdClient,DateReservation,PrixTotal) VALUES (?,?,?)";
        PreparedStatement pst = cnx.prepareStatement(requete);
        java.sql.Date sqlDate = java.sql.Date.valueOf(t.getDateReservation());
        
        
        pst.setInt(1, t.getIdClient());
        pst.setDate(2, sqlDate);
        pst.setFloat(3, t.getPrixTotal());
        pst.executeUpdate();
        System.out.println("reservation d'iedntifiant"+t.getIdReservation()+"est ajoutée");
        }catch(SQLException ex){
        System.err.println(ex.getMessage());
        }    }

     @Override
    public void Supprimer(int t) {
         /*private int  IdReservation ; 
   private String IdClient ; 
   private Date DateReservation ; 
   private  float PrixTotal ;*/
try{
    
        String requete = "DELETE FROM reservation WHERE IdReservation=?";
        PreparedStatement pst = cnx.prepareStatement(requete);
        pst.setInt(1, t);
        pst.executeUpdate();
        System.out.println("reservation Supprimé !");
        }catch(SQLException ex){
        System.err.println(ex.getMessage());
        }        }

    @Override
    public void Modifier(ReservationExcursion R) {}
    
    
    public void Update(int idRes ,int idclient,LocalDate lclDate,float prixTot) {
        /*private int  IdReservation ; 
   private String IdClient ; 
   private Date DateReservation ; 
   private  float PrixTotal ;*/
         
try{    
        String requete = "UPDATE reservation SET IdClient=?,DateReservation= ?,PrixTotal=? WHERE IdReservation="+idRes;
        PreparedStatement pst = cnx.prepareStatement(requete);
        java.sql.Date sqlDate = java.sql.Date.valueOf(lclDate);

        pst.setInt(1, idclient);
        pst.setDate(2, sqlDate);
        pst.setFloat(3, prixTot);

        
        pst.executeUpdate();
        System.out.println("Excursion mofidiée !");
        }catch(SQLException ex){
        System.err.println(ex.getMessage());
        }     }

    @Override
    public ObservableList<ReservationExcursion> Afficher() {
        /*private int  IdReservation ; 
   private String IdClient ; 
   private Date DateReservation ; 
   private  float PrixTotal ;*/
         
ObservableList<ReservationExcursion> listreservation = FXCollections.observableArrayList();
        try{
        String requete = "SELECT * FROM reservation";
        PreparedStatement pst = cnx.prepareStatement(requete);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            java.sql.Date date = rs.getDate("DateReservation");
            LocalDate localDate = date.toLocalDate();
            listreservation.add(new ReservationExcursion(rs.getInt(1),rs.getInt(2),localDate,rs.getFloat(4)));
        }
        System.out.println("Liste reservations!");
      System.out.println(listreservation);

        }catch(SQLException ex){
        System.err.println(ex.getMessage());
        }
        return listreservation ;
           }

    @Override
    public ReservationExcursion chercherById(int id) {
         /*private int  IdReservation ; 
   private String IdClient ; 
   private Date DateReservation ; 
   private  float PrixTotal ;*/
List<ReservationExcursion> listreservation = new ArrayList<>();
        try{
             /*private int  IdReservation ; 
   private String IdClient ; 
   private Date DateReservation ; 
   private  float PrixTotal ;*/
        String requete = "SELECT * FROM reservation where IdReservation="+id;
        PreparedStatement pst = cnx.prepareStatement(requete);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            java.sql.Date date = rs.getDate("DateReservation");
            LocalDate localDate = date.toLocalDate();
            listreservation.add(new ReservationExcursion(rs.getInt(1),rs.getInt(2),localDate,rs.getFloat(4)));
        }
        System.out.println("reservation avec identifiant :"+id+"est");
            System.out.println(listreservation);
        }catch(SQLException ex){
        System.err.println(ex.getMessage());
        }
        return listreservation.get(0);    }
    
}
