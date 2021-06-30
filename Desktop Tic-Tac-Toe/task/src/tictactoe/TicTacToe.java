package tictactoe;

import javax.swing.*;

public class TicTacToe extends JFrame {
    public TicTacToe() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setVisible(true);
        setLayout(null);

        TicTacToeModel model = new TicTacToeModel();
        TicTacToeView view = new TicTacToeView();
        TicTacToeController controller = new TicTacToeController(model, view);

        getContentPane().add(view);
    }
}