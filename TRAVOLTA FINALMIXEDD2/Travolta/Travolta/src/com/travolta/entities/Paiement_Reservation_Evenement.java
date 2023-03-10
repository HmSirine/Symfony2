/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travolta.entities;
import java.util.Objects;
/**
 *
 * @author aghx0
 */
public class Paiement_Reservation_Evenement {
    private int id_paiement_reservation_evenement ,id_evenement,id_reservation;
    private float prix;
    private String description;

    public Paiement_Reservation_Evenement(int id_paiement_reservation_evenement) {
        this.id_paiement_reservation_evenement = id_paiement_reservation_evenement;
    }

    public Paiement_Reservation_Evenement(int id_evenement, int id_reservation, float prix, String description) {
        this.id_evenement = id_evenement;
        this.id_reservation = id_reservation;
        this.prix = prix;
        this.description = description;
    }

    public Paiement_Reservation_Evenement(int id_paiement_reservation_evenement, int id_evenement, int id_reservation, float prix, String description) {
        this.id_paiement_reservation_evenement = id_paiement_reservation_evenement;
        this.id_evenement = id_evenement;
        this.id_reservation = id_reservation;
        this.prix = prix;
        this.description = description;
    }

    public int getId_paiement_reservation_evenement() {
        return id_paiement_reservation_evenement;
    }

    public void setId_paiement_reservation_evenement(int id_paiement_reservation_evenement) {
        this.id_paiement_reservation_evenement = id_paiement_reservation_evenement;
    }

    public Paiement_Reservation_Evenement(float prix, String description) {
        this.prix = prix;
        this.description = description;
    }

    public int getId_evenement() {
        return id_evenement;
    }

    public void setId_evenement(int id_evenement) {
        this.id_evenement = id_evenement;
    }

    public int getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.id_evenement;
        hash = 37 * hash + this.id_reservation;
        hash = 37 * hash + Float.floatToIntBits(this.prix);
        hash = 37 * hash + Objects.hashCode(this.description);
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
        final Paiement_Reservation_Evenement other = (Paiement_Reservation_Evenement) obj;
        if (this.id_evenement != other.id_evenement) {
            return false;
        }
        if (this.id_reservation != other.id_reservation) {
            return false;
        }
        if (Float.floatToIntBits(this.prix) != Float.floatToIntBits(other.prix)) {
            return false;
        }
        return Objects.equals(this.description, other.description);
    }

    @Override
    public String toString() {
        return "Paiement_Reservation_Evenement{" + "id_paiement_reservation_evenement=" + id_paiement_reservation_evenement + ", id_evenement=" + id_evenement + ", id_reservation=" + id_reservation + ", prix=" + prix + ", description=" + description + '}';
    }

   
}
