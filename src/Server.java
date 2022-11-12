import java.io.*;
import java.net.*;

class Server {
    public static void main(String[] args)
    {
        ServerSocket server = null;

        try {

            server = new ServerSocket(6666);
            server.setReuseAddress(true);

            Socket player1 = server.accept();
            System.out.println("Player 1 connected");
            DataOutputStream out1 = new DataOutputStream(player1.getOutputStream());
            out1.writeUTF("1");
            Socket player2 = server.accept();
            System.out.println("Player 2 connected");
            DataOutputStream out2 = new DataOutputStream(player2.getOutputStream());
            out2.writeUTF("2");

            PlayerHandler playerHandler = new PlayerHandler(player1, player2);

            new Thread(playerHandler).start();

        }
        catch (IOException e) {
            System.out.println(e);
        }
    }


    private static class PlayerHandler implements Runnable {
        private final Socket player1;
        private final Socket player2;
        private BlackBoard board;

        public PlayerHandler(Socket player1, Socket player2)
        {
            this.player1 = player1;
            this.player2 = player2;
            board = BlackBoard.getInstance();
        }

        public void run()
        {
            try {
                DataOutputStream out1 = new DataOutputStream(player1.getOutputStream());
                DataInputStream in1 = new DataInputStream(player1.getInputStream());
                DataOutputStream out2 = new DataOutputStream(player2.getOutputStream());
                DataInputStream in2 = new DataInputStream(player2.getInputStream());

                // Receive ship placements from p1
                // Receive ship placements from p2

            }
            catch (IOException e) {
                System.out.println(e);
            }

        }
    }
}