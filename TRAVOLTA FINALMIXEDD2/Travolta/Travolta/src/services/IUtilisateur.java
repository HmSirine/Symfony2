/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;

/**
 *
 * @author hp
 */
public interface IUtilisateur <U> {
    
    public void Ajouter(U u);
    public void modifier(U u);
    public void supprimer(U u);
    public List<U> afficher();
  //  public boolean ValidateLogin(String adresse, String mdp);
  //  public boolean ValidateEmail(String adresse);
    
}
