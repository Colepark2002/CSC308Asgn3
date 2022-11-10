import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

public class ShootPanel extends BoardPanel implements Observer {

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        int i = 0;
        int k;
        while( !e.getActionCommand().substring(0,1).equals(Alph[i]))
        {
            i +=1;
        }

        k = Integer.parseInt(e.getActionCommand().substring(1)) - 1;

        board[i][k].setBackground(sendShot(i, k));
        System.out.println("Index" + " " + i + " " + k);
    }

    public Color sendShot(int r, int c){
        Color marker = Color.WHITE;
        /*
        BlackBoard enemyBoard= BlackBoard.getInstance();
        enemyBoard.shootPlayerBoard(2, r, c );

         */
        return marker;
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
