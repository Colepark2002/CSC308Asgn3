import javax.swing.*;
import java.util.Observable;

public class BlackBoard extends Observable {
    BoardPanel player1Board, player2Board;
    private static BlackBoard instance;

    protected BlackBoard(){
        player1Board = new BoardPanel();
        player2Board = new BoardPanel();

    }


    public BoardPanel getBoard(int playerNum){
        if(playerNum == 1){
            return player1Board;
        }
        else{
            return player2Board;
        }
    }

    public void notifyObservers(){

    }


    public static BlackBoard getInstance(){
        if(instance == null){
            instance = new BlackBoard();
        }
        return instance;
    }
}
