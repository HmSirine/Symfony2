/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import models.ClientDhaker;
import models.Vehicule;
import utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mr.rhimi
 */
public class ServiceClient implements IClient<ClientDhaker>{
  private Connection cnx = DataSource.getInstance().getCnx();
    @Override
    public String findUserNamebyId(int userID) {
      String userName = null;

        try {
            String sql = "SELECT client_nom FROM client WHERE client_id = ?";
            PreparedStatement stmt = cnx.prepareStatement(sql);
            stmt.setInt(1, userID );

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                userName = rs.getString("client_nom");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return userName;
    }

    @Override
    public List<ClientDhaker> afficherNom(int id) {
           List<ClientDhaker> lists = new ArrayList<>();
           String req = "SELECT * FROM client WHERE client_id='"+id+"'";
            
    try {
            Statement st = cnx.createStatement();
        
            ResultSet result = st.executeQuery(req);
           
            while(result.next()) {
                lists.add(new ClientDhaker( result.getInt("client_id"),result.getString("client_nom") ) );
            }
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return lists;
    }

    }
    

