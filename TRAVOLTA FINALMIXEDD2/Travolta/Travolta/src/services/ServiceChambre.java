/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import models.Chambre;
import utils.DataSource;
import java.awt.image.BufferedImage;
import java.beans.Statement;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import utils.DataSource;

/**
 *
 * @author Ghassen Chamakh
 */
public class ServiceChambre implements IService1<Chambre> {
    
    private Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(Chambre c) {
        try {
                    String req = "INSERT INTO chambre(nombre_lit,description,numero_chambre,categorie,prix,status_hebergement,image,id_hotel) VALUES(?,?,?,?,?,?,?,?)";
            
                    java.sql.PreparedStatement pst = cnx.prepareStatement(req);

      
        pst.setInt(1, c.getNb_lit());
        pst.setString(2, c.getDescription());
        pst.setInt(3, c.getNombre_chambre());
        pst.setString(4, c.getCategorie());
        pst.setFloat(5, c.getPrix());
        pst.setString(6, c.getStatus_hebergement());
       pst.setBytes(7, c.getImage());
       pst.setInt(8, c.getId_hotel());
        

            pst.executeUpdate();
            System.out.println("chambre ajoutee !");
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Chambre c) {
        
    try {
        if (c.getImage() == null) {
            throw new IllegalArgumentException("L'image  est null !");
        }

        String requete = "UPDATE chambre SET nombre_lit=?,description=?,numero_chambre=?,categorie=?,prix=?,status_hebergement=?,id_hotel=? WHERE Id_chambre=?";
        PreparedStatement pst = cnx.prepareStatement(requete);

       

    
         
        pst.setInt(1, c.getNb_lit());
        pst.setString(2, c.getDescription());
        pst.setInt(3, c.getNombre_chambre());
        pst.setString(4, c.getCategorie());
        pst.setFloat(5, c.getPrix());
        pst.setString(6, c.getStatus_hebergement());
        pst.setInt(7, c.getId_hotel());
        pst.setInt(8, c.getId_chambre());

  

        pst.executeUpdate();

        System.out.println("chambre est modifiée !");
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    } catch (IllegalArgumentException ex) {
        System.err.println(ex.getMessage());
    }
}

    @Override
    public void supprimer(Chambre c) {
        String req = "DELETE FROM chambre WHERE id_chambre="+c.getId_chambre();
        try {
            java.sql.Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("chambre supprimee !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Chambre> afficher() {
        List<Chambre> list = new ArrayList<>();
        
        try{
 String requete = "SELECT * FROM chambre";
  PreparedStatement pst = cnx.prepareStatement(requete);
  ResultSet rs = pst.executeQuery();

  while (rs.next()) {
    int id_chambre = rs.getInt("id_chambre");
    int nb_lit = rs.getInt("nombre_lit");
    String description = rs.getString("description");
    int numero_chambre = rs.getInt("numero_chambre");
    String categorie = rs.getString("categorie");
    Float prix = rs.getFloat("prix");
    String status_hebergement = rs.getString("status_hebergement");

               byte[] image = rs.getBytes("image");

   int id_hotel = rs.getInt("id_chambre");

    Chambre c = new Chambre(id_chambre,nb_lit,description,numero_chambre,categorie,prix,status_hebergement,image,id_hotel);
    list.add(c);
      System.out.println(list);
  }}
catch(SQLException ex){
        System.err.println(ex.getMessage());
        }



return list ;

          }
     public List<Chambre> AfficherAvecImage() throws SQLException {
    List<Chambre> listchambre = new ArrayList<>();
    String requete = "SELECT nombre_lit, description, prix, image FROM chambre ";
    PreparedStatement pst =cnx.prepareStatement(requete);
    try {
        ResultSet rs = pst.executeQuery();

        while(rs.next()){
            byte[] imageBytes = rs.getBytes("Image");
            Chambre c = new Chambre(rs.getInt("nombre_lit"), rs.getString("description"), rs.getFloat("prix"), imageBytes);
            listchambre.add(c);
        }
    } catch (SQLException ex) {
        Logger.getLogger(ServiceChambre.class.getName()).log(Level.SEVERE, null, ex);
    }
    System.out.println("liste chambre!");
    System.out.println(listchambre);
    return listchambre;
}
    }

