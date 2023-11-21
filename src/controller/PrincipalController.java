/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import sistema.optamed.io.DataBase;
import sistema.optamed.model.Cita;
import sistema.optamed.util.ConflictUtil;
import sistema.optamed.util.ConverterUtil;
import sistema.optamed.view.ActionsView;
import sistema.optamed.view.principalView;

/**
 *
 * @author John
 */
public class PrincipalController implements ActionListener {
    principalView view = new principalView();
    private DataBase dataBase = new DataBase();
    private DefaultTableModel modelo = new DefaultTableModel();

    
    public PrincipalController(principalView view){
        this.view = view;
        this.view.btnAgendar.addActionListener(this);
        this.view.btnBuscar.addActionListener(this);
        this.view.btnEditar.addActionListener(this);
        this.view.btnEliminar.addActionListener(this);
        this.view.btnVer.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.btnAgendar){
            agendar();
        } else if (e.getSource() == view.btnBuscar){
            buscar();
        } else if (e.getSource() == view.btnEditar){
            editar();
        } else if (e.getSource() == view.btnEliminar){
            eliminar();
        }  else if (e.getSource() == view.btnVer){
            llenarTabla(view.tablaCitas);
        }     
    }
    
    private void agendar(){
        // Navigate actionsView 
       
       // String fecha = view.calendar.getCalendar().getTime().toString();
        String fecha = ConverterUtil.converterDate(view.calendar.getDate());
        if ( fecha != null){
            ActionsView actionsView = new ActionsView();
            ActionsController actionController = new ActionsController(actionsView,fecha,null);
            actionsView.setVisible(true);
            actionsView.setLocationRelativeTo(null);
            System.out.println("VAMOS AGENDAR "+fecha);
        } else {
        JOptionPane.showMessageDialog(null,"Por favor agregar el dia");
        }
     
    }
    
    private void buscar(){
        String  cedula = JOptionPane.showInputDialog("Por favor digite el numero de cedula a buscar la cita medica: ");
        if(cedula != null){
            for (int i=0; i < dataBase.getCita().size(); i++){
                System.out.println("citas: "+dataBase.getCita().get(i));
                if(Integer.parseInt(cedula) ==  dataBase.getCita().get(i).getCedula()){
                   JOptionPane.showMessageDialog(null,"La cita agendada es: "+dataBase.getCita().get(i));
                }
            }
        }
    }
    
    private void editar(){
        String  cedula = JOptionPane.showInputDialog("Por favor digite el numero de cedula a buscar la cita medica: ");
        String fecha = ConverterUtil.converterDate(view.calendar.getDate());
        if(cedula != null && fecha != null){
            for (int i=0; i < dataBase.getCita().size(); i++){
                if(Integer.parseInt(cedula) ==  dataBase.getCita().get(i).getCedula()
                    && fecha.equals(dataBase.getCita().get(i).getFecha())){
                ActionsView actionsView = new ActionsView();
                ActionsController actionController = new ActionsController(actionsView,fecha,dataBase.getCita().get(i));
                actionsView.setVisible(true);
                break;
            }
          }
        } else {
        JOptionPane.showMessageDialog(null,"Por favor agregar el dia");
        }
    }
    
    private void eliminar(){
       String  cedula = JOptionPane.showInputDialog("Por favor digite el numero de cedula a buscar la cita medica: ");
        String fecha = ConverterUtil.converterDate(view.calendar.getDate());
        if(cedula != null && fecha != null){
            for (int i=0; i < dataBase.getCita().size(); i++){
                if(Integer.parseInt(cedula) ==  dataBase.getCita().get(i).getCedula()
                    && fecha.equals(dataBase.getCita().get(i).getFecha())){
                    for (int x=0; x < dataBase.getControlCitas().size();x++){
                            if(dataBase.getCita().get(i).getDoctor() == dataBase.getControlCitas().get(x).getDoctor() 
                                    && dataBase.getCita().get(i).getFecha() == dataBase.getControlCitas().get(x).getFecha()
                                    && dataBase.getCita().get(i).getHora() == dataBase.getControlCitas().get(x).getHora()){
                                dataBase.getControlCitas().remove(i);
                            }
                    }
                   dataBase.getCita().remove(i);
                   JOptionPane.showMessageDialog(null,"Se ha cancelado la cita");
                break;
            }
          }
        } else {
        JOptionPane.showMessageDialog(null,"Por favor agregar el dia");
        }
    }
           
   
    private void llenarTabla(JTable table){
        System.out.println("Voy a en listar");
        String fecha = ConverterUtil.converterDate(view.calendar.getDate());
        if (fecha != null){
                modelo = (DefaultTableModel)table.getModel();
                List<Cita> citas = dataBase.getCita();
                String[] doctores = dataBase.getDoctor();
                Object[] object = new Object[3];
           
            if(modelo.getRowCount() > 0){
                limpiarTabla(modelo);
            }
             for (int i = 0; i< citas.size(); i++){
                 if (citas.get(i).getFecha().equals(fecha)){
                    object[0] = citas.get(i).getCedula();
                    object[1] = doctores[citas.get(i).getDoctor()];
                    object[2] = citas.get(i).getHora();
                    modelo.addRow(object);
            } 
          }  
        }  
    }
    
    private void limpiarTabla(DefaultTableModel modelo){
        for(int i = 0; i < modelo.getRowCount();i++){
            modelo.removeRow(i);
            i-=1;
        }
    }
}
