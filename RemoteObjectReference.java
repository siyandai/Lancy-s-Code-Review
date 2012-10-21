/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project3task5client;

import java.io.Serializable;

/**
 *
 * @author Lancy
 */
public class RemoteObjectReference implements Serializable {
    private byte[] internetAddress;
    private int portNum;
    private int time;
    private String remoteObjectInterface;
    
    public RemoteObjectReference () {
        internetAddress = new byte[4];
    }
    
    public static void main(String[] args) {
        //test RemoteObjectReference
    }
    public byte[] getInternetAddress() {
        return internetAddress;
    }
    
    public int getPortNumber () {
        return portNum;
    }
    
    public int getTime () {
        return time;
    }
    
    public String getRemoteObjectInterface() {
        return remoteObjectInterface;
    }
    
    public void setInternetAddress(byte[] address) {
        internetAddress = address;
    }
    
    public void setPortNumber(int number) {
        portNum = number;
    }
    
    public void setTime (int t) {
        time = t;
    }
    
    public void setRemoteObjectInterface(String roi) {
        remoteObjectInterface = roi;
    }
}
