package tictactoe;

import javax.swing.*;
import java.awt.*;


public class Cell extends JButton {
    private boolean isClicked;
    private String cellValue;

    public Cell(String name) {
        isClicked = false;
        cellValue = " ";
        setName(name);
//        name = name.replace("Button", "");
//        setText(name);
        setText(cellValue);
        setFocusPainted(false);
        setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
    }

    public void clicked(boolean turn) {
            if (turn) {
                cellValue = "X";
            } else {
                cellValue = "O";
            }
            setText(cellValue);
            isClicked = true;
        }

    public boolean isClickable() {
        return !isClicked;
    }

    public String getCellValue() {
        return cellValue;
    }

    public void setClicked() {
        isClicked = true;
    }

    public void setDefault() {
        cellValue = " ";
        setText(cellValue);
        isClicked = false;
    }
}
