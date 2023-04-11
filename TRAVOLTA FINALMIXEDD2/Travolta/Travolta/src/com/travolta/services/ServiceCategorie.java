/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travolta.services;

import com.travolta.entities.Categorie;
import com.travolta.utils.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abdel
 */
public class ServiceCategorie implements IService<Categorie> {
    
    private Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(Categorie c) {
        String req = "INSERT INTO categorie (type) VALUES('"+c.getType()+"');";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Categorie ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Categorie c) {
        String req = "UPDATE  categorie SET type='"+c.getType()+"' WHERE id_categorie="+c.getId_categorie()+"";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Categorie modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Categorie c) {
        String req = "DELETE FROM categorie WHERE id_categorie="+c.getId_categorie();
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Categorie supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Categorie> afficher() {
        List<Categorie> list = new ArrayList<>();
        
        String req = "SELECT * FROM categorie";
        try {
            Statement st = cnx.createStatement();
            ResultSet result = st.executeQuery(req);
            while(result.next()) {
                list.add(new Categorie(result.getInt("id_categorie"), result.getString("type")));
                
            }
            System.out.println("Categorie récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
}
