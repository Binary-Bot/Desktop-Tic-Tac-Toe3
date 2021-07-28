package tictactoe;

import javax.swing.*;

public class TicTacToe extends JFrame {
    public TicTacToe() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tic Tac Toe");
        setSize(400, 400);
        //setLayout(null);

        TicTacToeView view = new TicTacToeView();


        getContentPane().add(view);
        pack();
        setVisible(true);
    }
}