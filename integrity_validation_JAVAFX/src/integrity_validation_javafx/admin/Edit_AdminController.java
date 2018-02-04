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
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Upendra
 */
public class Edit_AdminController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private MenuItem edit;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField cpassword;
    @FXML
    private Button update;
    @FXML
    private Button Clear;

    public static String un;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println("Username in edit frame\t"+un);
        username.setText(un);
        update.setStyle("-fx-background-color:blue;-fx-text-fill:white");
        Clear.setStyle("-fx-background-color:blue;-fx-text-fill:white");
    }    

    @FXML
    private void handleEditAction(ActionEvent event) {
    }

    @FXML
    private void handleCreateAction(ActionEvent event) 
    {
        try
        {
            ((Stage)rootPane.getScene().getWindow()).close();
        Parent root = FXMLLoader.load(getClass().getResource("/integrity_validation_javafx/client/CreateClient.fxml"));
            
        Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();
            stage.setTitle("Admin Login");
        }
        catch (Exception ex) {
            //Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception in Admin_OperationController\t"+ex);
        }
    }

    @FXML
    private void handleViewAction(ActionEvent event) {
    }

    @FXML
    private void handleDeleteAction(ActionEvent event) {
    }

    @FXML
    private void handleIntegrityEngineAction(ActionEvent event) {
    }

    @FXML
    private void handleExitLogoutAction(ActionEvent event) 
    {
        try
        {
        Stage stage2 = (Stage) rootPane.getScene().getWindow();
            stage2.close();
        Parent root = FXMLLoader.load(getClass().getResource("Admin_Login.fxml"));
            
        Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();
            stage.setTitle("Admin Login");
        }
        catch (Exception ex) {
            //Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception in Admin_OperationController\t"+ex);
        }
    }

    @FXML
    private void handleUpdateButtonAction(ActionEvent event) 
    {
        update.setStyle("-fx-background-color:green;-fx-text-fill:white");
        Clear.setStyle("-fx-background-color:blue;-fx-text-fill:white");
        
        if(!checkall())
        {
        update.setStyle("-fx-background-color:green;-fx-text-fill:white");
        Clear.setStyle("-fx-background-color:blue;-fx-text-fill:white");
        String uname = username.getText();
        //String pwd = DigestUtils.shaHex(password.getText());
        String pw1 = password.getText();
        String pwd = String.valueOf(pw1);
        String pw2 = cpassword.getText();
        String cpwd = String.valueOf(pw2);
        System.out.println("Usename:\t"+uname+"\n\nPassword:\t"+pwd+"\n\nC Password:\t"+cpwd);
        
        if(pwd.equals(cpwd))
        {
            Admin_Updator au = new Admin_Updator();
            if(au.update(uname, pwd))
            {
                //System.out.println("DB is updated");
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Database updated Successfully");
                alert.showAndWait();
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("There is some error\nPlease try again later...");
                alert.showAndWait();
            }    
                
        }
        else
        {
            update.setStyle("-fx-background-color:blue;-fx-text-fill:white");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate Field");
            alert.setHeaderText(null);
            alert.setContentText("Both password does not match");
            alert.showAndWait();
        }
        
        }
        else
        {
            update.setStyle("-fx-background-color:blue;-fx-text-fill:white");
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
        
        flag = username.getText().isEmpty() | password.getText().isEmpty() | 
                cpassword.getText().isEmpty();
        
        return flag;
    }

    @FXML
    private void handleClearButtonAction(ActionEvent event) 
    {
        update.setStyle("-fx-background-color:blue;-fx-text-fill:white");
        Clear.setStyle("-fx-background-color:green;-fx-text-fill:white");
        username.setText("");
        password.setText("");
        cpassword.setText("");
    }
    
}
