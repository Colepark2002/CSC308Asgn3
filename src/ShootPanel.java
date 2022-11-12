import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;


/**
 * The Panel in charge of dealing with the s
 *
 * @author Van Park
 * @version 1.0
 * @since 2022-11-9
 */
public class ShootPanel extends BoardPanel implements Observer {
    int r, c;

    /**
     * This function deals with when one of the buttons on the shoot panel is clicked
     * @param e this is the action that called the method
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        r = 0;
        while( !e.getActionCommand().substring(0,1).equals(Alph[r]))
        {
            r +=1;
        }

        c = Integer.parseInt(e.getActionCommand().substring(1)) - 1;
        sendShot(r, c);

        System.out.println("Index" + " " + r + " " + c);
    }

    /**
     * This function sends the shot made by the player to the server.
     * @param r the row for the selected shot
     * @param c the column for the selected shot
     */
    public void sendShot(int r, int c){
        client.sendOutput("" + r + " " + c);
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
