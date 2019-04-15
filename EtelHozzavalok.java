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
public class EtelHozzavalok {
    private String nev;
    private double mennyiseg;
    private String me;

    public EtelHozzavalok() {
    }

    public EtelHozzavalok(String nev, double mennyiseg, String me) {
        this.nev = nev;
        this.mennyiseg = mennyiseg;
        this.me = me;
    }

    public String getNev() {
        return nev;
    }

    public double getMennyiseg() {
        return mennyiseg;
    }

    public String getMe() {
        return me;
    }

    @Override
    public String toString() {
        return nev + " " + mennyiseg + " " + me ;
    }
    
    
            
}
