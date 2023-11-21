/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import sistema.optamed.io.DataBase;
import sistema.optamed.view.loginView;
import sistema.optamed.view.principalView;

/**
 *
 * @author John
 */
public class LoginController implements ActionListener{
    
    loginView view = new loginView();
    private static DataBase dataBase = new DataBase();

    
    public LoginController(loginView view){
        this.view = view;
        this.view.btnIngresar.addActionListener(this);   
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.btnIngresar){
            login();
        }
    }
    
    // VALIDA EL LOGIN 
    private boolean validateLogin(){
     boolean status = false;   
      for(int i= 0; i < dataBase.getUser().length ; i++){
          if(view.txtFieldUser.getText() != null && !view.txtFieldUser.getText().isEmpty()){
            if(view.txtFieldUser.getText().equals(dataBase.getUser()[i])){
              if(view.txtFieldPass.getText().equals(dataBase.getPassword()[i])){
                 status = true;
              }
          } 
        }     
      } 
      return status;
    }
    
    
    private void login(){
        if (validateLogin()){
            JOptionPane.showMessageDialog(null, " !Bienvenido! a optamed");
            cleanFields();
            goToPrincipalView();
        } else {
           JOptionPane.showMessageDialog(null, " Usuario o contraseña incorrecta");
        }
    
    }
    //Limpia los campos 
    private void cleanFields(){
        this.view.txtFieldPass.setText("");
        this.view.txtFieldUser.setText("");
    }
    
    private void goToPrincipalView(){
        // cierra la vista del login
        view.setVisible(false);
        
        // Navega a la vista principal
        principalView principal = new principalView();
        PrincipalController controller = new PrincipalController(principal);
        principal.setVisible(true);
        principal.setLocationRelativeTo(null);
    }
}
