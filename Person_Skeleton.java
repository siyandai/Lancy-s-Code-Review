/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project3task4server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class acts like the sever side proxy to receive and send TCP socket, 
 * handle request and response to client
 * @author Lancy
 */

// file: Person_Skeleton.java exists only on the server side
public class Person_Skeleton {

    Person myServer;

    public Person_Skeleton(Person s) {
        myServer = s;
    }
    
/*
 * Listen to the socket port and receive request, handle the request, send resonse back to client side
 */
    public void serve() {
        try {
            ServerSocket s = new ServerSocket(9000);
            //Keep listen to the port 9000 and receive socket
            while (true) {
                Socket socket = s.accept();
                ObjectInputStream i = new ObjectInputStream(socket.getInputStream());
                String method = (String) i.readObject();
                
                if (method.equals("ID")) {
                    //Request is getting ID
                    int a = myServer.getID();
                    ObjectOutputStream o = new ObjectOutputStream(socket.getOutputStream());
                    //Return ID
                    o.writeInt(a);
                    o.flush();
                } else if (method.equals("name")) {
                    //Request is getting name
                    String n = myServer.getName();
                    ObjectOutputStream o = new ObjectOutputStream(socket.getOutputStream());
                    //Return name
                    o.writeObject(n);
                    o.flush();
                }
            }
        } catch (Exception t) {
            System.out.println("Error " + t);
            System.exit(0);
        }
    }
}
