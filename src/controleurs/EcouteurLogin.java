package controleurs;

import model.User;
import vue.Fenetre;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurLogin implements ActionListener {

    Fenetre fenetre;

    public EcouteurLogin(Fenetre fenetre) {
        this.fenetre=fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if (actionEvent.getSource().equals(fenetre.getLoginInterface().getLoginButton())){

            User user = fenetre.getControleurProduit().getUser(fenetre.getLoginInterface().getPasswordField().getText(),fenetre.getLoginInterface().getEmailField().getText());

            if (user == null){
                int respone= JOptionPane.showConfirmDialog(fenetre.getEntetePanel(), "Veuiller resaisir votre Email ou mot de passe",
                        "Error", JOptionPane.OK_CANCEL_OPTION);
            }else {
                fenetre.setAdmin(user.isAdmin());
                fenetre.setVisible(true);
                fenetre.getLoginInterface().hide();
            }
        }



        if (actionEvent.getSource().equals(fenetre.getLoginInterface().getCancelButton())){
            System.exit(0);

        }

    }
}
