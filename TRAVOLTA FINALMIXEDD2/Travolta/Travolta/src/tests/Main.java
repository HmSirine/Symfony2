/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;

import models.Hotel;
import services.ServiceChambre;
import services.ServiceHotel;
import services.ServiceMaison;
import services.ServiceReservationChambreHotel;
import services.ServiceReservationMaison;

/**
 *
 * @author Ghassen Chamakh
 */
public class Main {
    
   public static void main(String[] args){
       ServiceHotel h=new ServiceHotel();
        //h.ajouter(new Hotel("hotel Mario","hotel 5 etoiles","sousse kantaoui",4,)); 
        //h.modifier(new Hotel(2,"hotel Mario","hotel 3 etoiles","sousse kantaoui",5)); 
         //System.out.println(h.afficher());
        //h.supprimer(new Hotel(2));
         ServiceMaison m=new ServiceMaison();
       //m.ajouter(new Maison("maison Mario",500,"hotel 5 etoiles","sousse kantaoui","reserve",4,"hhhimage")); 
        //m.modifier(new Maison(2,"maison Mario",500,"hotel 5 etoiles","sousse kantaoui","reserve",7,"hhhimage")); 
         //System.out.println(m.afficher());
        //m.supprimer(new Maison(3));
        ServiceChambre c=new ServiceChambre();
        //c.ajouter(new Chambre( 4,"chambre 5  etoiles",400,"VIP",90,"dispo ou non",2)); 
        //c.modifier(new Chambre( 3,"chambre 2  etoiles",400,"VIP",70,"dispo ou non",1)); 
        //System.out.println(c.afficher());
        // c.supprimer(new Chambre(1));
     
         ServiceReservationChambreHotel rh= new ServiceReservationChambreHotel();
      //rh.ajouter(new ReservationChambreHotel("22-04-2022","25-04-2022",500,4,1));
      //-rh.modifier(new ReservationChambreHotel(2,"22-04-2022","25-04-2022",800,4,1));
      //System.out.println(rh.afficher());
     // rh.supprimer(new ReservationChambreHotel(1));
   ServiceReservationMaison rm= new ServiceReservationMaison();
      //xarm.ajouter(new ReservationMaison("22-04-2022","25-04-2022",500,2,1));
       //rm.modifier(new ReservationMaison("22-04-2022","25-04-2022",700,2,1));
       //System.out.println(rm.afficher());
      // rm.supprimer(new ReservationMaison(1));


                
   }
    
}
