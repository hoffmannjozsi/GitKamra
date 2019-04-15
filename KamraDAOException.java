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
public class KamraDAOException extends Exception {

    public KamraDAOException() {
    }

    public KamraDAOException(String message) {
        super(message);
        
    }

    public KamraDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public KamraDAOException(Throwable cause) {
        super(cause);
    }
    
}
