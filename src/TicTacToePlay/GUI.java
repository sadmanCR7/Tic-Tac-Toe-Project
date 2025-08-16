package TicTacToePlay;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private JButton[][] buttons = new JButton[3][3];
    private JLabel statusLabel = new JLabel("Player 1's turn");
    private Game game;

    public GUI(Game game) {
        this.game = game;
        setTitle("Tic-Tac-Toe");
        setSize(300, 350);
        setLayout(new GridLayout(4, 3));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton(" ");
                int row = i, col = j;
                buttons[i][j].addActionListener(e -> handleMove(row, col));
                add(buttons[i][j]);
            }
        }
        add(statusLabel);
        setVisible(true);
    }

    private void handleMove(int row, int col) {
        if (game.playTurn(row, col)) {
            buttons[row][col].setText(String.valueOf(game.getCurrentPlayer().symbol));
            statusLabel.setText(game.getStatusMessage());
        }
    }
}
