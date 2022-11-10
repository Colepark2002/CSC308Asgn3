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
            Socket player2 = server.accept();

            System.out.println("New client connected" + player1.getInetAddress().getHostAddress());
            System.out.println("New client connected" + player2.getInetAddress().getHostAddress());

            ClientHandler p1Sock = new ClientHandler(player1);
            ClientHandler p2Sock = new ClientHandler(player2);

            new Thread(p1Sock).start();
            new Thread(p2Sock).start();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (server != null) {
                try {
                    server.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private static class ClientHandler implements Runnable {
        private final Socket clientSocket;
        private BlackBoard board;

        public ClientHandler(Socket socket)
        {
            this.clientSocket = socket;
            board = BlackBoard.getInstance();
        }

        public void run()
        {
            PrintWriter out = null;
            BufferedReader in = null;
            try {

                out = new PrintWriter(clientSocket.getOutputStream(), true);

                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                // do something
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    if (out != null) {
                        out.close();
                    }
                    if (in != null) {
                        in.close();
                        clientSocket.close();
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}