package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.RemoteRef;

public interface ServerInterface extends Remote {

    public void updateChat(String username, String message) throws RemoteException;

    public void passIdentity(RemoteRef reference) throws RemoteException;

    public void registerListener(String[] details) throws RemoteException;

    public void leaveChat(String username) throws RemoteException;

    //public void sendPM(int[] privateGroup, String privateMessage)throws RemoteException;

}
