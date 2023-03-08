package com.WorkTech.gui;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import com.WorkTech.gui.MailSender;
import java.util.Random;
import javafx.scene.control.Button;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    private Label errorLabel;
    @FXML
    private Button forgotPasswordButton;

    @FXML
    public void login() throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.equals("admin") && password.equals("admin")) {
            System.out.println("Login successfully!");
            JOptionPane.showMessageDialog(null, "login successfully !");

            // Send email using Mailtrap
            String recipient = "mohamed.jasser.mriri@gmail.com";
            try {
                MailSender.sendEmail(recipient, "Login successful","Nous avons détecté une nouvelle connexion à votre compte Worktech depuis un Windows. Si c'était vous, aucune action de votre part n'est requise. Dans le cas contraire, nous vous aiderons à sécuriser votre compte User " + username + " has logged in.");
            } catch (MessagingException e) {
                System.out.println("Failed to send email: " + e.getMessage());
            }

            // Load new scene 
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ProfileUser.fxml"));
            Parent root = loader.load();
            usernameField.getScene().setRoot(root);
        } else {
            errorLabel.setText("Invalid username or password.");
        }
    }
    
   @FXML
public void resetPassword() throws MessagingException {
    String username = usernameField.getText();

    // Generate new password
    String newPassword = generatePassword(8);
    // Update password in the database or other data storage

    // Send email using Mailtrap
    String recipient = "mohamed.jasser.mriri@gmail.com";
    String subject = "Password Reset";
    String message = "Your new password is: " + newPassword;
    MailSender.sendEmail(recipient, subject, message);

    JOptionPane.showMessageDialog(null, "A new password has been sent to your email address.");
}
  
  private String generatePassword(int length) {
    String passwordChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    StringBuilder passwordBuilder = new StringBuilder();
    Random random = new Random();
    for (int i = 0; i < length; i++) {
        int index = random.nextInt(passwordChars.length());
        passwordBuilder.append(passwordChars.charAt(index));
    }
    return passwordBuilder.toString();
}
}
