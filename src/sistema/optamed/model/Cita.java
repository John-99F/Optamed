/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.optamed.model;

/**
 *
 * @author John
 */
public class Cita {
    private int cedula;
    private String fecha;
    private String hora;
    private int doctor;
    
    public Cita(int cedula, String fecha, String hora, int doctor){
        this.cedula = cedula;
        this.fecha = fecha;
        this.hora = hora;
        this.doctor = doctor;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
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

    public int getDoctor() {
        return doctor;
    }

    public void setDoctor(int doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Cita{" + "cedula= " + cedula + ", fecha= " + fecha + ", hora= " + hora + ", doctor= " + doctor + '}';
    }
    
    
}
