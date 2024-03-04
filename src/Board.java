public class Board
{
    private String[][] board;
    private final int size = 3;

    public Board()
    {
        this.board = new String[size][size];
        resetBoard();
    }

    public void resetBoard()
    {
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                board[i][j] = null;
            }
        }
    }

    public boolean setMove(int row, int col, String player)
    {
        if (board[row][col] == null)
        {
            board[row][col] = player;
            return true;
        }
        return false;
    }

    public boolean isWin(String player)
    {
        for (int i = 0; i < size; i++)
        {
            if (checkRow(i, player) || checkColumn(i, player))
                return true;
        }
        return checkDiagonals(player);
    }

    public boolean isTie()
    {
        for (String[] row : board)
        {
            for (String cell : row)
            {
                if (cell == null) return false;
            }
        }
        return !isWin("X") && !isWin("O");
    }

    private boolean checkRow(int row, String player)
    {
        for (int col = 0; col < size; col++)
        {
            if (!player.equals(board[row][col])) return false;
        }
        return true;
    }

    private boolean checkColumn(int col, String player)
    {
        for (int row = 0; row < size; row++)
        {
            if (!player.equals(board[row][col])) return false;
        }
        return true;
    }

    private boolean checkDiagonals(String player)
    {
        boolean diagonal1 = true, diagonal2 = true;
        for (int i = 0; i < size; i++)
        {
            diagonal1 &= player.equals(board[i][i]);
            diagonal2 &= player.equals(board[i][size - i - 1]);
        }
        return diagonal1 || diagonal2;
    }
}
