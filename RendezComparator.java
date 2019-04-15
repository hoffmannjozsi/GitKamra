/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kamra;

import java.util.Comparator;

/**
 *
 * @author Hoffmann József
 */
public class RendezComparator implements Comparator<Alapanyag> {
    
    
    @Override
    public int compare(Alapanyag egyik, Alapanyag masik) {
         return egyik.getNev().compareToIgnoreCase(masik.getNev()); 
    }
    
}
