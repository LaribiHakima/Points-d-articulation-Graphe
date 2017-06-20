/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Traitement;

import Entity.Graphe;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Reika Lovely
 */
public class traitement {
    
    public static int CalculerCompConx(Graphe g){
        int c=0,sommet=0;
        boolean end = false;
        int marker[]= g.getMarker();
        List <Integer> pile = new ArrayList();
        int racine =PremNONMark(marker);
        System.out.println("L'objet racien est :\n"+racine);
       
        while (!end){
            pile.add(racine); // empiler            
            //sommet+=1;
            
            marker[racine]=1; // marker comme visité
            while (!pile.isEmpty()){ // pile non vide
                
                int indiceSommetPile = pile.size()-1;
                racine = pile.remove(indiceSommetPile); // depiler
                System.out.println("L'objet depilé est :\n"+racine);
                sommet -=1;
                Iterator<Integer> it = (g.getAdj()[racine]).iterator();
                
                while (it.hasNext()){
                    int fils=it.next().intValue();
                    
                    sommet+=1;
                    if(marker[fils]==0) {
                        pile.add(fils);
                        System.out.print("Empiler fils"+fils+" ");
                    } // empiler s'il n'est pas marqué comme visité
                    marker[fils]=1; // marker comme visité
                }
                System.out.print("******************\n");
            }
            c++;
            
            racine= PremNONMark(marker);
            // if (pile.isEmpty()) return c;//end = true; // directly return c;
            if (racine==-1) end=true;
        }
        return c;
    }
    
    public static int PremNONMark(int []T){
        int noeud = 0;
        while ((noeud< T.length) && (T[noeud] == 1))
        {   
            noeud++;
        }
        if(noeud>= T.length) // y'a plus de noeud non visités 
        {
            noeud=-1;
        }
        return noeud;
    
    }
    public static void initTabResu(int[] tab,int lengh)
    {
        for(int i=0;i<lengh;i++){
            tab[i]=-1;
        }
    }
    public static int[] CalculerPointArticulation(Graphe g, int NbConxInit, int nbr_Noed,int[] tab_com_conx){
        int newCnx=0;
        int []PointArticulation= new int [nbr_Noed]; // La taille max du tableau c'est le cas ou tout les noed sont des points d'articulations
        initTabResu(PointArticulation,nbr_Noed); // On initialise le tableau à -1
        int indice=0;
        g.InitMarquer();
        for (int i=0;i<nbr_Noed;i++){
            
            g.setBool(1, i);
            System.out.println("traitement noed="+ i);
            newCnx =traitement.CalculerCompConx(g);
            g.InitMarquer();
            
            if ( NbConxInit < newCnx) {
                PointArticulation[indice]=i; // on sauvegarde le num du sommet
                tab_com_conx[indice]=newCnx; // on sauvegarde le nombre de composantes connexe resultantes
                indice++;
                System.out.println("le point d'articulation est :"+i+"\n");
            }
        }
        return PointArticulation;
    }
    
}
