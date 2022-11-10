import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

public class ShootPanel extends BoardPanel implements Observer {
    int r, c;
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        r = 0;
        while( !e.getActionCommand().substring(0,1).equals(Alph[i]))
        {
            r +=1;
        }

        c = Integer.parseInt(e.getActionCommand().substring(1)) - 1;

        board[r][c].setBackground(Color.WHITE);
        sendShot(r, c);

        System.out.println("Index" + " " + r + " " + c);
    }

    public void sendShot(int r, int c){
        BlackBoard enemyBoard= BlackBoard.getInstance();
        enemyBoard.shootPlayerBoard(2, r, c );
    }

    @Override
    public void update(Observable o, Object arg) {
        BlackBoard bboard = BlackBoard.getInstance();
        Color col = Color.WHITE;
        if (bboard.getHit()){
            col = Color.RED;
        }
        board[r][c].setBackground(col);
    }
}
