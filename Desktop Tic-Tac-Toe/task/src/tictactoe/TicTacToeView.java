package tictactoe;

import javax.swing.*;

public class TicTacToeView extends JPanel {
    private TicTacToeController controller;

    public void addController(TicTacToeController controller) {
        this.controller = controller;
    }
}
