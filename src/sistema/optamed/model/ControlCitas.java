/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.optamed.model;

/**
 *
 * @author John
 */
public class ControlCitas {
    private int doctor;
    private String fecha;
    private String hora;

    public ControlCitas(int doctor, String fecha, String hora) {
        this.doctor = doctor;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getDoctor() {
        return doctor;
    }

    public void setDoctor(int doctor) {
        this.doctor = doctor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    
}
