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
public class ReponseReclamation {
    private int id_reponse,id_reclamation;
    private String reponse;

    public ReponseReclamation(int id_reponse) {
        this.id_reponse = id_reponse;
    }

    public ReponseReclamation(String reponse) {
        this.reponse = reponse;
    }

    public ReponseReclamation(int id_reclamation, String reponse) {
        this.id_reclamation = id_reclamation;
        this.reponse = reponse;
    }

    public ReponseReclamation(int id_reponse, int id_reclamation, String reponse) {
        this.id_reponse = id_reponse;
        this.id_reclamation = id_reclamation;
        this.reponse = reponse;
    }

    public int getId_reponse() {
        return id_reponse;
    }

    public void setId_reponse(int id_reponse) {
        this.id_reponse = id_reponse;
    }

    public int getId_reclamation() {
        return id_reclamation;
    }

    public void setId_reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.id_reclamation;
        hash = 47 * hash + Objects.hashCode(this.reponse);
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
        final ReponseReclamation other = (ReponseReclamation) obj;
        if (this.id_reclamation != other.id_reclamation) {
            return false;
        }
        return Objects.equals(this.reponse, other.reponse);
    }

    @Override
    public String toString() {
        return "ReponseReclamation{" + "id_reponse=" + id_reponse + ", id_reclamation=" + id_reclamation + ", reponse=" + reponse + '}';
    }
    
    
}
