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
        GridLayout grid = new GridLayout(2, 1);
        centerPanel.setLayout(grid);

        PlayerPanel player = new PlayerPanel();
        player.setBackground(Color.GRAY);
        ShootPanel shoot = new ShootPanel();
        shoot.setBackground(Color.GRAY);

        centerPanel.add(shoot);
        centerPanel.add(player);
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
