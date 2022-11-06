import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Stack;

public class PlayerPanel extends BoardPanel implements MouseListener, ActionListener {



    int ShipPieces = 17;

    public PlayerPanel()
    {
    }

    public int getShipPieces() {
        return ShipPieces;
    }
    public boolean receiveShot(int i, int k)
    {
        if (board[i][k].getBackground().equals(Color.BLACK)) {
            board[i][k].setBackground(Color.red);
            ShipPieces--;
            return true;
        }
        else
        {
            board[i][k].setBackground(Color.WHITE);
            return false;
        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}
