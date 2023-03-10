/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;

/**
 *
 * @author Ghassen Chamakh
 */
public interface IService1 <T> {
    
    public void ajouter(T c);
    public void modifier(T c);
    public void supprimer(T c);
    public List<T> afficher();
}
