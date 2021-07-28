package tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeView extends JPanel {
    private JPanel gridPanel;
    private JButton reset;
    private PlayerButton pbutton1;
    private PlayerButton pbutton2;
    private JLabel label;
    private Cell[][] grid;
    private JPanel buttonPanel;
    private boolean toggleValue;
    private String winner;
    private int turnCount;

    public TicTacToeView() {
        toggleValue = false;
        turnCount = 0;
        setPreferredSize(new Dimension(400, 400));

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 0));
        pbutton1 = new PlayerButton();
        pbutton2 = new PlayerButton();
        buttonPanel.setPreferredSize(new Dimension(390, 50));
        buttonPanel.add(pbutton1);
        add(buttonPanel, BorderLayout.NORTH);

        gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(3,3));
        gridPanel.setPreferredSize(new Dimension(390, 300));
        createGrid();
        add(gridPanel);

        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());
        jp.setPreferredSize(new Dimension(390,50));

        label = new JLabel("Game is not started");
        label.setName("LabelStatus");
        jp.add(label, BorderLayout.WEST);

        reset = new JButton("Reset");
        reset.setName("ButtonReset");
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleValue = false;
                turnCount = 0;
                label.setText("Game is not started");
                for (Cell[] cell : grid) {
                    for (Cell c : cell) {
                        c.setDefault();
                    }
                }
            }
        });
        add(jp, BorderLayout.SOUTH);
        buttonPanel.add(reset);
        buttonPanel.add(pbutton2);

    }

    private void createGrid() {
        grid = new Cell[3][3];
        int n = 3;
        for (int i = 0; i < 3; i++, n--) {
            char a = 'A';
            for (int j = 0; j < 3; j++, a++) {
                grid[j][i] = new Cell("Button" + a + n);
                grid[j][i].setEnabled(false);
                int finalJ = j;
                int finalI = i;
                grid[j][i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (grid[finalJ][finalI].isClickable()) {
                            toggleValue = !toggleValue;
                            grid[finalJ][finalI].clicked(toggleValue);
                            turnCount++;
                            checkStatus();
                        }
                    }
                });
                gridPanel.add(grid[j][i]);
            }
        }
    }

    private void checkStatus() {
        if (checkForWin()) {
            label.setText(winner + " wins");
            noMoreClicks();
        } else if (turnCount == 9) {
            label.setText("Draw");
        } else {
            label.setText("Game in progress");
        }
    }

    private boolean checkForWin() {
        return (checkRows() || checkColumns() || checkDiagonals());
    }

    private boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(grid[i][0].getCellValue(), grid[i][1].getCellValue(), grid[i][2].getCellValue())) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(grid[0][i].getCellValue(), grid[1][i].getCellValue(), grid[2][i].getCellValue())) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals() {
        return ((checkRowCol(grid[0][0].getCellValue(), grid[1][1].getCellValue(), grid[2][2].getCellValue()))
                || (checkRowCol(grid[0][2].getCellValue(), grid[1][1].getCellValue(), grid[2][0].getCellValue())));
    }

    private boolean checkRowCol(String s1, String s2, String s3) {
        if ((!s1.equals(" ")) && (s1.equals(s2)) && (s2.equals(s3))) {
            winner = s1;
            return true;
        }
        return false;
    }

    private void noMoreClicks() {
        for (Cell[] cell : grid) {
            for (Cell c : cell) {
                c.setClicked();
            }
        }
    }
}
