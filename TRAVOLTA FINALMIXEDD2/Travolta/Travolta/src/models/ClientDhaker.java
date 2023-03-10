/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author mr.rhimi
 */
public class ClientDhaker {
    private int client_id;
    private String client_nom;

    public ClientDhaker(int client_id, String client_nom) {
        this.client_id = client_id;
        this.client_nom = client_nom;
    }

    public ClientDhaker(String client_nom) {
        this.client_nom = client_nom;
    }

    public ClientDhaker() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getClient_nom() {
        return client_nom;
    }

    public void setClient_nom(String client_nom) {
        this.client_nom = client_nom;
    }

    @Override
    public String toString() {
        return "Client{" + "client_id=" + client_id + ", client_nom=" + client_nom + '}';
    }
}
