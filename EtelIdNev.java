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
public class EtelIdNev  extends CsakEtel {

    public EtelIdNev(int id, String nev, int elad_ar) {
        super(id, nev, elad_ar);
    }

    @Override
     public String toString() {
        return nev;
    }
   
    
   
}
