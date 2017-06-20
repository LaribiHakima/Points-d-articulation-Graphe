package GraphePackage;



import Traitement.traitement;
import Entity.Graphe;
import java.util.Iterator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Reika Lovely
 */
public class PointsDArticulation extends Application {
    
     static Stage  mainStage;
     static Stage  EntrerStage;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FenetrePrincipale.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setMaximized(false);
        stage.setResizable(false);
        stage.show();
        EntrerStage=stage;
    }

    /**
     * @param args the command line arguments
     */
/*    public static void main(String[] args) {
        //launch(args);
        Graphe g= new Graphe(5);
        int nbCnx= 1, newCnx=0;
        // création du graphe 
        g.getAdj()[0].add(1);
        g.getAdj()[0].add(2);
        
        g.getAdj()[1].add(0);
        g.getAdj()[1].add(2);
        
        g.getAdj()[2].add(0);
        g.getAdj()[2].add(1);
        g.getAdj()[2].add(3);
        g.getAdj()[2].add(4);
        
        g.getAdj()[3].add(2);
        g.getAdj()[3].add(4);
        
        g.getAdj()[4].add(2);
        g.getAdj()[4].add(3);
        
        
        for (int i=0;i<5;i++)
        {
            System.out.print( g.getBool(i));
            System.out.print( i+":  ");
            Iterator<Integer> it = g.getAdj()[i].iterator();
                while (it.hasNext()){
                    System.out.print(it.next()+",");
                }
            System.out.println("");
        }
        
        for (int i=0;i<5;i++){
            
            g.setBool(1, i);
            System.out.print( i);
            newCnx =traitement.CalculerCompConx(g);
            g.InitMarquer();
            if ( nbCnx < newCnx)
                System.out.print("le point d'articulation est :"+i+"\n");
        }
        
        
       System.exit(0);
    }
    */
}
