import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ShootPanel extends BoardPanel{

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

        board[i][k].setBackground(Color.WHITE);
        System.out.println("Index" + " " + i + " " + k);
    }

    public Color sendShot(int r, int c){
        Color marker = Color.WHITE;
        /*


        BlackBoard enemy = BlackBoard.getBoard();
        BoardPanel enemyBoard = enemy.getEnemyBoard();
        if (enemyBoard.board[r][c].getBackground().equals(Color.Black)){
            marker = Color.RED
        }
         */
        return marker;
    }
}
