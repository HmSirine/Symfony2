/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travolta.entities;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author abdel
 */
public class Evenement {
    
    private int id_evenement ;
    private String lieu ,titre  ;
    private int nbreplaces,nbreparticipants ;
    private LocalDate DateDebut,DateFin;
    private String  image;

    public Evenement(int id_evenement) {
        this.id_evenement = id_evenement;
    }

    public Evenement(String lieu, String titre, int nbreplaces, int nbreparticipants, LocalDate DateDebut, LocalDate DateFin, String image) {
        this.lieu = lieu;
        this.titre = titre;
        this.nbreplaces = nbreplaces;
        this.nbreparticipants = nbreparticipants;
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
        this.image = image;
    }

    public Evenement(int id_evenement, String lieu, String titre, int nbreplaces, int nbreparticipants, LocalDate DateDebut, LocalDate DateFin, String image) {
        this.id_evenement = id_evenement;
        this.lieu = lieu;
        this.titre = titre;
        this.nbreplaces = nbreplaces;
        this.nbreparticipants = nbreparticipants;
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
        this.image = image;
    }

    public int getId_evenement() {
        return id_evenement;
    }

    public void setId_evenement(int id_evenement) {
        this.id_evenement = id_evenement;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getNbreplaces() {
        return nbreplaces;
    }

    public void setNbreplaces(int nbreplaces) {
        this.nbreplaces = nbreplaces;
    }

    public int getNbreparticipants() {
        return nbreparticipants;
    }

    public void setNbreparticipants(int nbreparticipants) {
        this.nbreparticipants = nbreparticipants;
    }

    public LocalDate getDateDebut() {
        return DateDebut;
    }

    public void setDateDebut(LocalDate DateDebut) {
        this.DateDebut = DateDebut;
    }

    public LocalDate getDateFin() {
        return DateFin;
    }

    public void setDateFin(LocalDate DateFin) {
        this.DateFin = DateFin;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.lieu);
        hash = 83 * hash + Objects.hashCode(this.titre);
        hash = 83 * hash + this.nbreplaces;
        hash = 83 * hash + this.nbreparticipants;
        hash = 83 * hash + Objects.hashCode(this.DateDebut);
        hash = 83 * hash + Objects.hashCode(this.DateFin);
        hash = 83 * hash + Objects.hashCode(this.image);
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
        final Evenement other = (Evenement) obj;
        if (this.nbreplaces != other.nbreplaces) {
            return false;
        }
        if (this.nbreparticipants != other.nbreparticipants) {
            return false;
        }
        if (!Objects.equals(this.lieu, other.lieu)) {
            return false;
        }
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        if (!Objects.equals(this.DateDebut, other.DateDebut)) {
            return false;
        }
        return Objects.equals(this.DateFin, other.DateFin);
    }

    @Override
    public String toString() {
        return "Evenement{" + "id_evenement=" + id_evenement + ", lieu=" + lieu + ", titre=" + titre + ", nbreplaces=" + nbreplaces + ", nbreparticipants=" + nbreparticipants + ", DateDebut=" + DateDebut + ", DateFin=" + DateFin + ", image=" + image + '}';
    }


    
}
