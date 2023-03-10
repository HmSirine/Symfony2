/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;

/**
 *
 * @author mr.rhimi
 */
public interface IPayment<T> {
    public void ajouter(T r);
    public void modifier(T r);
    public List<T> afficher();
}
