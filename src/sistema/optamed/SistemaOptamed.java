/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistema.optamed;

import controller.LoginController;
import sistema.optamed.view.loginView;
/**
 *
 * @author John
 */
public class SistemaOptamed {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        loginView login = new loginView();
        LoginController loginController = new LoginController(login);
        login.setVisible(true);
        login.setLocationRelativeTo(null);
    }
    
}
