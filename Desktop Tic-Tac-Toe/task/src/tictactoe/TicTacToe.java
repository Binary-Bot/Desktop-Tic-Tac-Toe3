package tictactoe;

import javax.swing.*;

public class TicTacToe extends JFrame {
    public TicTacToe() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tic Tac Toe");
        setSize(300, 300);
        //setLayout(null);

        TicTacToeModel model = new TicTacToeModel();
        TicTacToeView view = new TicTacToeView();
        TicTacToeController controller = new TicTacToeController(model, view);

        getContentPane().add(view);
        pack();
        setVisible(true);
    }
}