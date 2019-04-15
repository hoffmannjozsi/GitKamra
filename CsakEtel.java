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
public class CsakEtel {
    private int id;
    String nev;
    private int elad_ar;

    public CsakEtel() {
    }

    public CsakEtel(int id, String nev, int elad_ar) {
        this.id = id;
        this.nev = nev;
        this.elad_ar = elad_ar;
    }

    public CsakEtel(String nev, int elad_ar) {
        this.nev = nev;
        this.elad_ar = elad_ar;
    }

    public int getId() {
        return id;
    }

    public String getNev() {
        return nev;
    }

    public int getAr() {
        return elad_ar;
    }

    @Override
    public String toString() {
        return nev + " " + elad_ar + " Ft";
    }
        
}
