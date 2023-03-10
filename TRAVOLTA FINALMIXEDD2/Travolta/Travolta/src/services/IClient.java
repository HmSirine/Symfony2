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
public interface IClient<T>{
 public String findUserNamebyId(int userID);
 public List<T> afficherNom(int id);
}
