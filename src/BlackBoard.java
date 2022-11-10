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
        player1Board = new PlayerPanel();
        player2Board = new PlayerPanel();
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


    public void shootPlayerBoard(int boardNum, int r, int c){
        setChanged();
        if(boardNum == 1) {
            player1Board.receiveShot(r, c);
        }
        else{
            player2Board.receiveShot(r,c);
        }
        notifyObservers();
    }


    @Override
    public void notifyObservers(){
        //not sure what to put here ATM, but this will be called after either player has shot the other,
        //this will then notify the players that a board has changed so that both players can update their boards.
    }
}
