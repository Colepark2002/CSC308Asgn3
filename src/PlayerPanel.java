import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PlayerPanel extends BoardPanel {

    int ShipPieces = 17;
    boolean placingShips = true;
    boolean first = true;
    int[] start = new int[2];
    int[] shipSize = { 5, 4, 3, 3, 2 };
    int shipInd = 0;

    public PlayerPanel() {
        placeShips();
    }

    /**
     * Returns the amount of ship pieces left
     * @return int
     */
    public int getShipPieces() {
        return ShipPieces;
    }

    /**
     * Allows the Panel to receive a shot and update its board and indicate if the shot was a hit or miss
     * @param i determines row to select in board
     * @param k determines column to select in board
     * @return boolean if the shot hit or not
     */
    public boolean receiveShot(int i, int k) {
        if (board[i][k].getBackground().equals(Color.BLACK)) {
            board[i][k].setBackground(Color.red);
            ShipPieces--;
            return true;
        } else {
            board[i][k].setBackground(Color.WHITE);
            return false;
        }

    }

    /**
     * Sends Messages to the User in dialog boxes explaining how to place ships
     */
    public void placeShips() {
        JOptionPane.showMessageDialog(this, "Now you can place your ships");
        JOptionPane.showMessageDialog(this,
                "Place your ship by clicking a start location and then a direction to place the rest of it");
        JOptionPane.showMessageDialog(this, "Start by placing your battleship " + shipSize[shipInd] + " X 1");
    }

    /**
     * Allows the User to place ships by indicating a index and direction
     * @param startIndex where to start placing the ship
     * @param dir the direction in which the ship will be placed
     */
    public void placeShip(int[] startIndex, String dir) {
        switch (dir) {
            case "up":
                if (startIndex[0] - (shipSize[shipInd] - 1) < 0) {
                    JOptionPane.showMessageDialog(this, "invalid direction try again");
                    first = false;
                } else {
                    for (int i = 0; i < shipSize[shipInd]; i++) {
                        board[startIndex[0] - i][startIndex[1]].setBackground(Color.BLACK);
                    }
                }
                break;

            case "down":
                if (startIndex[0] + (shipSize[shipInd] - 1) > 9) {
                    JOptionPane.showMessageDialog(this, "invalid direction try again");
                    first = false;
                } else {
                    for (int i = 0; i < shipSize[shipInd]; i++) {
                        board[startIndex[0] + i][startIndex[1]].setBackground(Color.BLACK);
                    }
                }
                break;

            case "left":
                if (startIndex[1] - (shipSize[shipInd] - 1) < 0) {
                    JOptionPane.showMessageDialog(this, "invalid direction try again");
                    first = false;
                } else {
                    for (int i = 0; i < shipSize[shipInd]; i++) {
                        board[startIndex[0]][startIndex[1] - i].setBackground(Color.BLACK);
                    }
                }
                break;

            case "right":
                if (startIndex[1] + (shipSize[shipInd] - 1) > 9) {
                    JOptionPane.showMessageDialog(this, "invalid direction try again");
                    first = false;
                } else {
                    for (int i = 0; i < shipSize[shipInd]; i++) {
                        board[startIndex[0]][startIndex[1] + i].setBackground(Color.BLACK);
                    }
                }
                break;
        }
        if (first) {
            shipInd++;
            if (shipInd >= 5) {
                placingShips = false;
                JOptionPane.showMessageDialog(this, "All ships are placed");
            } else
                JOptionPane.showMessageDialog(this, "Next place your ship of size " + shipSize[shipInd] + " X 1");
        }

    }

    /**
     * Override of the ActionListener method and allows certain actions to be done to place ships
     * @param e an Action even
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (placingShips && !(e.getActionCommand().equals("OK"))) {
            int i = 0;
            int k;
            while (!e.getActionCommand().substring(0, 1).equals(Alph[i])) {
                i += 1;
            }

            k = Integer.parseInt(e.getActionCommand().substring(1)) - 1;
            if (first) {
                start[0] = i;
                start[1] = k;
                first = false;
            } else {
                first = true;
                String dir = "";

                if (i > start[0] && k == start[1]) {
                    dir = "down";
                    placeShip(start, dir);
                } else if (i < start[0] && k == start[1]) {
                    dir = "up";
                    placeShip(start, dir);
                } else if (i == start[0] && k < start[1]) {
                    dir = "left";
                    placeShip(start, dir);
                } else if (i == start[0] && k > start[1]) {
                    dir = "right";
                    placeShip(start, dir);
                } else {
                    JOptionPane.showMessageDialog(this, "invalid direction try again");
                    first = false;
                }
                System.out.println(dir);
            }
            System.out.println("Index" + " " + i + " " + k);

        }

    }

}
