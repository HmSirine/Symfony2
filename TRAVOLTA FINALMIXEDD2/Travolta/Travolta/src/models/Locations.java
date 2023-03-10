/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDate;

/**
 *
 * @author mr.rhimi
 */
public class Locations {
    private int location_id;
    private int client_id;
    private int vehicule_id;
    private LocalDate debut_location;
    private LocalDate fin_location;
    private String destination;
    private float montant;
     private int status;

    public Locations(int location_id, int client_id, int vehicule_id, LocalDate debut_location, LocalDate fin_location, String destination, float montant, int status) {
        this.location_id = location_id;
        this.client_id = client_id;
        this.vehicule_id = vehicule_id;
        this.debut_location = debut_location;
        this.fin_location = fin_location;
        this.destination = destination;
        this.montant = montant;
        this.status = status;
    }

    public Locations(int client_id, int vehicule_id, LocalDate debut_location, LocalDate fin_location, String destination, float montant, int status) {
        this.client_id = client_id;
        this.vehicule_id = vehicule_id;
        this.debut_location = debut_location;
        this.fin_location = fin_location;
        this.destination = destination;
        this.montant = montant;
        this.status = status;
    }

  
    public Locations(int location_id) {
        this.location_id = location_id;
    }

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    public LocalDate getDebut_location() {
        return debut_location;
    }

    public void setDebut_location(LocalDate debut_location) {
        this.debut_location = debut_location;
    }

    public LocalDate getFin_location() {
        return fin_location;
    }

    public void setFin_location(LocalDate fin_location) {
        this.fin_location = fin_location;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getVehicule_id() {
        return vehicule_id;
    }

    public void setVehicule_id(int vehicule_id) {
        this.vehicule_id = vehicule_id;
    }

    @Override
    public String toString() {
        return "Locations{" + "location_id=" + location_id + ", client_id=" + client_id + ", vehicule_id=" + vehicule_id + ", debut_location=" + debut_location + ", fin_location=" + fin_location + ", destination=" + destination + ", montant=" + montant + ", status=" + status + '}';
    }

  
}
