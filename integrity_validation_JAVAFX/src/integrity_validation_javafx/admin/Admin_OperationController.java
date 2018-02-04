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
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Upendra
 */
public class Admin_OperationController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private MenuItem edit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
        
    }    


    @FXML
    private void handleEditAction(ActionEvent event) 
    {
        
        try
        {
            ((Stage)rootPane.getScene().getWindow()).close();
            Parent root = FXMLLoader.load(getClass().getResource("Edit_Admin.fxml"));
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();
            stage.setTitle("Update Admin Info");
        }
        catch (Exception ex) {
            //Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception in FXMLDocumentController\t"+ex);
        }
        
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
    private void handleViewAction(ActionEvent event) 
    {
        try
        {
            ((Stage)rootPane.getScene().getWindow()).close();
        Parent root = FXMLLoader.load(getClass().getResource("/integrity_validation_javafx/client/ViewClient.fxml"));
            
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
    private void handleDeleteAction(ActionEvent event) 
    {
        try
        {
            ((Stage)rootPane.getScene().getWindow()).close();
        Parent root = FXMLLoader.load(getClass().getResource("/integrity_validation_javafx/client/DeleteClient.fxml"));
            
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
    private void handleIntegrityEngineAction(ActionEvent event) {
    }

    @FXML
    private void handleExitLogoutAction(ActionEvent event) 
    {
        try
        {
            ((Stage)rootPane.getScene().getWindow()).close();
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
    
}
