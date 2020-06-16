package vue;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class LoginInterface extends JDialog {
    private JLabel emailLabel , passwordLabel;
    private TextField emailField ;
    private JPasswordField passwordField;
    private JButton loginButton,cancelButton;

    public LoginInterface(JFrame parent){
        emailLabel=new JLabel("Email");
        passwordLabel=new JLabel("Password");

        emailField = new TextField(15);
        passwordField = new JPasswordField(15);


        loginButton=new JButton("Login");
        cancelButton=new JButton("Cancel");

        setLayout(new GridBagLayout());

        layoutControls();


        setSize(400, 200);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setUndecorated(true);

    }

    private void layoutControls() {

        JPanel controlsPannel=new JPanel();
        JPanel buttonsPanel=new JPanel();

        int space=15;
        Border titleBorder=BorderFactory.createTitledBorder("Login");
        Border spaceBorder=BorderFactory.createEmptyBorder(space, space, space, space);

        /**
         * Controls layout
         */
        controlsPannel.setLayout(new GridBagLayout());
        controlsPannel.setBorder(BorderFactory.createCompoundBorder(spaceBorder, titleBorder));

        /**
         * Buttons layout
         */
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        GridBagConstraints gc=new GridBagConstraints();
        Insets rightPadding=new Insets(0, 0, 0, 15);
        Insets noPadding=new Insets(0, 0, 0, 0);

        gc.fill=GridBagConstraints.NONE;

        /**
         * First row
         */
        gc.weightx=1;
        gc.weighty=1;

        gc.gridy=0;

        gc.gridx=0;
        gc.anchor=GridBagConstraints.EAST;
        gc.insets=rightPadding;
        controlsPannel.add(emailLabel, gc);
        gc.gridx++;
        gc.anchor=GridBagConstraints.WEST;
        gc.insets=noPadding;
        controlsPannel.add(emailField, gc);

        /**
         * Next row
         */
        gc.weightx=1;
        gc.weighty=1;

        gc.gridy++;

        gc.gridx=0;
        gc.anchor=GridBagConstraints.EAST;
        gc.insets=rightPadding;
        controlsPannel.add(passwordLabel, gc);
        gc.gridx++;
        gc.anchor=GridBagConstraints.WEST;
        gc.insets=noPadding;
        controlsPannel.add(passwordField, gc);

        /**
         * Next row
         */
        gc.weightx=1;
        gc.weighty=1;
        gc.gridy++;

        gc.gridx=0;
        buttonsPanel.add(loginButton, gc);
        gc.gridx++;
        buttonsPanel.add(cancelButton, gc);

        setLayout(new BorderLayout());
        add(controlsPannel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);

    }


    public JLabel getEmailLabel() {
        return emailLabel;
    }

    public JLabel getPasswordLabel() {
        return passwordLabel;
    }

    public TextField getEmailField() {
        return emailField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }
}
