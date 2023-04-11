/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface Iservices<T> {
    public void Ajouter(T t);
    public void Supprimer(int t);
    public void Modifier(T t);
    public List<T> Afficher();
    public T chercherById(int id);
    
    
}
