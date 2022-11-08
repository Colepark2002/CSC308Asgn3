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
        Border border = BorderFactory.createLineBorder(Color.black);
        centerPanel.setBorder(border);
        centerPanel.setLayout(grid);

        JPanel xaxis = new JPanel();
        GridLayout xgrid = new GridLayout(1, 10);
        xaxis.setLayout(xgrid);
        JPanel yaxis = new JPanel();
        GridLayout ygrid = new GridLayout(10, 1);
        yaxis.setLayout(ygrid);

        JPanel xaxis2 = new JPanel();
        GridLayout xgrid2 = new GridLayout(1, 10);
        xaxis2.setLayout(xgrid2);
        JPanel yaxis2 = new JPanel();
        GridLayout ygrid2 = new GridLayout(10, 1);
        yaxis2.setLayout(ygrid2);

        String[] values = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
        String[] letters = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
        for (int i = 0; i < 10; i++) {
            JLabel value = new JLabel(values[i]);
            JLabel value2 = new JLabel(values[i]);
            JLabel letter = new JLabel(letters[i]);
            JLabel letter2 = new JLabel(letters[i]);
            xaxis.add(value);
            xaxis2.add(value2);
            yaxis.add(letter);
            yaxis2.add(letter2);
        }

        JPanel subPanel1 = new JPanel();
        BorderLayout layout1 = new BorderLayout();
        subPanel1.setLayout(layout1);
        subPanel1.setBackground(Color.BLUE);
        subPanel1.setBorder(border);
        JPanel topPadding1 = new JPanel();
        JPanel rightPadding1 = new JPanel();
        PlayerPanel player = new PlayerPanel();
        subPanel1.add(player, BorderLayout.CENTER);
        subPanel1.add(xaxis, BorderLayout.NORTH);
        subPanel1.add(yaxis, BorderLayout.WEST);
        subPanel1.add(rightPadding1, BorderLayout.EAST);
        subPanel1.add(topPadding1, BorderLayout.SOUTH);

        JPanel subPanel2 = new JPanel();
        BorderLayout layout2 = new BorderLayout();
        subPanel2.setLayout(layout2);
        subPanel2.setBackground(Color.BLUE);
        subPanel2.setBorder(border);
        ShootPanel shoot = new ShootPanel();
        JPanel topPadding2 = new JPanel();
        JPanel rightPadding2 = new JPanel();
        subPanel2.add(shoot, BorderLayout.CENTER);
        subPanel2.add(xaxis2, BorderLayout.NORTH);
        subPanel2.add(yaxis2, BorderLayout.WEST);
        subPanel2.add(rightPadding2, BorderLayout.EAST);
        subPanel2.add(topPadding2, BorderLayout.SOUTH);

        centerPanel.add(subPanel1);
        centerPanel.add(subPanel2);

        // frame
        BorderLayout mainLayout = new BorderLayout();
        setLayout(mainLayout);
        add(centerPanel, BorderLayout.CENTER);
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
