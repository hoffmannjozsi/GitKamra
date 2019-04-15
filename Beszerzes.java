package Kamra;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Hoffmann József
 */
public class Beszerzes {
    private int id;
    private int alap_id;
    private String nev;
    private double mennyiseg;
    private String me;
    private int egysegar;
    private LocalDate datum;
    private boolean atvezetve;

    public Beszerzes() {}
    
    public Beszerzes(int alap_id, String nev, double mennyiseg, String me, int egysegar) {
        this.alap_id = alap_id;
        this.nev = nev;
        this.mennyiseg = mennyiseg;
        this.me = me;
        this.egysegar = egysegar;
        this.datum = LocalDateTime.now().toLocalDate();
        this.atvezetve = false;
    }

    public Beszerzes(int id, int alap_id, double mennyiseg, String me, int egysegar) {
        this.id = id;
        this.alap_id = alap_id;
        this.mennyiseg = mennyiseg;
        this.me = me;
        this.egysegar = egysegar;
        
    }
    
    

    public int getId() {
        return id;
    }

    public String getNev() {
        return nev;
    }
            
    public int getAlap_id() {
        return alap_id;
    }

    public double getMennyiseg() {
        return mennyiseg;
    }

    public String getMe() {
        return me;
    }

    public int getEgysegar() {
        return egysegar;
    }

    public LocalDate getDatum() {
        return datum;
    }
    
    public String getDatumString() {          
        String datumString = datum.format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        return datumString;
    }

    public boolean isAtvezetve() {
        return atvezetve;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMennyiseg(double mennyiseg) {
        this.mennyiseg = mennyiseg;
    }

    public void setMe(String me) {
        this.me = me;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public void setEgysegar(int egysegar) {
        this.egysegar = egysegar;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public void setAtvezetve(boolean atvezetve) {
        this.atvezetve = atvezetve;
    }

    @Override
    public String toString() {
        return nev + " " + mennyiseg + " " + me + " " + egysegar + " Ft";
    }
    
    
    
}
