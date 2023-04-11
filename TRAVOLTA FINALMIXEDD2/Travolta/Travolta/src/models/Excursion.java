/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author DELL
 */
public class Excursion {
   private int  IdExcursion ; 
   private String TypeExcursion ; 
   private int NbPersonnes ; 
   private  float PrixUnitaire ;
   
   
   public Excursion(String TypeExcursion, int NbPersonnes, float PrixUnitaire) {
        this.TypeExcursion = TypeExcursion;
        this.NbPersonnes = NbPersonnes;
        this.PrixUnitaire = PrixUnitaire;
    }

    public Excursion(int IdExcursion, String TypeExcursion, int NbPersonnes, float PrixUnitaire) {
        this.IdExcursion = IdExcursion;
        this.TypeExcursion = TypeExcursion;
        this.NbPersonnes = NbPersonnes;
        this.PrixUnitaire = PrixUnitaire;
    }

    

    public void setTypeDExcursion(String TypeExcursion) {
        this.TypeExcursion = TypeExcursion;
    }

    public void setNbPersonnes(int NbPersonnes) {
        this.NbPersonnes = NbPersonnes;
    }

    public void setPrixUnitaire(float PrixUnitaire) {
        this.PrixUnitaire = PrixUnitaire;
    }

    public int getIdExcursion() {
        return IdExcursion;
    }

    public String getTypeExcursion() {
        return TypeExcursion;
    }

    public int getNbPersonnes() {
        return NbPersonnes;
    }

    public float getPrixUnitaire() {
        return PrixUnitaire;
    }

    
    @Override
    public String toString() {
        return "Excursion{" + "IdExcursion=" + IdExcursion + ", TypeExcursion=" + TypeExcursion + ", NbPersonnes=" + NbPersonnes + ", PrixUnitaire=" + PrixUnitaire + '}';
    }
       
}
