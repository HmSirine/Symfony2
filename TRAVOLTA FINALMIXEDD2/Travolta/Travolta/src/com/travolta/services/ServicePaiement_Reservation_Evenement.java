/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travolta.services;

import com.travolta.entities.Paiement_Reservation_Evenement;
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
public class ServicePaiement_Reservation_Evenement implements IService<Paiement_Reservation_Evenement> {
    
    private Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(Paiement_Reservation_Evenement p) {
        String req = "INSERT INTO paiement_reservation_evenement(id_paiement_reservation_evenement,id_evenement,id_reservation,prix, description) VALUES('"+p.getId_paiement_reservation_evenement()+"','"+p.getId_evenement()+"', '"+p.getId_reservation()+"', '"+p.getPrix()+"','"+p.getDescription()+"');";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Paiement Reservation Evenement ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Paiement_Reservation_Evenement p) {
        String req = "UPDATE  paiement_reservation_evenement SET id_evenement= '"+p.getId_evenement()+"', id_reservation= '"+p.getId_reservation()+"', prix= '"+p.getPrix()+"', description= '"+p.getDescription()+"' WHERE id_paiement_reservation_evenement="+p.getId_paiement_reservation_evenement()+"";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("paiement reservation Evenement modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Paiement_Reservation_Evenement p) {
        String req = "DELETE FROM paiement_reservation_evenement WHERE id_paiement_reservation_evenement="+p.getId_paiement_reservation_evenement();
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("paiement reservation Evenement supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Paiement_Reservation_Evenement> afficher() {
        List<Paiement_Reservation_Evenement> list = new ArrayList<>();
        
        String req = "SELECT * FROM paiement_reservation_evenement";
        try {
            Statement st = cnx.createStatement();
            ResultSet result = st.executeQuery(req);
            while(result.next()) {
                list.add(new Paiement_Reservation_Evenement(result.getInt("id_paiement_reservation_evenement"), result.getInt("id_evenement"), result.getInt("id_reservation"), result.getFloat("prix"), result.getString("description")));
                
            }
            System.out.println("paiement reservation Evenement récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
}

