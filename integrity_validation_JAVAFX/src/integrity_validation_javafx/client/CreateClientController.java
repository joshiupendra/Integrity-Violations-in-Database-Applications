/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrity_validation_javafx.client;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Upendra
 */
public class CreateClientController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private MenuItem edit;
    @FXML
    private TextField name;
    @FXML
    private TextArea address;
    @FXML
    private DatePicker dob;
    @FXML
    private ComboBox cfor;
    @FXML
    private TextField email;
    @FXML
    private TextField mob_num;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button submit;
    @FXML
    private Button clear;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cfor.getItems().addAll(
            "Bank",
            "UID",
            "Tele"
        );
    }    

    @FXML
    private void handleEditAction(ActionEvent event) 
    {
        try
        {
            ((Stage)rootPane.getScene().getWindow()).close();
            Parent root = FXMLLoader.load(getClass().getResource("/integrity_validation_javafx/admin/Edit_Admin.fxml"));
            
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
    private void handleCreateAction(ActionEvent event) {
    }

    @FXML
    private void handleViewAction(ActionEvent event) {
    }

    @FXML
    private void handleDeleteAction(ActionEvent event) 
    {
        try
        {
            ((Stage)rootPane.getScene().getWindow()).close();
            Parent root = FXMLLoader.load(getClass().getResource("DeleteClient.fxml"));
            
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
    private void handleIntegrityEngineAction(ActionEvent event) {
    }

    @FXML
    private void handleExitLogoutAction(ActionEvent event) 
    {
        try
        {
            ((Stage)rootPane.getScene().getWindow()).close();
        Parent root = FXMLLoader.load(getClass().getResource("/integrity_validation_javafx/admin/Admin_Login.fxml"));
            
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
    private void handleSubmitButtonAction(ActionEvent event) 
    {
        submit.setStyle("-fx-background-color:green;-fx-text-fill:white");
        clear.setStyle("-fx-background-color:blue;-fx-text-fill:white");
        
        if(!checkall())
        {
            String nam = name.getText();
            String addr = address.getText();
           
            String pw1 = password.getText();
            String pwd = String.valueOf(pw1);
            String db = dob.getEditor().getText();
            getun(nam, db);
            String em = email.getText();
            String mn = mob_num.getText();
            String un = username.getText();
            String cf = (String) cfor.getValue();
            //System.out.println("cfor\t"+cf);
            if(mnval(mn))
            {
            if(emval(em))
            {    
            String al = nam + addr + db + cf + em + mn + un + pwd;
            //System.out.println("All String\t"+al);
            ValidatorKeyGenerator vd = new ValidatorKeyGenerator();
            String key = vd.getKey(al);
            //System.out.println("Key\t"+key);
            Client_Inserter ci = new Client_Inserter();
            if(ci.insert(nam,addr,pwd,db,em,mn,un,cf,key))
            {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Client inserted successfully...\nKEY:\t"+key+"\nPlease remember this key for future login purposes");
            alert.showAndWait();
                
            }
            else
            {
                submit.setStyle("-fx-background-color:blue;-fx-text-fill:white");
                Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("There is some error\nPlease try again later...");
            alert.showAndWait();
            }
            }
            else
            {
                submit.setStyle("-fx-background-color:blue;-fx-text-fill:white");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Please enter validated email");
                alert.showAndWait();
            }
            }
            else
            {
                submit.setStyle("-fx-background-color:blue;-fx-text-fill:white");
                Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Mobile Number should be integer and of 10 digits");
            alert.showAndWait();
            }
        }
        else
        {
            submit.setStyle("-fx-background-color:blue;-fx-text-fill:white");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate Field");
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All Info");
            alert.showAndWait();
        }
            
    }
    
    public boolean emval(String em)
    {
        boolean flag;
        
        flag = em.contains("@");
        
        return flag;
        
    }
    
    public boolean mnval(String mn)
    {
        boolean flag;
        if(mn.length() == 10)
        {
        try {
            int x = Integer.parseInt(mn);
            flag = true;
        } catch (Exception e) {
            flag = false;
        }
        }
        else
            flag = false;
        
        return flag;
    }
    
    public String getun(String name, String dob)
    {
        String un;
        
        un = name.substring(0, 3) + dob.charAt(1) + dob.charAt(4) + dob.charAt(7) + dob.charAt(9);
        username.setText(un);
        
        return un;
    }
    
    public boolean checkall()
    {
        boolean flag;
        
        flag = name.getText().isEmpty() | address.getText().isEmpty() | email.getText().isEmpty() |
                mob_num.getText().isEmpty();
        
        return flag;
    }

    @FXML
    private void handleClearButtonAction(ActionEvent event) 
    {
        submit.setStyle("-fx-background-color:blue;-fx-text-fill:white");
        clear.setStyle("-fx-background-color:green;-fx-text-fill:white");
        name.setText("");
        username.setText("");
        email.setText("");
        mob_num.setText("");
        address.setText("");
    }
    
}
