/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kamra;

import java.util.List;
import java.util.Optional;


/**
 *
 * @author Hoffmann József
 */
public interface KamraRepository {
    
    public void addSQLAlapanyag(Optional<Alapanyag> a) throws KamraDAOException; 
    
    public void updSQLAlapanyag (Optional<Alapanyag> a) throws KamraDAOException;
    
    public List<Alapanyag> listAllAlapanyag() throws KamraDAOException;
    
    public void addSQLRecept(Etel et) throws KamraDAOException; 
    
    public List<CsakEtel> listSQLCsakEtel() throws KamraDAOException;
    
    public List<EtelIdNev> listSQLEtelIdNev() throws KamraDAOException;
    
    public List<EtelHozzavalok> listSQLEtelHozzavalok(int etel_id) throws KamraDAOException; 
    
    public void updSQLEtel(Optional<CsakEtel> cse) throws KamraDAOException; 
    
    public void addSQLBeszerzes(Optional<Beszerzes> ob) throws KamraDAOException;
    
    public void updSQLBszerzesAtvezetes(int atvezet_id) throws KamraDAOException;
    
    public int countSQLBeszerzesAtvezetendo() throws KamraDAOException;
     
    public void addSQLKeszlet(Optional<List<Beszerzes>> ba) throws KamraDAOException;
    
    public Optional<List<Beszerzes>>listSQLBszerzesNincsAtvezetve() throws KamraDAOException; 
    
    public void updSQLBszerzesAtvezetesKeszletOK(Optional<List<Beszerzes>> ba) throws KamraDAOException; 
    
   // public int sumSQLHozzavalo(Optional<Hozzavalo> ah) throws KamraDAOException; 
}
