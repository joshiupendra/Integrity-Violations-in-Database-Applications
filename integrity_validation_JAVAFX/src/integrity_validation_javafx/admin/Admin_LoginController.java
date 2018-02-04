/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrity_validation_javafx.admin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Upendra
 */
public class Admin_LoginController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private Label exit;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button login;
    @FXML
    private Button clear;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        login.setStyle("-fx-background-color:blue;-fx-text-fill:white");
        clear.setStyle("-fx-background-color:blue;-fx-text-fill:white");
    }    

    @FXML
    private void handleExitLableAction(MouseEvent event) 
    {
        System.exit(0);
    }

    @FXML
    private void handleLoginButtonAction(ActionEvent event) 
    {
        login.setStyle("-fx-background-color:green;-fx-text-fill:white");
        clear.setStyle("-fx-background-color:blue;-fx-text-fill:white");
        
        if(!checkall())
        {
        login.setStyle("-fx-background-color:green;-fx-text-fill:white");
        clear.setStyle("-fx-background-color:blue;-fx-text-fill:white");
        String uname = username.getText();
        //String pwd = DigestUtils.shaHex(password.getText());
        String pw1 = password.getText();
        String pwd = String.valueOf(pw1);
        System.out.println("Usename:\t"+uname+"\n\nPassword:\t"+pwd);
        Login_user lu = new Login_user();
        
        if(lu.getlogin(uname, pwd))
        {
            System.out.println("\nSuccessful Login\n\n\n");
            Stage stage2 = (Stage) login.getScene().getWindow();
            stage2.close();
           
            
            try {
            Parent root = FXMLLoader.load(getClass().getResource("Admin_Operation.fxml"));
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();
            stage.setTitle("Admin Operation");
            
        } catch (Exception ex) {
            //Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception in Admin_LoginController\t"+ex);
        }
        }
            
        else
        {
            System.out.println("Did not login");
            login.setStyle("-fx-background-color:blue;-fx-text-fill:white");
        }
        }
        else
        {
            login.setStyle("-fx-background-color:blue;-fx-text-fill:white");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate Field");
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All Info");
            alert.showAndWait();
        }
    }
    
    public boolean checkall()
    {
        boolean flag;
        
        flag = username.getText().isEmpty() | password.getText().isEmpty();
        
        return flag;
    }

    @FXML
    private void handleClearButtonAction(ActionEvent event) 
    {
        username.setText("");
        password.setText("");
        login.setStyle("-fx-background-color:blue;-fx-text-fill:white");
        clear.setStyle("-fx-background-color:green;-fx-text-fill:white");
    }
    
}
