package Main;

import java.rmi.RemoteException;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String username, message;

        System.out.print("Input your username: ");
        username = input.nextLine();

        String cleanedUsername = username.replaceAll("\\s+", "_");
        cleanedUsername = username.replaceAll("\\W+", "_");

        try {

            ChatClient client = new ChatClient(cleanedUsername);
            client.startClient();

            while (true){
                message = input.nextLine();
                client.serverInterface.updateChat(cleanedUsername, message);
            }

        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

}
