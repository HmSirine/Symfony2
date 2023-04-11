/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;




/**
 *
 * @author mr.rhimi
 */
public class Reservation {

    public Reservation() {
    }
    
    private int reservation_id;
    private String Checkin;
    private String Checkout;
    private String Adresse;
    private float price;
    private int dure_sejour;
    private int status ;

    public int getReservation_id() {
        return reservation_id;
    }

    public Reservation(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public String getCheckin() {
        return Checkin;
    }

    public void setCheckin(String Checkin) {
        this.Checkin = Checkin;
    }

    public String getCheckout() {
        return Checkout;
    }

    public void setCheckout(String Checkout) {
        this.Checkout = Checkout;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getDure_sejour() {
        return dure_sejour;
    }

    public void setDure_sejour(int dure_sejour) {
        this.dure_sejour = dure_sejour;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    

  
    public Reservation(int reservation_id, float price, String Adresse, String Checkin, String Checkout,  int dure_sejour, int status) {
        this.reservation_id = reservation_id;
        this.Checkin = Checkin;
        this.Checkout = Checkout;
        this.Adresse = Adresse;
        this.price = price;
        this.dure_sejour = dure_sejour;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reservation{" + "reservation_id=" + reservation_id + ", Checkin=" + Checkin + ", Checkout=" + Checkout + ", Adresse=" + Adresse + ", price=" + price + ", dure_sejour=" + dure_sejour + ", status=" + status + '}';
    }

 

    
    
}
