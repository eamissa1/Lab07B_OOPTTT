public class Game
{
    private Board board;
    private String currentPlayer;

    public Game()
    {
        this.board = new Board();
        this.currentPlayer = "X"; // X starts by default
    }

    public boolean makeMove(int row, int col)
    {
        boolean moveMade = board.setMove(row, col, currentPlayer);
        if (moveMade)
        {
            switchPlayer();
        }
        return moveMade;
    }

    public void switchPlayer()
    {
        currentPlayer = currentPlayer.equals("X") ? "O" : "X";
    }

    public boolean isWin()
    {
        return board.isWin("X") || board.isWin("O");
    }

    public boolean isTie()
    {
        return board.isTie();
    }

    public void resetGame()
    {
        board.resetBoard();
        currentPlayer = "X";
    }

    public String getCurrentPlayer()
    {
        return currentPlayer;
    }

    public Board getBoard()
    {
        return board;
    }
}

