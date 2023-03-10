/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Objects;

/**
 *
 * @author Ghassen Chamakh
 */
public class Maison {
    private int id_maison;
    private String titre;
    private float prix;
    private String description;
    private String adresse;
    private String status_hebergement;
    private int chambre ;
    private byte[] image;

    public Maison(int id_maison) {
        this.id_maison = id_maison;
    }

    public Maison(String titre, float prix, String description, String adresse, String status_hebergement, int chambre) {
        this.titre = titre;
        this.prix = prix;
        this.description = description;
        this.adresse = adresse;
        this.status_hebergement = status_hebergement;
        this.chambre = chambre;
    }

    public Maison(int id_maison, String titre, float prix, String description, String adresse, String status_hebergement, int chambre, byte[] image) {
        this.id_maison = id_maison;
        this.titre = titre;
        this.prix = prix;
        this.description = description;
        this.adresse = adresse;
        this.status_hebergement = status_hebergement;
        this.chambre = chambre;
        this.image = image;
    }

    public Maison(String titre, float prix, String description, String adresse, String status_hebergement, int chambre, byte[] image) {
        this.titre = titre;
        this.prix = prix;
        this.description = description;
        this.adresse = adresse;
        this.status_hebergement = status_hebergement;
        this.chambre = chambre;
        this.image = image;
    }

 

    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.titre);
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
        final Maison other = (Maison) obj;
        return Objects.equals(this.titre, other.titre);
    }

    public int getId_maison() {
        return id_maison;
    }

    public void setId_maison(int id_maison) {
        this.id_maison = id_maison;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getStatus_hebergement() {
        return status_hebergement;
    }

    public void setStatus_hebergement(String status_hebergement) {
        this.status_hebergement = status_hebergement;
    }

    public int getChambre() {
        return chambre;
    }

    public void setChambre(int chambre) {
        this.chambre = chambre;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Maison{" + "id_maison=" + id_maison + ", titre=" + titre + ", prix=" + prix + ", description=" + description + ", adresse=" + adresse + ", status_hebergement=" + status_hebergement + ", chambre=" + chambre + ", image=" + image + '}';
    }
    
}
