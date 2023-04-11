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
public class Reservation_Evenement {
    private int id_reservation_evenement;
    private String nom,prenom,mail,tel,heure_arriver;

    public Reservation_Evenement(int id_reservation_evenement) {
        this.id_reservation_evenement = id_reservation_evenement;
    }

    public Reservation_Evenement(String nom, String prenom, String mail, String tel, String heure_arriver) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.tel = tel;
        this.heure_arriver = heure_arriver;
    }

    public Reservation_Evenement(int id_reservation_evenement, String nom, String prenom, String mail, String tel, String heure_arriver) {
        this.id_reservation_evenement = id_reservation_evenement;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.tel = tel;
        this.heure_arriver = heure_arriver;
    }

   

    public int getId_reservation_evenement() {
        return id_reservation_evenement;
    }

    public void setId_reservation_evenement(int id_reservation_evenement) {
        this.id_reservation_evenement = id_reservation_evenement;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getHeure_arriver() {
        return heure_arriver;
    }

    public void setHeure_arriver(String heure_arriver) {
        this.heure_arriver = heure_arriver;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.nom);
        hash = 41 * hash + Objects.hashCode(this.prenom);
        hash = 41 * hash + Objects.hashCode(this.mail);
        hash = 41 * hash + Objects.hashCode(this.tel);
        hash = 41 * hash + Objects.hashCode(this.heure_arriver);
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
        final Reservation_Evenement other = (Reservation_Evenement) obj;
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        if (!Objects.equals(this.mail, other.mail)) {
            return false;
        }
        if (!Objects.equals(this.tel, other.tel)) {
            return false;
        }
        return Objects.equals(this.heure_arriver, other.heure_arriver);
    }

    @Override
    public String toString() {
        return "Reservation_Evenement{" + "id_reservation_evenement=" + id_reservation_evenement + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", tel=" + tel + ", heure_arriver=" + heure_arriver + '}';
    }
    
    
}
