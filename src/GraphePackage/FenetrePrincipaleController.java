package GraphePackage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static GraphePackage.PointsDArticulation.EntrerStage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author walid y
 */
public class FenetrePrincipaleController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML private void ClickEnter(ActionEvent event) throws IOException{
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setMaximized(false);
        stage.setResizable(false);
        stage.show();
        PointsDArticulation.mainStage=stage;
        PointsDArticulation.EntrerStage.close();
    }
    
    @FXML private void ClickSortir(ActionEvent event) throws IOException{
        
        PointsDArticulation.EntrerStage.close();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
