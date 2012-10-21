/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project3task5client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Lancy
 */
public class Person_Stub implements Person {
    Socket socket;
    ObjectOutputStream o;
    ObjectInputStream i;
    RequestReplyMessage message;

    public Person_Stub() throws Exception {
    }

    Person_Stub(RemoteObjectReference remoteObject) {
        message.setRemoteObjectReference(remoteObject);
    }

    @Override
    public int getID() throws Exception {
        socket = new Socket();
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
