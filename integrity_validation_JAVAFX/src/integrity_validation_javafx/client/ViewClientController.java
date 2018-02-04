/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrity_validation_javafx.client;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Upendra
 */
public class ViewClientController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private MenuItem edit;
    @FXML
    private TableColumn<Client, String> username;
    @FXML
    private TableColumn<Client, String> name;
    @FXML
    private TableColumn<Client, String> address;
    @FXML
    private TableColumn<Client, String> dob;
    @FXML
    private TableColumn<Client, String> email;
    @FXML
    private TableColumn<Client, String> mob_num;
    @FXML
    private TableColumn<Client, String> cfor;
    @FXML
    private TableColumn<Client, String> key;
    @FXML
    private TableView table;
    @FXML
    private Button bank;
    @FXML
    private Button telecom;
    @FXML
    private Button uid;
    @FXML
    private Button all;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
        
    }    
    
    private void populateTable(ObservableList<Client> allList) 
    {
        table.setItems(allList);
        
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
    private void handleCreateAction(ActionEvent event) 
    {
        try
        {
            ((Stage)rootPane.getScene().getWindow()).close();
            Parent root = FXMLLoader.load(getClass().getResource("ViewClient.fxml"));
            
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
    private void handleBankButtonAction(ActionEvent event) 
    {
        bank.setStyle("-fx-background-color:green;-fx-text-fill:white");
        uid.setStyle("-fx-background-color:blue;-fx-text-fill:white");
        all.setStyle("-fx-background-color:blue;-fx-text-fill:white");
        telecom.setStyle("-fx-background-color:blue;-fx-text-fill:white");
        try
        {
            username.setCellValueFactory(cellData -> cellData.getValue().getRusername());
            name.setCellValueFactory(cellData -> cellData.getValue().getRname());
            address.setCellValueFactory(cellData -> cellData.getValue().getRaddress());   
            dob.setCellValueFactory(cellData -> cellData.getValue().getRdob());
            email.setCellValueFactory(cellData -> cellData.getValue().getRemail());
            mob_num.setCellValueFactory(cellData -> cellData.getValue().getRmob_num());
            cfor.setCellValueFactory(cellData -> cellData.getValue().getRcfor());
            key.setCellValueFactory(cellData -> cellData.getValue().getRkey());
        
        ObservableList<Client> allList = ClientFetcher.getBankRecords();
        populateTable(allList);
        }
        catch(Exception e)
        {
            System.out.println("Exception in ViewClientController\t"+e);
        }
    }

    @FXML
    private void handleTelecomButtonAction(ActionEvent event) 
    {
        bank.setStyle("-fx-background-color:blue;-fx-text-fill:white");
        uid.setStyle("-fx-background-color:blue;-fx-text-fill:white");
        all.setStyle("-fx-background-color:blue;-fx-text-fill:white");
        telecom.setStyle("-fx-background-color:green;-fx-text-fill:white");
        try
        {
            username.setCellValueFactory(cellData -> cellData.getValue().getRusername());
            name.setCellValueFactory(cellData -> cellData.getValue().getRname());
            address.setCellValueFactory(cellData -> cellData.getValue().getRaddress());   
            dob.setCellValueFactory(cellData -> cellData.getValue().getRdob());
            email.setCellValueFactory(cellData -> cellData.getValue().getRemail());
            mob_num.setCellValueFactory(cellData -> cellData.getValue().getRmob_num());
            cfor.setCellValueFactory(cellData -> cellData.getValue().getRcfor());
            key.setCellValueFactory(cellData -> cellData.getValue().getRkey());
        
        ObservableList<Client> allList = ClientFetcher.getTelecomRecords();
        populateTable(allList);
        }
        catch(Exception e)
        {
            System.out.println("Exception in ViewClientController\t"+e);
        }
    }

    @FXML
    private void handleUIDButtonAction(ActionEvent event) 
    {
        bank.setStyle("-fx-background-color:blue;-fx-text-fill:white");
        uid.setStyle("-fx-background-color:green;-fx-text-fill:white");
        all.setStyle("-fx-background-color:blue;-fx-text-fill:white");
        telecom.setStyle("-fx-background-color:blue;-fx-text-fill:white");
        try
        {
            username.setCellValueFactory(cellData -> cellData.getValue().getRusername());
            name.setCellValueFactory(cellData -> cellData.getValue().getRname());
            address.setCellValueFactory(cellData -> cellData.getValue().getRaddress());   
            dob.setCellValueFactory(cellData -> cellData.getValue().getRdob());
            email.setCellValueFactory(cellData -> cellData.getValue().getRemail());
            mob_num.setCellValueFactory(cellData -> cellData.getValue().getRmob_num());
            cfor.setCellValueFactory(cellData -> cellData.getValue().getRcfor());
            key.setCellValueFactory(cellData -> cellData.getValue().getRkey());
        
        ObservableList<Client> allList = ClientFetcher.getUIDRecords();
        populateTable(allList);
        }
        catch(Exception e)
        {
            System.out.println("Exception in ViewClientController\t"+e);
        }
    }

    @FXML
    private void handleAllButtonAction(ActionEvent event) 
    {
        bank.setStyle("-fx-background-color:blue;-fx-text-fill:white");
        uid.setStyle("-fx-background-color:blue;-fx-text-fill:white");
        all.setStyle("-fx-background-color:green;-fx-text-fill:white");
        telecom.setStyle("-fx-background-color:blue;-fx-text-fill:white");
        try
        {
            username.setCellValueFactory(cellData -> cellData.getValue().getRusername());
            name.setCellValueFactory(cellData -> cellData.getValue().getRname());
            address.setCellValueFactory(cellData -> cellData.getValue().getRaddress());   
            dob.setCellValueFactory(cellData -> cellData.getValue().getRdob());
            email.setCellValueFactory(cellData -> cellData.getValue().getRemail());
            mob_num.setCellValueFactory(cellData -> cellData.getValue().getRmob_num());
            cfor.setCellValueFactory(cellData -> cellData.getValue().getRcfor());
            key.setCellValueFactory(cellData -> cellData.getValue().getRkey());
        
        ObservableList<Client> allList = ClientFetcher.getallRecords();
        populateTable(allList);
        }
        catch(Exception e)
        {
            System.out.println("Exception in ViewClientController\t"+e);
        }
    }
    
}
