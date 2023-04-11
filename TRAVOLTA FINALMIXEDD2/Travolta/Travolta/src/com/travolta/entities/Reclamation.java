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
public class Reclamation {
    private int id_reclamation,id_evenement;
    private String mail,description;

    public Reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

    public Reclamation(String mail, String description) {
        this.mail = mail;
        this.description = description;
    }
    

    public Reclamation(int id_evenement, String mail, String description) {
        this.id_evenement = id_evenement;
        this.mail = mail;
        this.description = description;
    }

    public Reclamation(int id_reclamation, int id_evenement, String mail, String description) {
        this.id_reclamation = id_reclamation;
        this.id_evenement = id_evenement;
        this.mail = mail;
        this.description = description;
    }

    public int getId_reclamation() {
        return id_reclamation;
    }

    public void setId_reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

    public int getId_evenement() {
        return id_evenement;
    }

    public void setId_evenement(int id_evenement) {
        this.id_evenement = id_evenement;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id_evenement;
        hash = 53 * hash + Objects.hashCode(this.mail);
        hash = 53 * hash + Objects.hashCode(this.description);
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
        final Reclamation other = (Reclamation) obj;
        if (this.id_evenement != other.id_evenement) {
            return false;
        }
        if (!Objects.equals(this.mail, other.mail)) {
            return false;
        }
        return Objects.equals(this.description, other.description);
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id_reclamation=" + id_reclamation + ", id_evenement=" + id_evenement + ", mail=" + mail + ", description=" + description + '}';
    }
    
    
}
