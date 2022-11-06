import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame implements ActionListener {

    public static void main(String[] args) {
        Game win = new Game();
        win.setSize(500, 500);
        win.setVisible(true);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Game() {
        super("Battleship");
        // center
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE);
        GridLayout grid = new GridLayout(1, 2);
        centerPanel.setLayout(grid);
        playerPanel = new PlayerPanel();
        playerPanel.setBackground(Color.GRAY);
        shootPanel = new ShootPanel();
        shootPanel.setBackground(Color.GRAY);
        centerPanel.add(playerPanel);
        centerPanel.add(shootPanel);
        // south
        JPanel southPanel = new JPanel();
        southPanel.setBackground(Color.WHITE);
        // frame
        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        add(southPanel, BorderLayout.SOUTH);
        add(centerPanel, BorderLayout.CENTER);
        // listeners

    }

    /**
     * actionPerformed
     * 
     * @param e
     *          responds to action events accordingly based on buttons selected
     */
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }
}
