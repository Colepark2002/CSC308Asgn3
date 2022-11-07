import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PlayerPanel extends BoardPanel implements ActionListener {



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

    public void placeShip()
    {

    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        int i = 0;
        int k;
        while( !e.getActionCommand().substring(0,1).equals(Alph[i]))
        {
            i +=1;
        }

        k = Integer.parseInt(e.getActionCommand().substring(1)) - 1;
        board[i][k].setBackground(Color.BLACK);
        System.out.println("Index" + " " + i + " " + k);
    }


}
