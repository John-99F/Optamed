/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.optamed.io;

import java.util.ArrayList;
import sistema.optamed.model.Cita;
import sistema.optamed.model.ControlCitas;

/**
 *
 * @author John
 */
public class DataBase {
    
   private String[] user;
   private String[] password;
   private String[] doctor;
   private static ArrayList<Cita> cita = new ArrayList<Cita>();
   private static ArrayList<ControlCitas> controlCitas = new ArrayList<ControlCitas>();
   private String[] horas;
    
   public DataBase(){
       this.user = new String[] {"admin","Laura Sepulveda","Edwin Luque","superAdmin"};
       this.password = new String[] {"1234","Colombia2023","edwin","admin"};
       this.doctor = new String[] {"Laura Bustamente","Samuel Reina","Andres Vergara"};
       this.horas = new String[] {"8:00 am","9:00 am","10:00 am","11:00 am","12:00 pm","01:00 pm","02:00 pm","03:00 pm"};
   }
    
  public String[] getUser(){
      return user;
  }
  
  public String[] getPassword(){
     return password;
  }
  
  public String[] getDoctor(){
      return doctor;
  }
  
  public void setCita(Cita cita){
      this.cita.add(cita);
  }
  
  public ArrayList<Cita> getCita(){
      return cita;
  }

    public String[] getHoras() {
        return horas;
    }

    public ArrayList<ControlCitas> getControlCitas() {
        return controlCitas;
    }

    public void setControlCitas(ControlCitas controlCitas) {
       this.controlCitas.add(controlCitas);
    }
}
