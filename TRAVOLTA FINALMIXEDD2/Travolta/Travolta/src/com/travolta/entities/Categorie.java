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
public class Categorie {
    private int id_categorie;
    private String type;

    public Categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public Categorie(String type) {
        this.type = type;
    }

    public Categorie(int id_categorie, String type) {
        this.id_categorie = id_categorie;
        this.type = type;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.type);
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
        final Categorie other = (Categorie) obj;
        return Objects.equals(this.type, other.type);
    }

    @Override
    public String toString() {
        return "Categorie{" + "id_categorie=" + id_categorie + ", type=" + type + '}';
    }

   
}
