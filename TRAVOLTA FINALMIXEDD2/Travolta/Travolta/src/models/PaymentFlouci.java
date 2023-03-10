/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author mr.rhimi
 */
public class PaymentFlouci {
 private int payment_id;
 private int location_id;
 private int client_id;
 private float montant;
 private String transaction_id;
 int Payment_status ;

    public int getPayment_id() {
        return payment_id;
    }

    public PaymentFlouci(int payment_id, int location_id, int client_id, float montant, String transaction_id, int Payment_status) {
        this.payment_id = payment_id;
        this.location_id = location_id;
        this.client_id = client_id;
        this.montant = montant;
        this.transaction_id = transaction_id;
        this.Payment_status = Payment_status;
    }

    public PaymentFlouci(int location_id, int client_id, float montant, String transaction_id, int Payment_status) {
        this.location_id = location_id;
        this.client_id = client_id;
        this.montant = montant;
        this.transaction_id = transaction_id;
        this.Payment_status = Payment_status;
    }

    @Override
    public String toString() {
        return "PaymentFlouci{" + "payment_id=" + payment_id + ", location_id=" + location_id + ", client_id=" + client_id + ", montant=" + montant + ", transaction_id=" + transaction_id + ", Payment_status=" + Payment_status + '}';
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public int getPayment_status() {
        return Payment_status;
    }

    public void setPayment_status(int Payment_status) {
        this.Payment_status = Payment_status;
    }
  
 
}
