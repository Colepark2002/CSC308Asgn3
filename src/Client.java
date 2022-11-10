import java.io.*;
import java.net.*;

public class Client {

    DataOutputStream dout;
    DataInputStream din;

    public Client() {
        try {
            Socket s = new Socket("localhost", 6666);
            dout = new DataOutputStream(s.getOutputStream());
            din = new DataInputStream(s.getInputStream());

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String getInput() {
        try {
            return din.readUTF();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void sendOutput(String output) {
        try {
            dout.writeUTF(output);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
