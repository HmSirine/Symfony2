/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDate;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class ReservationExcursion {
    private int  IdReservation ; 
   private int IdClient ; 
   private LocalDate  DateReservation ; 
   private  float PrixTotal ;

   
    public ReservationExcursion(int IdReservation, int IdClient, LocalDate DateReservation, float PrixTotal) {
        this.IdReservation = IdReservation;
        this.IdClient = IdClient;
        this.DateReservation = DateReservation;
        this.PrixTotal = PrixTotal;
    }

    public ReservationExcursion(int IdClient, LocalDate DateReservation, float PrixTotal) {
        this.IdClient = IdClient;
        this.DateReservation = LocalDate.now();
        this.PrixTotal = PrixTotal;
    }

    public int getIdReservation() {
        return IdReservation;
    }

    public int getIdClient() {
        return IdClient;
    }

    public LocalDate getDateReservation() {
        return DateReservation;
    }

    public float getPrixTotal() {
        return PrixTotal;
    }

    public void setIdReservation(int IdReservation) {
        this.IdReservation = IdReservation;
    }

    public void setIdClient(int IdClient) {
        this.IdClient = IdClient;
    }

    public void setDateReservation(LocalDate DateReservation) {
        this.DateReservation = DateReservation;
    }

    public void setPrixTotal(float PrixTotal) {
        this.PrixTotal = PrixTotal;
    }

    @Override
    public String toString() {
        return "ReservationExcursion{" + "IdReservation=" + IdReservation + ", IdClient=" + IdClient + ", DateReservation=" + DateReservation + ", PrixTotal=" + PrixTotal + '}';
    }
   
    
   
}
