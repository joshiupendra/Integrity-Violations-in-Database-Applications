/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrity_validation_javafx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Upendra
 */
public class MainController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private ImageView admin;
    @FXML
    private ImageView client;
    @FXML
    private Label exit;
    @FXML
    private ImageView welcome;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        admin.setVisible(true);
        client.setVisible(true);
        welcome.setVisible(true);
        
    }    

    @FXML
    private void handleAdminLableAction(MouseEvent event) 
    {
        System.out.println("Admin Action");
        try
        {
        Stage stage1 = (Stage) admin.getScene().getWindow();
        stage1.close();
        
        Parent root = FXMLLoader.load(getClass().getResource("admin/Admin_Login.fxml"));
            
        Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();
            stage.setTitle("Admin Login");
        }
        catch (Exception ex) {
            //Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception in MainController\t"+ex);
        }
    }

    @FXML
    private void handleClientLableAction(MouseEvent event) 
    {
        System.out.println("Client Action");
    }

    @FXML
    private void handleExitLableAction(MouseEvent event) 
    {
        System.out.println("Exit Action");
        System.exit(0);
    }
    
}
