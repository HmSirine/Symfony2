/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import models.Excursion;
import utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Activite;

/**
 *
 * @author DELL
 */
public class ExcursionService implements Iservices<Excursion> {
        Connection cnx = DataSource.getInstance().getCnx();


    @Override
    public void Ajouter(Excursion t) {
try{
     /*private int  IdExcursion ; 
   private String TypeExcursion ; 
   private int NbPersonnes ; 
   private  float PrixUnitaire ;*/
            
        String requete = "INSERT INTO excursion(IdExcursion,TypeExcursion,NbPersonnes,PrixUnitaire) VALUES (?,?,?,?)";
        PreparedStatement pst = cnx.prepareStatement(requete);
        pst.setInt(1, t.getIdExcursion());
        pst.setString(2, t.getTypeExcursion());
        pst.setInt(3, t.getNbPersonnes());
        pst.setFloat(4, t.getPrixUnitaire());
        pst.executeUpdate();
        System.out.println(t.getTypeExcursion()+"Excursion ajoutée !");
        }catch(SQLException ex){
        System.err.println(ex.getMessage());
        }    }

    @Override
    public void Supprimer(int t) {
try{
    
        String requete = "DELETE FROM excursion WHERE idExcursion=?";
        PreparedStatement pst = cnx.prepareStatement(requete);
        pst.setInt(1, t);
        pst.executeUpdate();
        System.out.println("Excursion Supprimé !");
        }catch(SQLException ex){
        System.err.println(ex.getMessage());
        }        }

    @Override
    public void Modifier(Excursion t) {
         /*private int  IdExcursion ; 
   private String TypeExcursion ; 
   private int NbPersonnes ; 
   private  float PrixUnitaire ;*/
try{    
        String requete = "UPDATE excursion SET TypeExcursion=?,NbPersonnes= ?,PrixUnitaire=? WHERE IdExcursion=?";
        PreparedStatement pst = cnx.prepareStatement(requete);
        pst.setString(1, t.getTypeExcursion());
        pst.setInt(2, t.getNbPersonnes());
        pst.setFloat(3, t.getPrixUnitaire());
        pst.setInt(4, t.getIdExcursion());

        
        pst.executeUpdate();
        System.out.println("Excursion modifiée !");
        }catch(SQLException ex){
        System.err.println(ex.getMessage());
        }     }
    public void Update(int idEx,String type,int nbrPer,float prixUni){
       
try{    
        String requete = "UPDATE excursion SET TypeExcursion=?,NbPersonnes= ?,PrixUnitaire=? WHERE IdExcursion="+idEx;
        PreparedStatement pst = cnx.prepareStatement(requete);
        pst.setString(1, type);
        pst.setInt(2, nbrPer);
        pst.setFloat(3,prixUni);

        
        pst.executeUpdate();
        System.out.println("Excursion modifiée !");
        }catch(SQLException ex){
        System.err.println(ex.getMessage());
        } 
    }

    @Override
    public ObservableList<Excursion> Afficher() {
         
        ObservableList<Excursion> listexcursion = FXCollections.observableArrayList();
        try{
        String requete = "SELECT * FROM excursion";
        PreparedStatement pst = cnx.prepareStatement(requete);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            listexcursion.add(new Excursion(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getFloat(4)));
            
        }
        System.out.println("Affichage Excursions!");
         System.out.println(listexcursion);

        
        }catch(SQLException ex){
        System.err.println(ex.getMessage());
        }
        return listexcursion;
           }
    
     public List<Excursion> Afficher2() {
    List<Excursion> listexcursionpdf = new ArrayList<>();
    String requete = "SELECT TypeExcursion,NbPersonnes,PrixUnitaire FROM excursion ";
    PreparedStatement pst ;
    try {
        pst = new DataSource().getCnx().prepareStatement(requete);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            Excursion a = new Excursion(rs.getString(1), rs.getInt(2), rs.getFloat(3));
            listexcursionpdf.add(a);
        }
    } catch (SQLException ex) {
        Logger.getLogger(ExcursionService.class.getName()).log(Level.SEVERE, null, ex);
    }
    System.out.println("liste Excursions!");
    System.out.println(listexcursionpdf);
    return listexcursionpdf;
}

    @Override
    public Excursion chercherById(int id) {
List<Excursion> list = new ArrayList<>();
        try{
            /*private int  IdExcursion ; 
   private String TypeExcursion ; 
   private int NbPersonnes ; 
   private  float PrixUnitaire ;*/
        String requete = "SELECT * FROM excursion where IdExcursion="+id;
        PreparedStatement pst = cnx.prepareStatement(requete);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            list.add(new Excursion(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getFloat(4)));
        }
        System.out.println("l'excursion recherché est : ");
        System.out.println(list.get(0));
        
        }catch(SQLException ex){
        System.err.println(ex.getMessage());
        }
        return list.get(0);    }
    
}
