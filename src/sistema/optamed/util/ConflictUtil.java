/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.optamed.util;

import java.util.ArrayList;
import sistema.optamed.io.DataBase;
import sistema.optamed.model.ControlCitas;

/**
 *
 * @author John
 */
public class ConflictUtil {
    
    private static DataBase dataBase = new DataBase();
    
    public static String[] conflictoHoras(String fecha, int doctor){
        ArrayList<String> horas = new ArrayList<String>();
        horas.add("8:00 am");
        horas.add("9:00 am");
        horas.add("10:00 am");
        horas.add("11:00 am");
        horas.add("12:00 pm");
        horas.add("1:00 pm");
        horas.add("2:00 pm");
        horas.add("3:00 pm");
        
        String[] horasReturn;
                
        if (!dataBase.getControlCitas().isEmpty()){
            System.out.println("Entre en este punto");
            for (int i = 0; i < dataBase.getControlCitas().size(); i++ ){
                if (fecha.equals(dataBase.getControlCitas().get(i).getFecha())
                        && doctor == dataBase.getControlCitas().get(i).getDoctor()){
                    
                   for(int j = 0; j < horas.size(); j++){
                       if (horas.get(j).equals(dataBase.getControlCitas().get(i).getHora())){
                            horas.remove(j);
                       } else {
                           System.out.println("Entre en este punto 2");
                       }
                   } 
                   
                } else {
                  System.out.println("No se pudo");
                    horasReturn = new String[horas.size()];
                    horasReturn = horas.toArray(horasReturn);
                }
            }
        } else {
            System.out.println("Estoy aqui");
            horasReturn = new String[horas.size()];
            horasReturn = horas.toArray(horasReturn);
            return horasReturn;
        }
      horasReturn = new String[horas.size()];
      horasReturn = horas.toArray(horasReturn);
      return horasReturn;
    }
}
