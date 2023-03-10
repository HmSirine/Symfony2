/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.awt.image.BufferedImage;
import java.util.Objects;

/**
 *
 * @author Ghassen Chamakh
 */
public class Hotel {
     private int id_hotel;
    private String titre;
    private String description;
    private String adresse;
    private int etoile;
    private byte[] image;

    public Hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }

    public Hotel(String titre, String description, String adresse, int etoile) {
        this.titre = titre;
        this.description = description;
        this.adresse = adresse;
        this.etoile = etoile;
    }

    public Hotel(String titre, String description, String adresse, int etoile,byte[] image) {
        this.titre = titre;
        this.description = description;
        this.adresse = adresse;
        this.etoile = etoile;
        this.image=image;
    }

    public Hotel(int id_hotel, String titre, String description, String adresse, int etoile,byte[]image) {
        this.id_hotel = id_hotel;
        this.titre = titre;
        this.description = description;
        this.adresse = adresse;
        this.etoile = etoile;
        this.image=image;
    }

    public int getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getEtoile() {
        return etoile;
    }

    public void setEtoile(int etoile) {
        this.etoile = etoile;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id_hotel;
        hash = 29 * hash + Objects.hashCode(this.titre);
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
        final Hotel other = (Hotel) obj;
        if (this.id_hotel != other.id_hotel) {
            return false;
        }
        return Objects.equals(this.titre, other.titre);
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Hotel{" + "id_hotel=" + id_hotel + ", titre=" + titre + ", description=" + description + ", adresse=" + adresse + ", etoile=" + etoile + '}';
    }
    

}
