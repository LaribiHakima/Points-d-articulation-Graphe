/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Reika Lovely
 */
public class Graphe {
    int Marker[];
    int n ; // nombre de sommets
    //List <Integer> vertices;
    List <Integer> [] adj; // les indices de colonnes seront les noeuds, les valeurs seront les noeuds adajcents

    public Graphe(int n) {
        int []M= new int [n];
        Marker = M;
        adj = (List<Integer>[])new List[n];
        for (int i = 0; i < n; i++) 
        {
            adj[i] = new ArrayList<>();
            Marker[i]= 0; // initialisation de tous les noeuds comme non visité
            
        }
            
        
    }
    
    public void setBool( int val, int i){
        Marker[i]=val;
    }
    
    public int getBool(int i)
    {
        return Marker[i];
    }

    public Graphe() {
    }

    
    public int[] getMarker() {
        return Marker;
    }

    public void setMarker(int[] Marker) {
        this.Marker = Marker;
    }

    public List<Integer>[] getAdj() {
        return adj;
    }

    public void setAdj(List<Integer>[] adj) {
        this.adj = adj;
    }
    
    public void InitMarquer() {
        int i=0;
        while(i<Marker.length)
        {
            Marker[i]=0;
            i++;
        }
    }
        
   
    
    
    
    
    
    
}
