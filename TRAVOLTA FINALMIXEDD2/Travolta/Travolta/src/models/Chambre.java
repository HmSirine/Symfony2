/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.awt.image.BufferedImage;
import java.util.List;
import javafx.scene.control.TextField;

/**
 *
 * @author Ghassen Chamakh
 */
public class Chambre {
    private int id_chambre;
    private int nb_lit;
    private String description;
    private int nombre_chambre;
    private String categorie;
    private float prix;
    private String status_hebergement;
    private byte[] image;
    private int id_hotel;


    public Chambre() {
    }

    public Chambre(int id_chambre) {
        this.id_chambre = id_chambre;
    }

    public Chambre(int nb_lit, String description, int nombre_chambre, String categorie, float prix, String status_hebergement,byte[] image, int id_hotel) {
        this.nb_lit = nb_lit;
        this.description = description;
        this.nombre_chambre = nombre_chambre;
        this.categorie = categorie;
        this.prix = prix;
        this.status_hebergement = status_hebergement;
        this.image=image;
        this.id_hotel = id_hotel;
    }

    public Chambre(int id_chambre, int nb_lit, String description, int nombre_chambre, String categorie, float prix, String status_hebergement,byte[] image, int id_hotel) {
        this.id_chambre = id_chambre;
        this.nb_lit = nb_lit;
        this.description = description;
        this.nombre_chambre = nombre_chambre;
        this.categorie = categorie;
        this.prix = prix;
        this.status_hebergement = status_hebergement;
          this.image=image;
        this.id_hotel = id_hotel;
    }

    public Chambre(int nb_lit, String description, int nombre_chambre, String categorie, float prix, String status_hebergement, int id_hotel) {
        this.nb_lit = nb_lit;
        this.description = description;
        this.nombre_chambre = nombre_chambre;
        this.categorie = categorie;
        this.prix = prix;
        this.status_hebergement = status_hebergement;
        this.id_hotel = id_hotel;
    }

    public Chambre(int nb_lit, String description, float prix, byte[] image) {
        this.nb_lit = nb_lit;
        this.description = description;
        this.prix = prix;
        this.image = image;
    }

    

    public int getId_chambre() {
        return id_chambre;
    }

    public void setId_chambre(int id_chambre) {
        this.id_chambre = id_chambre;
    }

    public int getNb_lit() {
        return nb_lit;
    }

    public void setNb_lit(int nb_lit) {
        this.nb_lit = nb_lit;
    }

    public String getDescription() {
        return description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNombre_chambre() {
        return nombre_chambre;
    }

    public void setNombre_chambre(int nombre_chambre) {
        this.nombre_chambre = nombre_chambre;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getStatus_hebergement() {
        return status_hebergement;
    }

    public void setStatus_hebergement(String status_hebergement) {
        this.status_hebergement = status_hebergement;
    }

    public int getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.id_chambre;
        hash = 79 * hash + this.nombre_chambre;
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
        final Chambre other = (Chambre) obj;
        if (this.id_chambre != other.id_chambre) {
            return false;
        }
        return this.nombre_chambre == other.nombre_chambre;
    }

    @Override
    public String toString() {
        return "Chambre{" + "id_chambre=" + id_chambre + ", nb_lit=" + nb_lit + ", description=" + description + ", nombre_chambre=" + nombre_chambre + ", categorie=" + categorie + ", prix=" + prix + ", status_hebergement=" + status_hebergement + ", image=" + image + ", id_hotel=" + id_hotel + '}';
    }

   

 
    

   
    

}
