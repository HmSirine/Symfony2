/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import models.Hotel;
import utils.DataSource;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Ghassen Chamakh
 */
public class ServiceHotel  implements IService1<Hotel> {
    
    private Connection cnx = DataSource.getInstance().getCnx();

    
    public void ajouter(Hotel h) {
         try {
                    String req = "INSERT INTO hotel(titre,description,adresse,etoile,image) VALUES(?,?,?,?,?)";
            
                    java.sql.PreparedStatement pst = cnx.prepareStatement(req);

      
        
        pst.setString(1, h.getTitre());
        pst.setString(2, h.getDescription());
        pst.setString(3, h.getAdresse());
       pst.setInt(4, h.getEtoile());
       
       pst.setBytes(5, h.getImage());
       
        

            pst.executeUpdate();
            System.out.println("hotel ajoutee !");
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      
    }

  
    public void modifier(Hotel h) {
        try {
        if (h.getImage() == null) {
            throw new IllegalArgumentException("L'image  est null !");
        }

        String requete = "UPDATE hotel SET Titre=?,description=?,adresse=?,etoile=? WHERE id_hotel=?";
        PreparedStatement pst = cnx.prepareStatement(requete);

       

       
         
      
        
        pst.setString(1, h.getTitre());
        pst.setString(2, h.getDescription());
        pst.setString(3, h.getAdresse());
       pst.setInt(4, h.getEtoile());
       
       
  

        pst.executeUpdate();

        System.out.println("hotel est modifiée !");
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    } catch (IllegalArgumentException ex) {
        System.err.println(ex.getMessage());
    }
        
    }

    public void supprimer(Hotel h) {
        String req = "DELETE FROM hotel WHERE id_hotel="+h.getId_hotel();
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("hotel supprimee !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    
    public List<Hotel> afficher() {
        List<Hotel> list = new ArrayList<>();
        
        
        try{
 String requete = "SELECT * FROM hotel";
  PreparedStatement pst = cnx.prepareStatement(requete);
  ResultSet rs = pst.executeQuery();

  while (rs.next()) {
    int id_hotel = rs.getInt("id_hotel");
    String titre = rs.getString("titre");
    String description = rs.getString("description");
    String adresse = rs.getString("adresse");
    int etoile = rs.getInt("etoile");
               byte[] image = rs.getBytes("image");
   

   
  

    Hotel h = new Hotel(id_hotel,titre,description,adresse,etoile,image);
    list.add(h);
      System.out.println(list);
  }}
catch(SQLException ex){
        System.err.println(ex.getMessage());
        }
return list ;

    }  
        public List<Hotel> AfficherAvecImage() throws SQLException {
    List<Hotel> listHotel = new ArrayList<>();
    String requete = "SELECT titre, description,etoile,adresse, image FROM hotel ";
    PreparedStatement pst =cnx.prepareStatement(requete);
    try {
        ResultSet rs = pst.executeQuery();

        while(rs.next()){
            byte[] imageBytes = rs.getBytes("Image");
            Hotel h = new Hotel(rs.getString("titre"),rs.getString("description"), rs.getString("adresse"),rs.getInt("etoile"),  imageBytes);
            listHotel .add(h);
        }
    } catch (SQLException ex) {
        Logger.getLogger(ServiceChambre.class.getName()).log(Level.SEVERE, null, ex);
    }
    System.out.println("liste hotels!");
    System.out.println(listHotel );
    return listHotel ;
}
}
