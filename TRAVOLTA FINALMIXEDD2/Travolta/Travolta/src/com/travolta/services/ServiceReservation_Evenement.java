/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travolta.services;

import com.travolta.entities.Evenement;
import com.travolta.entities.Reservation_Evenement;
import com.travolta.utils.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aghx0
 */
public class ServiceReservation_Evenement implements IService<Reservation_Evenement> {
    
    private Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(Reservation_Evenement re) {
        String req = "INSERT INTO reservation_evenement(nom, prenom, mail, tel, heure_arriver) VALUES('"+re.getNom()+"', '"+re.getPrenom()+"', '"+re.getMail()+"','"+re.getTel()+"','"+re.getHeure_arriver()+"');";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Reservation Evenement ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Reservation_Evenement re) {
        String req = "UPDATE  reservation_evenement SET nom='"+re.getNom()+"', prenom= '"+re.getPrenom()+"', mail= '"+re.getMail()+"', tel= '"+re.getTel()+"', heure_arriver= '"+re.getHeure_arriver()+"' WHERE id_reservation="+re.getId_reservation_evenement()+"";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("reservation Evenement modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Reservation_Evenement re) {
        String req = "DELETE FROM reservation_evenement WHERE id_reservation="+re.getId_reservation_evenement();
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("reservation Evenement supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Reservation_Evenement> afficher() {
        List<Reservation_Evenement> list = new ArrayList<>();
        
        String req = "SELECT * FROM reservation_evenement";
        try {
            Statement st = cnx.createStatement();
            ResultSet result = st.executeQuery(req);
            while(result.next()) {
                list.add(new Reservation_Evenement(result.getInt("id_reservation"), result.getString("nom"), result.getString("prenom"), result.getString("mail"), result.getString("tel"), result.getString("heure_arriver")));
                
            }
            System.out.println("reservation Evenement récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
}
