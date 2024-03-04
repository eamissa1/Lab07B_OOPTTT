import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TTTGUI extends JFrame
{
    private final int ROW = 3;
    private final int COL = 3;
    private JButton[][] buttons = new JButton[ROW][COL];
    private Game game;

    public static void main(String[] args)
    {
        javax.swing.SwingUtilities.invokeLater(() -> new TTTGUI());
    }
    public TTTGUI()
    {
        super("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLayout(new GridLayout(ROW, COL));

        game = new Game();
        ActionListener buttonListener = new ButtonListener();

        for (int i = 0; i < ROW; i++)
        {
            for (int j = 0; j < COL; j++)
            {
                JButton button = new JButton();
                buttons[i][j] = button;
                button.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
                button.setActionCommand(i + "," + j);
                button.addActionListener(buttonListener);
                add(button);
            }
        }
        setVisible(true);
    }

    private class ButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String command = e.getActionCommand();
            int row = Integer.parseInt(command.split(",")[0]);
            int col = Integer.parseInt(command.split(",")[1]);
            JButton button = buttons[row][col];

            if (game.makeMove(row, col))
            {
                button.setText(game.getCurrentPlayer().equals("X") ? "O" : "X"); // Update UI to reflect the last player
                if (game.isWin())
                {
                    JOptionPane.showMessageDialog(null, "Player " + (game.getCurrentPlayer().equals("X") ? "O" : "X") + " wins!");
                    resetGame();
                } else if (game.isTie()) {
                    JOptionPane.showMessageDialog(null, "The game is a tie!");
                    resetGame();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid move! The cell is already occupied.");
            }
        }
    }

    private void resetGame()
    {
        game.resetGame();
        for (int i = 0; i < ROW; i++)
        {
            for (int j = 0; j < COL; j++)
            {
                buttons[i][j].setText("");
            }
        }
    }
}

