/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author walid y
 */
public class Arette {
    private int Sommet1;
    private int sommet2;

    public Arette(int Sommet1, int sommet2) {
        this.Sommet1 = Sommet1;
        this.sommet2 = sommet2;
    }

    public Arette() {
        this.Sommet1 = 0;
        this.sommet2 = 0;
    }

    public int getSommet1() {
        return Sommet1;
    }

    public void setSommet1(int Sommet1) {
        this.Sommet1 = Sommet1;
    }

    public int getSommet2() {
        return sommet2;
    }

    public void setSommet2(int sommet2) {
        this.sommet2 = sommet2;
    }
    
    
}
