/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kamra;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author Hoffmann József
 */
public class KamraRepositoryJDBCimpl implements KamraRepository  {
    private final Connection conn;
    private final PreparedStatement addSQLAlapanyag;
    private final PreparedStatement listAllAlapanyag;
    private final PreparedStatement updSQLAlapanyag;
    private final PreparedStatement addSQLEtel;
    private final PreparedStatement addSQLRecept;
    private final PreparedStatement listSQLCsakEtel;
    private final PreparedStatement listSQLEtelHozzavalok;
    private final PreparedStatement updSQLEtel;
    //private final PreparedStatement listSQLRecept;
    private final PreparedStatement addSQLBeszerzes;
    private final PreparedStatement updSQLBszerzesAtvezetes;
    private final PreparedStatement countSQLBeszerzesAtvezetendo;
    private final PreparedStatement addSQLKeszlet;
    private final PreparedStatement listSQLBszerzesNincsAtvezetve;
    private final PreparedStatement updSQLBszerzesAtvezetesKeszletOK;
     private final PreparedStatement listSQLEtelIdNev;
    
    
    public KamraRepositoryJDBCimpl(Connection conn) throws KamraDAOException, SQLException  {
        this.conn = conn;
        this.addSQLAlapanyag = conn.prepareStatement("INSERT INTO kamra.alapanyag(nev, me, min) VALUES (?, ?, ?)");
        this.listAllAlapanyag = conn.prepareStatement("SELECT * FROM alapanyag");
        this.updSQLAlapanyag = conn.prepareStatement("UPDATE kamra.alapanyag SET nev = ?, me = ?, min = ? WHERE id = ?");
        this.addSQLEtel = conn.prepareStatement("INSERT INTO kamra.etel(nev, elad_ar) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
        this.addSQLRecept = conn.prepareStatement("INSERT INTO kamra.recept(etel_id, alap_id, mennyiseg, me) VALUES (?, ?, ?, ?)");
        this.listSQLCsakEtel =  conn.prepareStatement("SELECT * FROM kamra.etel ORDER BY nev");
        this.listSQLEtelIdNev = conn.prepareStatement("SELECT * FROM kamra.etel ORDER BY nev");
        this.listSQLEtelHozzavalok  =  conn.prepareStatement("SELECT alapanyag.nev, "
                + "recept.mennyiseg, recept.me FROM etel INNER JOIN recept "
                + "ON etel.id = recept.etel_id INNER JOIN alapanyag "
                + "ON recept.alap_id = alapanyag.id WHERE etel_id = ?");
        /*this.listSQLRecept = conn.prepareStatement("SELECT etel.id, etel.nev, etel.elad_ar, "
                + "recept.etel_id, recept.alap_id, alapanyag.nev, recept.mennyiseg, "
                + "recept.me FROM etel INNER JOIN recept ON etel.id = recept.etel_id "
                + "INNER JOIN alapanyag ON recept.alap_id = alapanyag.id");*/
        this.updSQLEtel = conn.prepareStatement("UPDATE kamra.etel SET nev = ?, elad_ar = ? WHERE id = ?");
        this.addSQLBeszerzes = conn.prepareStatement("INSERT INTO kamra.beszerzes(alap_id, mennyiseg, me, datum, atvezetve, egysegar) "
                + "VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        this.updSQLBszerzesAtvezetes = conn.prepareStatement("UPDATE kamra.beszerzes SET atvezetve = 1 WHERE id = ?");
        this.countSQLBeszerzesAtvezetendo = conn.prepareStatement("SELECT COUNT(*) as atveztendo FROM beszerzes WHERE atvezetve = 0");
        this.addSQLKeszlet = conn.prepareStatement("INSERT INTO kamra.keszlet(beszerzes_id, alap_id, mennyiseg, me, ar) VALUES (?, ?, ?, ?, ?)");
        this.listSQLBszerzesNincsAtvezetve = conn.prepareStatement("SELECT * FROM beszerzes WHERE atvezetve = 0");
        this.updSQLBszerzesAtvezetesKeszletOK = conn.prepareStatement("UPDATE kamra.beszerzes SET atvezetve = 1 WHERE id = ?");
        
    }
    
    @Override
    public void updSQLBszerzesAtvezetesKeszletOK(Optional<List<Beszerzes>> ba) throws KamraDAOException {
        try {
            for (int i = 0; i < ba.get().size(); i++) {
             this.updSQLBszerzesAtvezetesKeszletOK .setInt(1, ba.get().get(i).getId());
             this.updSQLBszerzesAtvezetesKeszletOK.executeUpdate();
            }
        }  catch (SQLException ex) {           
            throw new KamraDAOException("Hiba történt az adatbáziskapcsolatban! Üzenet: " + ex.getMessage());
        }
    }
    
    @Override
    public void addSQLKeszlet(Optional<List<Beszerzes>> ba) throws KamraDAOException {
        try {
            for (int i = 0; i < ba.get().size(); i++) {
                this.addSQLKeszlet.setInt(1, ba.get().get(i).getId());
                this.addSQLKeszlet.setInt(2, ba.get().get(i).getAlap_id());
                this.addSQLKeszlet.setDouble(3, ba.get().get(i).getMennyiseg());
                this.addSQLKeszlet.setString(4, ba.get().get(i).getMe());
                this.addSQLKeszlet.setInt(5, ba.get().get(i).getEgysegar());
                this.addSQLKeszlet.executeUpdate();
            }
        }  catch (SQLException ex) {           
            throw new KamraDAOException("Hiba történt az adatbáziskapcsolatban! Üzenet: " + ex.getMessage());
        }
    }
    
    @Override
     public Optional<List<Beszerzes>> listSQLBszerzesNincsAtvezetve() throws KamraDAOException {
        List<Beszerzes> beszerzesAtvezetendo = new ArrayList<>(); 
        Optional optAtvez = Optional.empty();
        ResultSet rs;
        try {
            rs = this.listSQLBszerzesNincsAtvezetve.executeQuery();
            while(rs.next()) {
                Beszerzes atvez = new Beszerzes(rs.getInt("id"), rs.getInt("alap_id"), 
                    rs.getDouble("mennyiseg"), rs.getString("me"), rs.getInt("egysegar"));
                beszerzesAtvezetendo.add(atvez);
            }
        }  catch (SQLException ex) {             
            throw new KamraDAOException("Hiba történt az adatbáziskapcsolatban! Üzenet: " + ex.getMessage());
        }    
        optAtvez = Optional.of(beszerzesAtvezetendo);
        return optAtvez;
     }
    
    @Override
    public void updSQLBszerzesAtvezetes(int atvezet_id) throws KamraDAOException {
        try {
            this.updSQLBszerzesAtvezetes.setInt(0, atvezet_id);
            this.updSQLBszerzesAtvezetes.executeUpdate();
        }  catch (SQLException ex) {           
            throw new KamraDAOException("Hiba történt az adatbáziskapcsolatban! Üzenet: " + ex.getMessage());
        }
    }
    
    @Override
    public int countSQLBeszerzesAtvezetendo() throws KamraDAOException {
        int atvezetendo = 0;
        ResultSet rs;
        try {
            rs = this.countSQLBeszerzesAtvezetendo.executeQuery();
            while (rs.next()) {
               atvezetendo = rs.getInt("atveztendo");
            }
        }  catch (SQLException ex) {           
            throw new KamraDAOException("Hiba történt az adatbáziskapcsolatban! Üzenet: " + ex.getMessage());
        }
        return atvezetendo;
    }
    
    @Override
    public void addSQLBeszerzes(Optional<Beszerzes> ob) throws KamraDAOException {
        try {
        this.addSQLBeszerzes.setInt(1, ob.get().getAlap_id());
        this.addSQLBeszerzes.setDouble(2, ob.get().getMennyiseg());
        this.addSQLBeszerzes.setString(3, ob.get().getMe());        
        this.addSQLBeszerzes.setDate(4, Date.valueOf(ob.get().getDatum()));
        int atvezetveInt;
        if (!ob.get().isAtvezetve())           
            atvezetveInt = 0;
        else 
            atvezetveInt = 1;   
        this.addSQLBeszerzes.setInt(5, atvezetveInt);
        this.addSQLBeszerzes.setInt(6, ob.get().getEgysegar());
        this.addSQLBeszerzes.executeUpdate();
        /*
        ResultSet generatedKeys = this.addSQLBeszerzes.getGeneratedKeys(); 
        int id;
        if (generatedKeys.next()) {
                //System.out.println("A beszúrás következtében létrejött etel_id: " + generatedKeys.getInt(1));
                id = generatedKeys.getInt("id");
            } else {
                throw new KamraDAOException("Nincs INSERT.");
            } 
        */
        }  catch (SQLException ex) {           
            throw new KamraDAOException("Hiba történt az adatbáziskapcsolatban! Üzenet: " + ex.getMessage());
        }
    }
    
    @Override
    public void updSQLEtel(Optional<CsakEtel> cse) throws KamraDAOException {
        try {
             this.updSQLEtel.setString(1, cse.get().getNev());  
             this.updSQLEtel.setInt(2, cse.get().getAr());
             this.updSQLEtel.setInt(3, cse.get().getId());
             this.updSQLEtel.executeUpdate();
         }  catch (SQLException ex) {           
            throw new KamraDAOException("Hiba történt az adatbáziskapcsolatban! Üzenet: " + ex.getMessage());
        }
    }
    
    @Override
    public List<CsakEtel> listSQLCsakEtel() throws KamraDAOException {
       ResultSet all;
       List<CsakEtel> listCsakEtel = new ArrayList<>();
        try { 
            all = this.listSQLCsakEtel.executeQuery();
            while (all.next()) {
                CsakEtel csakEtel = new CsakEtel(all.getInt("id"), all.getString("nev"), all.getShort("elad_ar"));
                listCsakEtel.add(csakEtel);
            }
            return listCsakEtel;
        } catch (SQLException ex) {
            throw new KamraDAOException("Hiba történt az adatbáziskapcsolatban! Üzenet: " + ex.getMessage());
        }
    }
    
    @Override
      public List<EtelIdNev> listSQLEtelIdNev() throws KamraDAOException {
          ResultSet all;
       List<EtelIdNev> listEtelIdNev = new ArrayList<>();
        try { 
            all = this.listSQLCsakEtel.executeQuery();
            while (all.next()) {
                EtelIdNev etelIdNev = new EtelIdNev(all.getInt("id"), all.getString("nev"), all.getShort("elad_ar"));
                listEtelIdNev.add(etelIdNev);
            }
            return listEtelIdNev;
        } catch (SQLException ex) {
            throw new KamraDAOException("Hiba történt az adatbáziskapcsolatban! Üzenet: " + ex.getMessage());
        }
      }
    
    @Override
    public List<EtelHozzavalok> listSQLEtelHozzavalok(int etel_id) throws KamraDAOException {
        ResultSet all;
        List<EtelHozzavalok> listEtelHozzavalok = new ArrayList<>();
        try {
            listSQLEtelHozzavalok.setInt(1, etel_id);
            all = this.listSQLEtelHozzavalok.executeQuery();
            while (all.next()) {
                EtelHozzavalok etelHozzavalok = new EtelHozzavalok(all.getString("nev"), all.getDouble("mennyiseg"), all.getString("me"));
                listEtelHozzavalok.add(etelHozzavalok);
            }
            return listEtelHozzavalok;
        } catch (SQLException ex) {
            throw new KamraDAOException("Hiba történt az adatbáziskapcsolatban! Üzenet: " + ex.getMessage());
        }
    }
    
    /*
    public List<Etel> listSQLRecept()  throws KamraDAOException {
        ResultSet all;
        try {
            all = this.listSQLRecept.executeQuery();
            List<Etel> eList = new ArrayList<>();
            while (all.next()) {
                int id = 0;
                if (id != all.getInt("id")) {
                    
                }
            }
            
            return eList;
        } catch (SQLException ex) {
            throw new KamraDAOException("Hiba történt az adatbáziskapcsolatban! Üzenet: " + ex.getMessage());
        }
    }
    */
    /**
     *
     * @param et
     * 
     * @throws KamraDAOException
     */
    @Override
    public void addSQLRecept(Etel et) throws KamraDAOException {
        try {
            this.addSQLEtel.setString(1, et.getNev());
            this.addSQLEtel.setInt(2, et.getAr());
            int etel_id = 0;
            this.addSQLEtel.executeUpdate();
            ResultSet generatedKeys = this.addSQLEtel.getGeneratedKeys();  
            
            if (generatedKeys.next()) {
                System.out.println("A beszúrás következtében létrejött etel_id: " + generatedKeys.getInt(1));
                etel_id =  generatedKeys.getInt(1);
            } else {
                throw new KamraDAOException("Nincs INSERT.");
            } 
            for (Hozzavalo h : et.getHozzavalok()) {
                this.addSQLRecept.setInt(1, etel_id);
                this.addSQLRecept.setInt(2, h.getId());
                this.addSQLRecept.setDouble(3, h.getMennyiseg());
                this.addSQLRecept.setString(4, h.getMennyisegEgyseg());
                this.addSQLRecept.executeUpdate();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(KamraRepositoryJDBCimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
     public void addSQLAlapanyag(Optional<Alapanyag> a) throws KamraDAOException {
        try {             
                this.addSQLAlapanyag.setString(1, a.get().getNev().toLowerCase());             
                this.addSQLAlapanyag.setString(2, a.get().getMe().toLowerCase());
                this.addSQLAlapanyag.setDouble(3, a.get().getMin());             
                this.addSQLAlapanyag.executeUpdate();
        } catch (SQLException ex) {           
            throw new KamraDAOException("Hiba történt az adatbáziskapcsolatban! Üzenet: " + ex.getMessage());
        }
     }
     
    @Override
     public void updSQLAlapanyag (Optional<Alapanyag> a) throws KamraDAOException {
         try {
             this.updSQLAlapanyag.setString(1, a.get().getNev().toLowerCase());  
             this.updSQLAlapanyag.setString(2, a.get().getMe().toLowerCase());
             this.updSQLAlapanyag.setDouble(3, a.get().getMin());
             this.updSQLAlapanyag.setInt(4, a.get().getId());
             this.updSQLAlapanyag.executeUpdate();
         }  catch (SQLException ex) {           
            throw new KamraDAOException("Hiba történt az adatbáziskapcsolatban! Üzenet: " + ex.getMessage());
        }
     }
     
    @Override
     public List<Alapanyag> listAllAlapanyag() throws KamraDAOException {
        ResultSet all;
        try {
            all = this.listAllAlapanyag.executeQuery();
            
            List<Alapanyag> alapanyagLista = new ArrayList<>();
           while (all.next()) {               
               Alapanyag a = new Alapanyag(all.getInt("id"), all.getString("nev"), all.getString("me"), all.getDouble("min"));
            alapanyagLista.add(a);
        }
           
           return alapanyagLista;
        } catch (SQLException ex) {
            throw new KamraDAOException("Hiba történt az adatbáziskapcsolatban! Üzenet: " + ex.getMessage());
        }
     }
}
