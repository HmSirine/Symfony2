/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author mr.rhimi
 */
public class Vehicule {

    public Vehicule() {
    }
    private int vehicule_id;
    private String marque;
    private String matricule;
    private String couleur;
    private float prix;
    private int nb_place;
    private int status ;
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Vehicule(int vehicule_id, String marque, String matricule, String couleur, float prix, int nb_place, int status, String image) {
        this.vehicule_id = vehicule_id;
        this.marque = marque;
        this.matricule = matricule;
        this.couleur = couleur;
        this.prix = prix;
        this.nb_place = nb_place;
        this.status = status;
        this.image = image;
    }

    public Vehicule(String marque, String matricule, String couleur, float prix, int nb_place, int status, String image) {
        this.marque = marque;
        this.matricule = matricule;
        this.couleur = couleur;
        this.prix = prix;
        this.nb_place = nb_place;
        this.status = status;
        this.image = image;
    }

   

    public int getVehicule_id() {
        return vehicule_id;
    }

    public void setVehicule_id(int vehicule_id) {
        this.vehicule_id = vehicule_id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getNb_place() {
        return nb_place;
    }

    public void setNb_place(int nb_place) {
        this.nb_place = nb_place;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Vehicule{" + "vehicule_id=" + vehicule_id + ", marque=" + marque + ", matricule=" + matricule + ", couleur=" + couleur + ", prix=" + prix + ", nb_place=" + nb_place + ", status=" + status + ", image=" + image + '}';
    }

    

    public Vehicule(int vehicule_id) {
        this.vehicule_id = vehicule_id;
    }
    
}
