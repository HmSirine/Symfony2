/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import models.Maison;
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
public class ServiceMaison implements IService1<Maison> {
    
    private Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(Maison m) {
             try {
                    String req = "INSERT INTO maison_hote(titre,prix,description,adresse,status_hebergement,nombre_chambre,image) VALUES(?,?,?,?,?,?,?)";
            
                    java.sql.PreparedStatement pst = cnx.prepareStatement(req);

        pst.setString(1, m.getTitre());
         pst.setFloat(2, m.getPrix());
        pst.setString(3, m.getDescription());
        pst.setString(4, m.getAdresse());
        pst.setString(5, m.getStatus_hebergement());
       pst.setInt(6, m.getChambre());
       
       pst.setBytes(7, m.getImage());
       
        

            pst.executeUpdate();
            System.out.println("Maison ajoutee !");
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Maison m) {
         try {
        if (m.getImage() == null) {
            throw new IllegalArgumentException("L'image  est null !");
        }

        String requete = "UPDATE maison_hote SET titre=?,prix=?,description=?,adresse=?,status_hebergement=?,nombre_chambre=? WHERE id_maison=?";
        PreparedStatement pst = cnx.prepareStatement(requete);

        
        pst.setString(1, m.getTitre());
         pst.setFloat(2, m.getPrix());
        pst.setString(3, m.getDescription());
        pst.setString(4, m.getAdresse());
        pst.setString(5, m.getStatus_hebergement());
       pst.setInt(6, m.getChambre());
       
       
        

            pst.executeUpdate();
            

        System.out.println("chambre est modifiée !");
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    } catch (IllegalArgumentException ex) {
        System.err.println(ex.getMessage());
    }
    }

    @Override
    public void supprimer(Maison m) {
        String req = "DELETE FROM maison_hote WHERE id_maison="+m.getId_maison();
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("maison d'hote supprimee !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

 
    public List<Maison> afficher() {
        List<Maison> list = new ArrayList<>();
        
        try{
 String requete = "SELECT * FROM maison_hote";
  PreparedStatement pst = cnx.prepareStatement(requete);
  ResultSet rs = pst.executeQuery();

  while (rs.next()) {
    int id_maison = rs.getInt("id_maison");
    String titre = rs.getString("titre");
    Float prix= rs.getFloat("prix");
    String description = rs.getString("description");
    String adresse = rs.getString("adresse");
    String status = rs.getString("status_hebergement");
    int nbchambre = rs.getInt("nombre_chambre");
   

                   byte[] image = rs.getBytes("image");

  

    Maison m = new Maison(id_maison,titre,prix,description,adresse,status,nbchambre,image);
    list.add(m);
      System.out.println(list);
  }}
catch(SQLException ex){
        System.err.println(ex.getMessage());
        }
return list ;

    }
     public List<Maison> AfficherAvecImage() throws SQLException {
    List<Maison> listMaison = new ArrayList<>();
    String requete = "SELECT titre, description,prix,adresse,status_hebergement,nombre_chambre, image FROM maison_hote ";
    PreparedStatement pst =cnx.prepareStatement(requete);
    try {
        ResultSet rs = pst.executeQuery();

        while(rs.next()){
            byte[] imageBytes = rs.getBytes("Image");
            Maison m = new Maison(rs.getString("titre"),rs.getFloat("prix"),rs.getString("description"), rs.getString("adresse"),rs.getString("status_hebergement"),rs.getInt("nombre_chambre"),  imageBytes);
            listMaison.add(m);
        }
    } catch (SQLException ex) {
        Logger.getLogger(ServiceChambre.class.getName()).log(Level.SEVERE, null, ex);
    }
    System.out.println("liste maisons!");
    System.out.println(listMaison);
    return listMaison;
}
}

