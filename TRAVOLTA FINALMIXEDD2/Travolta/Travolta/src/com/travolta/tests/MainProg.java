/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travolta.tests;

import com.travolta.services.ServiceReservation_Evenement;
import com.travolta.entities.Categorie;
import com.travolta.entities.Evenement;
import com.travolta.entities.Paiement_Reservation_Evenement;
import com.travolta.entities.Reservation_Evenement;
import com.travolta.services.ServiceCategorie;
import com.travolta.services.ServiceEvenement;
import com.travolta.services.ServicePaiement_Reservation_Evenement;

/**
 *
 * @author abdel
 */
public class MainProg {
    
    public static void main(String[] args) {
                
//////////////////// crud de l'evenement/////////////////////////

        //ServiceEvenement se1 = new ServiceEvenement();
        //se1.ajouter(new Evenement("test","t est",1000,500,"test","test","test"));
        //System.out.println(se1.afficher());
        //se1.modifier(new Evenement(3,"modifier","modifier",1200,550,"modifier","modifier","modifier"));
        //se1.supprimer(new Evenement(3));
        //System.out.println(se1.afficher());
        
        
////////////////////crud categorie de l'evenement/////////////////////////

        //ServiceCategorie sc1 = new ServiceCategorie();
        //sc1.ajouter(new Categorie("wedding"));
        //sc1.modifier(new Categorie(1,"soiree"));
        //System.out.println(sc1.afficher());
        //sc1.supprimer(new Categorie(2));
        //System.out.println(sc1.afficher());
        
////////////////////crud reservation de l'evenement/////////////////////////

        //ServiceReservation_Evenement sre1 = new ServiceReservation_Evenement();
        //sre1.ajouter(new Reservation_Evenement("agh","agh","agh@gmail.com","54612783","12:15"));
        //System.out.println(sre1.afficher());
        ////sre1.modifier(new Reservation_Evenement(1,"modifier","modifier","modifier","modifier","modifier"));
        //System.out.println(sre1.afficher());
        //sre1.supprimer(new Reservation_Evenement(1));
        //System.out.println(sre1.afficher());
        
////////////////////crud paiement de la reservation de l'evenement/////////////////////////
        
        //ServicePaiement_Reservation_Evenement spre1 = new ServicePaiement_Reservation_Evenement();
        //spre1.ajouter(new Paiement_Reservation_Evenement(1,1,1500,"non payer"));
        //System.out.println(spre1.afficher());
        //spre1.modifier(new Paiement_Reservation_Evenement(1,1,1,2000,"payer"));
        //System.out.println(spre1.afficher());
        //spre1.supprimer(new Reservation_Evenement(1));
        //System.out.println(spre1.afficher());
    }
}
