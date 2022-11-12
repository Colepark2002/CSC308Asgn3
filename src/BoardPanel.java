import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class BoardPanel extends JPanel implements ActionListener, Observer {
    JButton[][] board = new JButton[10][10];
    String[] Alph = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
    int player;
    Client client;

    public BoardPanel() {
        GridLayout g = new GridLayout(10, 10);
        setLayout(g);
        client = new Client();
        player = client.getPlayerNum();
        for (int i = 0; i < 10; i++) {
            for (int k = 0; k < 10; k++) {
                board[i][k] = new JButton(Alph[i] + (1 + k));
                board[i][k].setBackground(new Color(70, 143, 175));
                add(board[i][k]);
                board[i][k].addActionListener(this);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void update(Observable o, Object arg) {
    }

    public JButton[][] getBoard() {
        return board;
    }
}
