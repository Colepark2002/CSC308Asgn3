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

                DataInputStream in1 = new DataInputStream(player1.getInputStream());
                DataInputStream in2 = new DataInputStream(player2.getInputStream());

                while(true) {
                    // Player 1 shoots
                    String p1Shot;
                    while ((p1Shot = in1.readUTF()) == null) {
                    }
                    parseShot(p1Shot, 2);

                    // Player 2 shoots
                    String p2Shot;
                    while ((p2Shot = in2.readUTF()) == null) {
                    }
                    parseShot(p2Shot, 1);
                }

            }
            catch (IOException e) {
                System.out.println(e);
            }

        }

        public void parseShot(String shot, int player) {
            String[] array = shot.split(" ");
            int r = Integer.parseInt(array[0]);
            int c = Integer.parseInt(array[1]);
            board.shootPlayerBoard(player, r, c);
        }
    }
}