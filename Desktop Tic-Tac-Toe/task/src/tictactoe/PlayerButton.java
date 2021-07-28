package tictactoe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerButton extends JButton implements ActionListener {
    private boolean toggleValue = true;

    public PlayerButton() {
        setText("Human");
        setFocusPainted(false);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        toggleValue = !toggleValue;
        if (toggleValue) {
            setText("Human");
        } else {
            setText("Robot");
        }
    }
}
