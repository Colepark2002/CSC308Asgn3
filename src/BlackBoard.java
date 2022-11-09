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

    public static BlackBoard getInstance(){
        if(instance == null){
            instance = new BlackBoard();
        }
        return instance;
    }


    @Override
    public void notifyObservers(){
        //not sure what to put here ATM.
    }
}
