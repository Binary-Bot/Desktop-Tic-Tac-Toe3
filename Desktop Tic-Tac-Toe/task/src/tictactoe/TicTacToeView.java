package tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeView extends JPanel {
    private TicTacToeController controller;
    private Cell[][] grid;
    private boolean toggleValue;

    public TicTacToeView() {
        toggleValue = false;
        setLayout(new GridLayout(3,3));
        setPreferredSize(new Dimension(300, 300));
        createGrid();

    }

    private void createGrid() {
        grid = new Cell[3][3];
        int n = 3;
        for (int i = 0; i < 3; i++) {
            char a = 'A';
            for (int j = 0; j < 3; j++) {
                grid[j][i] = new Cell("Button" + a + n);
                int finalJ = j;
                int finalI = i;
                grid[j][i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println(e.getModifiers());
                        toggleValue = !toggleValue;
                        grid[finalJ][finalI].clicked(toggleValue);
                    }
                });
                add(grid[j][i]);
                a += 1;
            }
            n--;
        }
    }
    public void addController(TicTacToeController controller) {
        this.controller = controller;
    }
}
