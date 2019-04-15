/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kamra;

/**
 *
 * @author Hoffmann József
 */
public class Alapanyag {
    private int id;
    private String nev;
    private String me;
    private double min;

    public Alapanyag(String nev, String me, double min) {
        this.nev = nev;
        this.me = me;
        this.min = min;
    }
    
     public Alapanyag(int id, String nev, String me, double min) {
        this.id = id;
        this.nev = nev;
        this.me = me;
        this.min = min;
    }
     
    public int getId() {
        return id;
    }

    public String getNev() {
        return nev;
    }

    public String getMe() {
        return me;
    }

    public double getMin() {
        return min;
    }

    @Override
    public String toString() {
        //return nev + ": " + min + " " + me;
        return nev;
    }
    
    
}
