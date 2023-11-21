/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import sistema.optamed.io.DataBase;
import sistema.optamed.model.Cita;
import sistema.optamed.model.ControlCitas;
import sistema.optamed.util.ConflictUtil;
import sistema.optamed.view.ActionsView;

/**
 *
 * @author John
 */
public class ActionsController implements ActionListener{

    ActionsView actionView = new ActionsView();
    private DataBase dataBase = new DataBase();
    private String fecha;
    private boolean updateOrInsert = false;
    private Cita cita;
    private ItemListener aListener = new ItemListener(){
        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange() == ItemEvent.SELECTED){
               actionView.cBoxHoras.setModel(new DefaultComboBoxModel(ConflictUtil.conflictoHoras(fecha,actionView.cBoxDoctors.getSelectedIndex())));
            }
        }
    };

    
    public ActionsController(ActionsView view, String fecha, Cita cita){
        this.actionView = view;
        this.actionView.btnAgregar.addActionListener(this);
        this.actionView.btnCancelar.addActionListener(this);
        this.actionView.txtDate.setText(fecha);
        this.fecha = fecha;
        this.actionView.cBoxDoctors.addItemListener(aListener);
        llenarLista();

        if (cita != null){
            updateOrInsert = true;
            actualizarVista(cita);
            this.cita = cita;
        } 
        else {
           updateOrInsert = false;
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == actionView.btnAgregar){
           if (!updateOrInsert){
               agregarCita();
           } else {
               editarCita();
           }
       } else if (e.getSource() == actionView.btnCancelar){
           actionView.setVisible(false);
       }
    }
    
    private void agregarCita(){ 
        if (actionView.cBoxHoras.getSelectedItem().toString() != null &&
            actionView.cBoxHoras.getSelectedItem().toString() != null &&
            actionView.txtFieldCedula.getText() != null &&
            !actionView.txtFieldCedula.getText().isEmpty() && 
            actionView.txtDate.getText() != "fecha:") {
            Cita cita = new Cita(
            Integer.parseInt(actionView.txtFieldCedula.getText()),
                actionView.txtDate.getText(),
                actionView.cBoxHoras.getSelectedItem().toString(),   
                actionView.cBoxDoctors.getSelectedIndex());
            ControlCitas controlCitas = new ControlCitas(
               actionView.cBoxDoctors.getSelectedIndex(),
               actionView.txtDate.getText(),
               actionView.cBoxHoras.getSelectedItem().toString());        
           dataBase.setCita(cita);
           dataBase.setControlCitas(controlCitas);
            JOptionPane.showMessageDialog(actionView, "Cita agendada correctamente!");

            System.out.println(dataBase.getCita().get(0));
            actionView.setVisible(false);
        } else {
           JOptionPane.showMessageDialog(actionView, "Por favor llenar o seleccionar todos los campos");
        }
    }
    
    private void editarCita(){
      for(int i = 0; i < dataBase.getCita().size(); i++){
                 if(cita.getCedula() == dataBase.getCita().get(i).getCedula()){
                dataBase.getCita().set(i,new Cita(
              Integer.parseInt(actionView.txtFieldCedula.getText()),
                 actionView.txtDate.getText(),
                 actionView.cBoxHoras.getSelectedItem().toString(),   
                 actionView.cBoxDoctors.getSelectedIndex()));
                
                    JOptionPane.showMessageDialog(actionView, "Cita modificada correctamente!");

                     System.out.println(dataBase.getCita().get(i));
                    actionView.setVisible(false);
            }
        }
    
    }
    private void actualizarVista(Cita cita){
        actionView.cBoxDoctors.setSelectedIndex(cita.getDoctor());
        actionView.txtFieldCedula.setText(String.valueOf(cita.getCedula()));
        actionView.cBoxHoras.setSelectedItem(cita.getHora());
        actionView.txtDate.setText(cita.getFecha());
        
      
    }
    
    private void llenarLista(){
        for (int i = 0; i < dataBase.getDoctor().length; i++){
            actionView.cBoxDoctors.addItem(dataBase.getDoctor()[i]);
        }
    }
}
