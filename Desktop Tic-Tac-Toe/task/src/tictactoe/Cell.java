package tictactoe;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Cell extends JButton {

    public Cell(String name) {
        setName(name);
        name = name.replace("Button", "");
        setText(name);
    }

    public void clicked(boolean turn) {
        if (turn) {
            setText("X");
        } else {
            setText("O");
        }
    }

    private class mListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1) {

            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
