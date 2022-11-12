import java.util.Observable;
/**
 * Serves as the Singleton that holds both player's board
 *
 * @author  Jacob Shapero
 * @version 1.0
 * @since   2022-11-9
 */
public class BlackBoard extends Observable{
    PlayerPanel player1Board, player2Board;
    boolean hit;
    private static BlackBoard instance;


    protected BlackBoard(){
        player1Board = new PlayerPanel();
        player2Board = new PlayerPanel();
    }


    public PlayerPanel getBoard(int playerNum){
        if(playerNum == 1){
            return player1Board;
        }
        else{
            return player2Board;
        }
    }


    public static BlackBoard getInstance(){
        if(instance == null){
            instance = new BlackBoard();
        }
        return instance;
    }

    public boolean getHit(){
        return hit;
    }


    public void shootPlayerBoard(int boardNum, int r, int c){
        setChanged();
        if(boardNum == 1) {
            hit = player1Board.receiveShot(r, c);
        }
        else{
            hit = player2Board.receiveShot(r,c);
        }
        notifyObservers();
    }

}
