package TicTacToePlay;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String player1 = JOptionPane.showInputDialog("Enter Player 1 Name:");
        String player2 = JOptionPane.showInputDialog("Enter Player 2 Name:");
        Game game = new Game(player1, player2);
        new GUI(game);
    }
}
