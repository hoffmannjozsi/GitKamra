/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kamra;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Hoffmann József
 */
public class Etel extends CsakEtel {
    private int alap_id;
    private List<Hozzavalo> hozzavalok = new ArrayList<>();;

    public Etel() {}

    public Etel(String nev, int elad_ar, List<Hozzavalo> hozzavalok) {
        super(nev, elad_ar);
        this.hozzavalok = hozzavalok;
    }
    
    public Etel(int id, String nev, int elad_ar, int alap_id, List<Hozzavalo> hozzavalok) {
        super(id, nev, elad_ar);
        this.alap_id = alap_id;
        this.hozzavalok = hozzavalok;
    }
    
   
    
   
       

    /*public int getId() {
        return id;
    }

    public String getNev() {
        return nev;
    }

    public int getAr() {
        return ar;
    }*/

    public List<Hozzavalo> getHozzavalok() {
        return hozzavalok;
    }

   

    public void setHozzavalok(List<Hozzavalo> hozzavalok) {
        this.hozzavalok = hozzavalok;
    }

   
    
    
}
