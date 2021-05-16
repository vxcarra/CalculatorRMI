package RMI;

import InterfacesImplementation.ClientImplementation;

public class ClientRMI {

    public static void main(String[] args) {
        ClientImplementation client = new ClientImplementation();
        client.connectSever();
    }

}
