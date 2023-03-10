/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travolta.services;

import com.travolta.entities.Evenement;
import com.travolta.utils.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.internal.objects.Global.getDate;

/**
 *
 * @author abdel
 */
public class ServiceEvenement implements IService<Evenement> {
    
    private Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(Evenement e) {
        String req = "INSERT INTO evenement(lieu, titre, nbreplaces, nbreparticipants, datedebut, datefin, image) VALUES('"+e.getLieu()+"', '"+e.getTitre()+"', '"+e.getNbreplaces()+"','"+e.getNbreparticipants()+"','"+e.getDateDebut()+"','"+e.getDateFin()+"','"+e.getImage()+"');";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Evenement ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Evenement e) {
        String req = "UPDATE  evenement SET lieu='"+e.getLieu()+"', titre= '"+e.getTitre()+"', nbreplaces= '"+e.getNbreplaces()+"', nbreparticipants= '"+e.getNbreparticipants()+"', datedebut= '"+e.getDateDebut()+"', datefin= '"+e.getDateFin()+"', image= '"+e.getImage()+"' WHERE id_evenement="+e.getId_evenement()+"";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Evenement modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Evenement e) {
        String req = "DELETE FROM evenement WHERE id_evenement="+e.getId_evenement();
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Evenement supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Evenement> afficher() {
        List<Evenement> list = new ArrayList<>();
        
        String req = "SELECT * FROM evenement";

        try {
            Statement st = cnx.createStatement();
            ResultSet result = st.executeQuery(req);

            while(result.next()) {
                        java.sql.Date DateDebut = result.getDate("DateDebut") ;
                  LocalDate LocalDateDebut= DateDebut.toLocalDate();
                 java.sql.Date DateFin = result.getDate("DateFin") ;
                  LocalDate LocalDateFin = DateFin.toLocalDate();
               list.add(new Evenement(result.getInt("id_evenement"), result.getString("lieu"), result.getString("titre"), result.getInt("nbreplaces"), result.getInt("nbreparticipants"),LocalDateDebut,LocalDateFin, result.getString("image")));

            }
            System.out.println("Evenement récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
}
