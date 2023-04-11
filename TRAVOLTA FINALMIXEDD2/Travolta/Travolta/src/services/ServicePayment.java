/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import models.PaymentFlouci;
import utils.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mr.rhimi
 */
public class ServicePayment implements IPayment<PaymentFlouci> {
private Connection cnx = DataSource.getInstance().getCnx();
    @Override
    public void ajouter(PaymentFlouci r) {
      String req = "INSERT INTO paymentflouci ( location_id, client_id,montant,transaction_id,Payment_status) VALUES('"+r.getLocation_id()+"','"+r.getClient_id()+"','"+r.getMontant()+"','"+r.getTransaction_id()+"','"+r.getPayment_status()+"')";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Payment ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(PaymentFlouci r) {
          String req = "UPDATE  paymentflouci SET location_id='"+r.getLocation_id()+"', client_id= '"+r.getClient_id()+"',montant='"+r.getMontant()+"',transaction_id='"+r.getTransaction_id()+"',Payment_status='"+r.getPayment_status()+"' WHERE payment_id="+r.getPayment_id()+"";
       try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("payment modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<PaymentFlouci> afficher() {
        List<PaymentFlouci> list = new ArrayList<>();
           String req = "SELECT * FROM paymentflouci";
            
    try {
            Statement st = cnx.createStatement();
            ResultSet result = st.executeQuery(req);
            while(result.next()) {
                list.add(new PaymentFlouci(result.getInt("payment_id"),result.getInt("location_id"),result.getInt("client_id"),result.getFloat("montant"),result.getString("transaction_id"),result.getInt("Payment_status") ));
            }
            System.out.println("Payment récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
    
}
