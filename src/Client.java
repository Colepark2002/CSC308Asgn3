import java.io.*;
import java.net.*;

public class Client {

    DataOutputStream dout;
    DataInputStream din;
    int playerNum;
    private static Client instance;

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

    public void getInput() {
        try {
            playerNum =  Integer.parseInt(din.readUTF());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static Client getInstance(){
        if(instance == null){
            instance = new Client();
        }
        return instance;
    }

    public int getPlayerNum(){
        return playerNum;
    }

    public void sendOutput(String output) {
        try {
            dout.writeUTF(output);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
