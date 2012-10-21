/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project3task4server;

/**
 * This class acts like a controller, calls Person_Skeleton to handle socket request and response
 * @author Lancy
 */

// file: PersonServer.java exists only on the server side
public class PersonServer {

    public static void main(String args[]) {
        //Create a Person object with value
        Person p = new Person_Servant("Mike", 23);
        //Call Person_Skeleton to handle socket request and response
        Person_Skeleton ps = new Person_Skeleton(p);
        ps.serve();
    }
}
