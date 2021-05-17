package Object;

import Interfaces.ClientInterface;

public class Chatter {
    public String name;
    public ClientInterface client;

    public Chatter(String name, ClientInterface client){
        this.name = name;
        this.client = client;
    }

    public String getName(){
        return name;
    }

    public ClientInterface getClient(){
        return client;
    }

}