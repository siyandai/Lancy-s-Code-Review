/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project3task4server;

/**
 * This class implements Person interface to provide implementation on getID and getName methods
 * @author Lancy
 */
// file: Person_Servant.java exists only on the server side
public class Person_Servant implements Person {

    int id;
    String name;

    public Person_Servant(String n, int i) {
        name = n;
        id = i;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }
}
