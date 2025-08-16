package TicTacToePlay;

import javax.swing.*;

public class Game {
    private Player player1, player2, currentPlayer;
    private Board board;

    public Game(String player1Name, String player2Name) {
        player1 = new Player(player1Name, 'X');
        player2 = new Player(player2Name, 'O');
        currentPlayer = player1;
        board = new Board();
    }

    public boolean playTurn(int row, int col) {
        if (board.makeMove(row, col, currentPlayer.symbol)) {
            if (board.checkWin(currentPlayer.symbol)) {
                DatabaseManager.saveGameResult(player1.name, player2.name, currentPlayer.name);
                JOptionPane.showMessageDialog(null, currentPlayer.name + " wins!");
                System.exit(0);
            }
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
            return true;
        }
        return false;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public String getStatusMessage() {
        return currentPlayer.name + "'s turn";
    }
}

