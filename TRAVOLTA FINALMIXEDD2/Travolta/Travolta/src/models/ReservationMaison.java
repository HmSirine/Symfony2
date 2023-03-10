/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Ghassen Chamakh
 */
public class ReservationMaison {
    private int id_reservation;
    private LocalDate date_arrivee;
    private LocalDate date_depart;
    private String nom;
    private String prenom;
    private String email;
    private float tarif;
    private int id_maison;
    private int user_id;

    public ReservationMaison(int id_reseravation) {
        this.id_reservation = id_reseravation;
    }

    public ReservationMaison(int id_reservation, LocalDate date_arrivee, LocalDate date_depart, String nom, String prenom, String email, float tarif, int id_maison, int user_id) {
        this.id_reservation = id_reservation;
        this.date_arrivee = date_arrivee;
        this.date_depart = date_depart;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tarif = tarif;
        this.id_maison = id_maison;
        this.user_id = user_id;
    }

    public ReservationMaison(LocalDate date_arrivee, LocalDate date_depart, String nom, String prenom, String email, float tarif, int id_maison, int user_id) {
        this.date_arrivee = date_arrivee;
        this.date_depart = date_depart;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tarif = tarif;
        this.id_maison = id_maison;
        this.user_id = user_id;
    }

   

    public int getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }

    public LocalDate getDate_arrivee() {
        return date_arrivee;
    }

    public void setDate_arrivee(LocalDate date_arrivee) {
        this.date_arrivee = date_arrivee;
    }

    public LocalDate getDate_depart() {
        return date_depart;
    }

    public void setDate_depart(LocalDate date_depart) {
        this.date_depart = date_depart;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getTarif() {
        return tarif;
    }

    public void setTarif(float tarif) {
        this.tarif = tarif;
    }

    public int getId_maison() {
        return id_maison;
    }

    public void setId_maison(int id_maison) {
        this.id_maison = id_maison;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id_reservation;
        hash = 53 * hash + Objects.hashCode(this.date_arrivee);
        hash = 53 * hash + Objects.hashCode(this.date_depart);
        hash = 53 * hash + Objects.hashCode(this.nom);
        hash = 53 * hash + Objects.hashCode(this.prenom);
        hash = 53 * hash + Objects.hashCode(this.email);
        hash = 53 * hash + Float.floatToIntBits(this.tarif);
        hash = 53 * hash + this.id_maison;
        hash = 53 * hash + this.user_id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ReservationMaison other = (ReservationMaison) obj;
        if (this.id_reservation != other.id_reservation) {
            return false;
        }
        if (Float.floatToIntBits(this.tarif) != Float.floatToIntBits(other.tarif)) {
            return false;
        }
        if (this.id_maison != other.id_maison) {
            return false;
        }
        if (this.user_id != other.user_id) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.date_arrivee, other.date_arrivee)) {
            return false;
        }
        return Objects.equals(this.date_depart, other.date_depart);
    }

    @Override
    public String toString() {
        return "ReservationMaison{" + "id_reservation=" + id_reservation + ", date_arrivee=" + date_arrivee + ", date_depart=" + date_depart + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", tarif=" + tarif + ", id_maison=" + id_maison + ", user_id=" + user_id + '}';
    }

    
    
    
}
