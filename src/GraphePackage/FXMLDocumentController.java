/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphePackage;

import Entity.Arette;
import Entity.Graphe;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author walid y
 */
public class FXMLDocumentController implements Initializable {
    
    //************************* ELEMENTS CODE ************************//
    @FXML int nombreNoed=0;
    @FXML Graphe InitGraphe;
    @FXML ObservableList<Arette> data = FXCollections.observableArrayList();
    @FXML ObservableList<Integer> resulIntger= FXCollections.observableArrayList();
    @FXML ObservableList<Integer> resulconx= FXCollections.observableArrayList();
    @FXML int[] resultapoint;
    //************************* ELEMENTS INTERFACES ************************//
    @FXML TableView graphe_tab;
    @FXML TableColumn som_col1,som_col2;
    @FXML TextField Nombr_Noed,Sommet_1,Sommet_2;
    @FXML Label label_introduit,label_nb_conx_init;
    @FXML ListView list_point,list_nb_cnx;
    /****************************************************************************/
    /*************************FONCTIONS UTILITAIRES********************************/
    
    @FXML  boolean TextIsInteger(String text) {
        boolean verif=false;
        
        try{
            int i = new Integer(text); // On convertit la chaine en entier
            verif=true;
        }catch(NumberFormatException e)
        {
            verif=false;
        }
        return verif;
    }
    
   @FXML void afficheMessageErreur (String text){
        
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Message d'Erreur");
        alert.setHeaderText("");
        alert.setContentText(text);
        alert.show();
    }
    
    @FXML void afficheMessageConfirmation (String text){
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Message de confirmation");
        alert.setHeaderText("");
        alert.setContentText(text);
        alert.show();
    }
     /****************************************************************************/
     /****************************************************************************/
    @FXML private void CreerTableGraphe(ActionEvent event) {
         
         som_col1.setCellValueFactory(new PropertyValueFactory<Arette,Integer>("sommet1"));
         som_col2.setCellValueFactory(new PropertyValueFactory<Arette,Integer>("sommet2"));
         if(TextIsInteger(Nombr_Noed.getText())) // c'est un integer 
         {
             this.nombreNoed = Integer.parseInt(Nombr_Noed.getText());
             this.graphe_tab.setItems(data);
             InitGraphe = new Graphe(this.nombreNoed); // On initialise notre GrpaheInitiale
             label_introduit.setVisible(true);
             resultapoint =new int[nombreNoed];
         }
         else afficheMessageErreur("Le nombre de noeud dans le graphe doit être un Entier !!");
         
    }
    
    @FXML private void CreerTableGrapheKey(KeyEvent event) {
        
       if(event.getCode()==KeyCode.ENTER) {
         som_col1.setCellValueFactory(new PropertyValueFactory<Arette,Integer>("sommet1"));
         som_col2.setCellValueFactory(new PropertyValueFactory<Arette,Integer>("sommet2"));
         if(TextIsInteger(Nombr_Noed.getText())) // c'est un integer 
         {
             this.nombreNoed = Integer.parseInt(Nombr_Noed.getText());
             this.graphe_tab.setItems(data);
             InitGraphe = new Graphe(this.nombreNoed); // On initialise notre GrpaheInitiale
             label_introduit.setVisible(true);
             resultapoint =new int[nombreNoed];
         }
         else afficheMessageErreur("Le nombre de noeud dans le graphe doit être un Entier !!");
       }
    }
    
    @FXML private void AjouterAretteGraphe(ActionEvent event) {
         
      int numSom1,numSom2;
      if (nombreNoed!=0) { // On a introduit le nombre de sommet
         
         if(TextIsInteger(Sommet_1.getText()) && TextIsInteger(Sommet_2.getText())) // c'est un integer 
         {
             numSom1=Integer.parseInt(Sommet_1.getText());
             numSom2=Integer.parseInt(Sommet_2.getText());
             System.out.println(" Le sommet 1 = "+numSom1 +" Le sommet 2  = "+numSom2 );
             if(numSom1<nombreNoed && numSom2<nombreNoed) {
               if(numSom1!=numSom2){
                   
                //InitGraphe.getAdj()[numSom1].add(numSom2) ; //Arc sommet1 --> sommet2
                //InitGraphe.getAdj()[numSom2].add(numSom1) ; //Arc sommet2 --> sommet1
                Arette  ar = new Arette(numSom1, numSom2);
                this.data.add(ar);
               }else afficheMessageErreur("Le numéros des deux sommets doit être différents !!");
             }
             else afficheMessageErreur("Le numéros du sommet doit être un Entier entre 0 et "+(nombreNoed-1) +" !!");
         }
         else afficheMessageErreur("Le numéros du sommet doit être un Entier !!");
      }else afficheMessageErreur("Veuillez Introduire le nombre de sommets du Graphe !!");
    }
    
    @FXML private void AjouterAretteGrapheKey(KeyEvent event) {
         
         int numSom1,numSom2;
       if(event.getCode()==KeyCode.ENTER) {
        if (nombreNoed!=0) { // On a introduit le nombre de sommet
         if(TextIsInteger(Sommet_1.getText()) && TextIsInteger(Sommet_2.getText())) // c'est un integer 
         {
             numSom1=Integer.parseInt(Sommet_1.getText());
             numSom2=Integer.parseInt(Sommet_2.getText());
             if(numSom1<nombreNoed && numSom2<nombreNoed) {
               if(numSom1!=numSom2){
                //InitGraphe.getAdj()[numSom1].add(numSom2) ; //Arc sommet1 --> sommet2
                //InitGraphe.getAdj()[numSom2].add(numSom1) ; //Arc sommet2 --> sommet1
                Arette  ar = new Arette(numSom1, numSom2);
                this.data.add(ar);
               }else afficheMessageErreur("Le numéros des deux sommets doit être différents !!");
             }
             else afficheMessageErreur("Le numéros du sommet doit être un Entier entre 0 et "+(nombreNoed-1) +" !!");
         }
         else afficheMessageErreur("Le numéros du sommet doit être un Entier !!");
      }else afficheMessageErreur("Veuillez Introduire le nombre de sommets du Graphe !!");
          
     } 
  }
    
    @FXML private void ClickCalculerPointArticu(ActionEvent event) {
       
        resulIntger.clear();
        /************** Remplir le graphe *********************/
       Iterator<Arette> it = data.iterator();
       while(it.hasNext())
       {
           Arette ar = (Arette) it.next();
           InitGraphe.getAdj()[ar.getSommet1()].add(ar.getSommet2()) ; //Arc sommet1 --> sommet2
           InitGraphe.getAdj()[ar.getSommet2()].add(ar.getSommet1()) ; //Arc sommet2 --> sommet1
       }
       /***********************************************************/
       int nbConxInit = Traitement.traitement.CalculerCompConx(InitGraphe); // Calculer le nombre de coùposantes connexes d'origine
       label_nb_conx_init.setText(""+nbConxInit);
       int[] resul_nb_conx = new int[nombreNoed]; // le tableau des nombre de composantes connexes 
       resultapoint=Traitement.traitement.CalculerPointArticulation(InitGraphe,nbConxInit, nombreNoed,resul_nb_conx);
       int i=0;
       while(i<resultapoint.length){
           if (resultapoint[i]!=-1) {
               resulIntger.add(resultapoint[i]);
               resulconx.add(resul_nb_conx[i]);
           } // C'est un num de sommet qui est un point d'articulation
           i++;
       }
       list_nb_cnx.setItems(resulconx);
       list_point.setItems(resulIntger);
    }
    
    @FXML private void ClickSupprimerArette(ActionEvent event) {
     
     Arette ar = (Arette) graphe_tab.getSelectionModel().getSelectedItem();
     data.removeAll(ar);
    }
    
     @FXML private void ClickSortir(ActionEvent event) {
     
     PointsDArticulation.mainStage.close();
    }
     /****************************************************************************/
     /****************************************************************************/
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
