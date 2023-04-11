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
public class Rating {
    private int id_rating;
    private int id_evenement;
    private String etat;

    public Rating(int id_rating) {
        this.id_rating = id_rating;
    }

    public Rating(int id_evenement, String etat) {
        this.id_evenement = id_evenement;
        this.etat = etat;
    }

    public Rating(int id_rating, int id_evenement, String etat) {
        this.id_rating = id_rating;
        this.id_evenement = id_evenement;
        this.etat = etat;
    }

    public int getId_rating() {
        return id_rating;
    }

    public void setId_rating(int id_rating) {
        this.id_rating = id_rating;
    }

    public int getId_evenement() {
        return id_evenement;
    }

    public void setId_evenement(int id_evenement) {
        this.id_evenement = id_evenement;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.id_evenement;
        hash = 53 * hash + Objects.hashCode(this.etat);
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
        final Rating other = (Rating) obj;
        if (this.id_evenement != other.id_evenement) {
            return false;
        }
        return Objects.equals(this.etat, other.etat);
    }

    @Override
    public String toString() {
        return "Rating{" + "id_rating=" + id_rating + ", id_evenement=" + id_evenement + ", etat=" + etat + '}';
    }

   
   
    
    
}
