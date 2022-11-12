import java.io.*;
import java.net.*;

/**
 * Creates a client. Implements singleton, as PlayerPanel and ShootPanel must access the same client instnace.
 * @author Bret Craig, Van Park (helped with some implementation)
 */
public class Client {

    DataOutputStream dout;
    DataInputStream din;
    int playerNum;
    private static Client instance;

    /**
     * Connects to the server, creates data streams, and assigns itself a player number
     */
    protected Client() {
        try {
            Socket s = new Socket("localhost", 6666);
            dout = new DataOutputStream(s.getOutputStream());
            din = new DataInputStream(s.getInputStream());
            getInput();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Used to get the client's player number
     */
    public void getInput() {
        try {
            playerNum =  Integer.parseInt(din.readUTF());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Gets the client instance
     * @return Client
     */
    public static Client getInstance(){
        if(instance == null){
            instance = new Client();
        }
        return instance;
    }

    /**
     * Get the client's player number
     * @return player number
     */
    public int getPlayerNum(){
        return playerNum;
    }

    /**
     * Used to send shot coordinates to the server
     * @param output
     */
    public void sendOutput(String output) {
        try {
            dout.writeUTF(output);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
