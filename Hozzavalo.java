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
public class Hozzavalo {
    private int id;
    private String nev;
    private double mennyiseg;
    private String mennyisegEgyseg;

    public Hozzavalo(int id, String nev, double mennyiseg, String mennyisegEgyseg) {
        this.id = id;
        this.nev = nev;
        this.mennyiseg = mennyiseg;
        this.mennyisegEgyseg = mennyisegEgyseg;
    }

    public int getId() {
        return id;
    }

    public String getNev() {
        return nev;
    }

    public double getMennyiseg() {
        return mennyiseg;
    }

    public String getMennyisegEgyseg() {
        return mennyisegEgyseg;
    }

    @Override
    public String toString() {
        return nev + " " + mennyiseg + " " + mennyisegEgyseg;
    }
    
    
    
}
