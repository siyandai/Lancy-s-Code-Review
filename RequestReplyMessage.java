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
public class RequestReplyMessage implements Serializable {
    private int messageType;
    private int requestID;
    private RemoteObjectReference remoteObjectRef;
    private int operationID;
    private byte[] arguments;
    
    public RequestReplyMessage() {
        remoteObjectRef = new RemoteObjectReference();
        //How large should I set?
        arguments = new byte[4];
    }
    
    public int getMessageType() {
        return messageType;
    }
    
    public int getRequestID() {
        return requestID;
    }
    
    public RemoteObjectReference getRemoteObjectReference() {
        return remoteObjectRef;
    }
    
    public int getOperationID() {
        return operationID;
    }
    
    public byte[] getArguments() {
        return arguments;
    }
    
    public void setMessageType(int messType) {
        messageType = messType;
    }
    
    public void setRequestID(int id) {
        requestID = id;
    }
    
    public void setRemoteObjectReference(RemoteObjectReference ref) {
        remoteObjectRef = ref;
    }
    
    public void setOperationID(int id) {
        operationID = id;
    }
    
    public void setArguments(byte[] args) {
        arguments = args;
    }
}
