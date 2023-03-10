/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author DELL
 */
public class Activite {
   private int  IdActivite ; 
   private String NomActivite ; 
   private byte[]  ImageActivite ; 
   private  float PrixActivite ;
   private String TypeActivite; 
   

    public Activite(){};   

    public Activite(String NomActivite, byte[] ImageActivite, float PrixActivite, String TypeActivite) {
        this.NomActivite = NomActivite;
        this.ImageActivite = ImageActivite;
        this.PrixActivite = PrixActivite;
        this.TypeActivite = TypeActivite;
    }
    
      
                 

 public Activite(int IdActivite, String NomActivite,byte[] ImageActivite,float PrixActivite, String TypeActivite) {
        this.IdActivite=IdActivite;
        this.NomActivite = NomActivite;
        this.ImageActivite = ImageActivite;
        this.PrixActivite = PrixActivite;
        this.TypeActivite = TypeActivite;
    }
 public Activite(int IdActivite, String NomActivite,float PrixActivite, String TypeActivite) {
        this.IdActivite=IdActivite;
        this.NomActivite = NomActivite;
        this.PrixActivite = PrixActivite;
        this.TypeActivite = TypeActivite;
    }
  public Activite( String NomActivite,float PrixActivite, String TypeActivite) {
        this.NomActivite = NomActivite;
        this.PrixActivite = PrixActivite;
        this.TypeActivite = TypeActivite;
    }

/*Activite(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getString(4)),rs.getString(5)));*/
   

    

   

    

   

    public void setIdActivite(int IdActivite) {
        this.IdActivite = IdActivite;
    }

    public void setNomActivite(String NomActivite) {
        this.NomActivite = NomActivite;
    }

    public void setImageActivite(byte[] imageActivite) {
    
        this.ImageActivite = imageActivite;
    }

    public void setPrixActivite(float PrixActivite) {
        this.PrixActivite = PrixActivite;
    }

    public void setTypeActivite(String TypeActivite) {
        this.TypeActivite = TypeActivite;
    }

    public int getIdActivite() {
        return IdActivite;
    }

    public String getNomActivite() {
        return NomActivite;
    }

    public byte[] getImageActivite() {
        return ImageActivite;
    }

    public float getPrixActivite() {
        return PrixActivite;
    }

    public String getTypeActivite() {
        return TypeActivite;
    }

   
    
    @Override
    public String toString() {
        return "Activite{" + "IdActivite=" + IdActivite + ", NomActivite=" + NomActivite + ", ImageActivite=" + ImageActivite + ", PrixActivite=" + PrixActivite + ", TypeActivite=" + TypeActivite + '}';
    }
    
}
