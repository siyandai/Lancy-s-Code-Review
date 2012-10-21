/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project3task4client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * This class acts like a client side proxy that implements Person interface
 * with implementation on getID and getName methods to communicate with server
 * side through TCP socket
 *
 * @author Lancy
 */
// file: Person_Stub.java found only on the client side
public class Person_Stub implements Person {

    Socket socket;
    ObjectOutputStream o;
    ObjectInputStream i;

    public Person_Stub() throws Exception {
    }

    @Override
    public int getID() throws Exception {
        socket = new Socket("localhost", 9000);
        o = new ObjectOutputStream(socket.getOutputStream());
        //Getting person ID
        o.writeObject("ID");
        o.flush();
        i = new ObjectInputStream(socket.getInputStream());
        //Read the result of person ID
        int ret = i.readInt();
        socket.close();
        return ret;
    }

    @Override
    public String getName() throws Exception {
        socket = new Socket("localhost", 9000);
        o = new ObjectOutputStream(socket.getOutputStream());
        //Getting person name
        o.writeObject("name");
        o.flush();
        i = new ObjectInputStream(socket.getInputStream());
        //Read the result of person name
        String ret = (String) (i.readObject());
        socket.close();
        return (String) ret;
    }
}
