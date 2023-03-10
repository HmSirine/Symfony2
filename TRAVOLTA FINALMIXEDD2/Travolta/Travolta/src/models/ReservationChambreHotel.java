/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Ghassen Chamakh
 */
public class ReservationChambreHotel {
     private int id_reservation;
    private LocalDate date_arrivee;
    private LocalDate date_depart;
    private int nombre_chambre;
    private String nom;
    private String prenom;
    private String email;
    private float tarif;
    private int id_chambre;
    private int id_user;
   

    public ReservationChambreHotel(int id_reservation) {
        this.id_reservation = id_reservation;
    }

    public ReservationChambreHotel(int id_reservation, LocalDate date_arrivee, LocalDate date_depart, int nombre_chambre, String nom, String prenom, String email, float tarif, int id_chambre, int id_user) {
        this.id_reservation = id_reservation;
        this.date_arrivee = date_arrivee;
        this.date_depart = date_depart;
        this.nombre_chambre = nombre_chambre;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tarif = tarif;
        this.id_chambre = id_chambre;
        this.id_user = id_user;
    }

    public ReservationChambreHotel(LocalDate date_arrivee, LocalDate date_depart, int nombre_chambre, String nom, String prenom, String email, float tarif, int id_chambre, int id_user) {
        this.date_arrivee = date_arrivee;
        this.date_depart = date_depart;
        this.nombre_chambre = nombre_chambre;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tarif = tarif;
        this.id_chambre = id_chambre;
        this.id_user = id_user;
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

    public int getNombre_chambre() {
        return nombre_chambre;
    }

    public void setNombre_chambre(int nombre_chambre) {
        this.nombre_chambre = nombre_chambre;
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

    public int getId_chambre() {
        return id_chambre;
    }

    public void setId_chambre(int id_chambre) {
        this.id_chambre = id_chambre;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.id_reservation;
        hash = 37 * hash + Objects.hashCode(this.date_arrivee);
        hash = 37 * hash + Objects.hashCode(this.date_depart);
        hash = 37 * hash + this.nombre_chambre;
        hash = 37 * hash + Objects.hashCode(this.nom);
        hash = 37 * hash + Objects.hashCode(this.prenom);
        hash = 37 * hash + Objects.hashCode(this.email);
        hash = 37 * hash + Float.floatToIntBits(this.tarif);
       
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
        final ReservationChambreHotel other = (ReservationChambreHotel) obj;
        if (this.id_reservation != other.id_reservation) {
            return false;
        }
        if (this.nombre_chambre != other.nombre_chambre) {
            return false;
        }
        if (Float.floatToIntBits(this.tarif) != Float.floatToIntBits(other.tarif)) {
            return false;
        }
       
   
        if (!Objects.equals(this.date_arrivee, other.date_arrivee)) {
            return false;
        }
        return Objects.equals(this.date_depart, other.date_depart);
    }

    @Override
    public String toString() {
        return "ReservationChambreHotel{" + "id_reservation=" + id_reservation + ", date_arrivee=" + date_arrivee + ", date_depart=" + date_depart + ", nombre_chambre=" + nombre_chambre + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", tarif=" + tarif + ", id_chambre=" + id_chambre + ", id_user=" + id_user + '}';
    }

    
}
