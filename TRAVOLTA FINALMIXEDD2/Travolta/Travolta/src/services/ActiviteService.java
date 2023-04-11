/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import GUI.ExcursionCategoryController;
import static GUI.ExcursionCategoryController.SelectedExcursion;
import models.Activite;
import utils.DataSource;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.imageio.ImageIO;


/**
 *
 * @author DELL
 */
public class ActiviteService implements Iservices<Activite>  {
   
        Connection cnx = DataSource.getInstance().getCnx();


    @Override
public void Ajouter(Activite a) {
try {
String query = "INSERT INTO activite (NomActivite,ImageActivite, PrixActivite, TypeActivite) VALUES (?, ?, ?, ?)";
PreparedStatement pstmt = cnx.prepareStatement(query);
pstmt.setString(1, a.getNomActivite());
pstmt.setFloat(3, a.getPrixActivite());
pstmt.setString(4, a.getTypeActivite());
pstmt.setBytes(2, a.getImageActivite());
pstmt.executeUpdate();
System.out.println("Activité ajoutée avec succès");
} catch (SQLException ex) {
Logger.getLogger(ActiviteService.class.getName()).log(Level.SEVERE, null, ex);
}
}

    @Override
    public void Supprimer(int t) {
       
try{
        String requete = "DELETE FROM activite WHERE IdActivite=?";
        PreparedStatement pst = cnx.prepareStatement(requete);
        pst.setInt(1, t);
        pst.executeUpdate();
        System.out.println("activite Supprimé !");
        }

catch(SQLException ex){
        System.err.println(ex.getMessage());
        }        }

    @Override
    public void Modifier(Activite t) {
    
}
    public void update(int idAct,String nomAct,float prixAct,String typeAct){
            try {
                String requete = "UPDATE activite SET NomActivite=?,PrixActivite=?,TypeActivite=? WHERE IdActivite="+idAct;
                PreparedStatement pst = cnx.prepareStatement(requete);
                
                pst.setString(1, nomAct);
                pst.setFloat(2, prixAct);
                pst.setString(3, typeAct);
                pst.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(ActiviteService.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    @Override
    public ObservableList<Activite> Afficher() {
                        ObservableList<Activite> listactivite = FXCollections.observableArrayList();
                        String requete = "SELECT IdActivite,NomActivite,PrixActivite,TypeActivite FROM activite ";
                        PreparedStatement pst ;


            try {
                /*private int  IdActivite ;
                private String NomActivite ;
                private  float PrixActivite ;
                private String TypeActivite;
                private String ImageActivite ; */
                
                    pst=new DataSource().getCnx().prepareStatement(requete);

                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    /*Blob blob = rs.getBlob("ImageActivite");
                    InputStream inputStream = blob.getBinaryStream();
                    BufferedImage ImageProvenantDuBlob = ImageIO.read(inputStream);*/
                    /* BufferedImage image = null;
                    byte[] imageData = rs.getBytes("ImageActivite");
                    if (imageData != null) {
                    try (InputStream in = new ByteArrayInputStream(imageData)) {
                    //image = ImageIO.read(in);*/
                    Activite a=new Activite(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getString(4));
                    
                    listactivite.add( a);
                    
                    
                }           } catch (SQLException ex) {
                Logger.getLogger(ActiviteService.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    
        
        System.out.println("liste activites!");
        System.out.println("listactivite");

  return listactivite;

        }
 public List<Activite> Afficher1() {
    List<Activite> listactivitepdf = new ArrayList<>();
    String requete = "SELECT NomActivite,PrixActivite,TypeActivite FROM activite ";
    PreparedStatement pst ;
    try {
        pst = new DataSource().getCnx().prepareStatement(requete);
        ResultSet rs = pst.executeQuery();
        
        while(rs.next()){
            
            Activite a = new Activite(rs.getString(1), rs.getFloat(2), rs.getString(3));
            listactivitepdf.add(a);
        }
    } catch (SQLException ex) {
        Logger.getLogger(ActiviteService.class.getName()).log(Level.SEVERE, null, ex);
    }
    System.out.println("liste activites!");
    System.out.println(listactivitepdf);
    return listactivitepdf;
}

    @Override
    public Activite chercherById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
   public List<Activite> AfficherAvecImage( ) {
       String b = ExcursionCategoryController.SelectedExcursion;
    List<Activite> listactivitepdf = new ArrayList<>();
    String requete = "SELECT NomActivite, PrixActivite, TypeActivite, ImageActivite FROM activite ";
    PreparedStatement pst ;
    try {
        pst = new DataSource().getCnx().prepareStatement(requete);
        ResultSet rs = pst.executeQuery();

        while(rs.next()){
            byte[] imageBytes = rs.getBytes("ImageActivite");
            Activite a = new Activite(rs.getString("NomActivite"), imageBytes, rs.getFloat("PrixActivite"), rs.getString("TypeActivite"));
            if(rs.getString("TypeActivite").equals(b))
            listactivitepdf.add(a);
        }
    } catch (SQLException ex) {
        Logger.getLogger(ActiviteService.class.getName()).log(Level.SEVERE, null, ex);
    }
    System.out.println("liste activites!");
    System.out.println(listactivitepdf);
    return listactivitepdf;
}
   
   
   public List<Activite> getAllActivites() {
   List<Activite> activites = new ArrayList<>();

   try {
       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travolta", "", "");
       Statement stmt = conn.createStatement();
       ResultSet rs = stmt.executeQuery("SELECT * FROM activites");

       while (rs.next()) {
           int idActivite = rs.getInt("IdActivite");
           String nomActivite = rs.getString("NomActivite");
           byte[] imageActivite = rs.getBytes("ImageActivite");
           float prixActivite = rs.getFloat("PrixActivite");
           String typeActivite = rs.getString("TypeActivite");

           Activite activite = new Activite(idActivite, nomActivite, imageActivite, prixActivite, typeActivite);
           activites.add(activite);
       }

       rs.close();
       stmt.close();
       conn.close();
   } catch (SQLException e) {
       e.printStackTrace();
   }

   return activites;
}
    
    
    
   
        
        
        
        
        
    }
  

  

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    
   
    

