/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.optamed.util;


/**
 *
 * @author John
 */
public class ConverterUtil {
    
    public static String converterDate(java.util.Date fecha){
        if (fecha != null){
            long d = fecha.getTime();
            java.sql.Date nuevaFecha = new java.sql.Date(d);
            return nuevaFecha.toString();
        }
        return null;
    }
}
