import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MinesweeperGUI extends JFrame {
    MineField mineField;
    JButton[][] buttons;
    int success = 0;
    int target;

    public MinesweeperGUI(int row, int col) {
        this.mineField = new MineField(row, col);
        this.mineField.prepareGame();
        this.buttons = new JButton[row][col];
        this.target = mineField.size - (mineField.size / 4);

        setTitle("Minesweeper Professional");
        setLayout(new GridLayout(row, col));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                buttons[i][j] = new JButton("-");
                int r = i;
                int c = j;

                buttons[i][j].addActionListener(e -> handleMove(r, c));
                add(buttons[i][j]);
            }
        }

        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void handleMove(int r, int c) {
        if (mineField.map[r][c] == -1) {
            revealAll();
            JOptionPane.showMessageDialog(this, "Game Over! You hit a mine.");
            System.exit(0);
        } else {
            if (buttons[r][c].isEnabled()) {
                int count = mineField.checkMine(r, c);
                buttons[r][c].setText(String.valueOf(count));
                buttons[r][c].setEnabled(false);
                buttons[r][c].setBackground(Color.LIGHT_GRAY);
                success++;

                if (success == target) {
                    JOptionPane.showMessageDialog(this, "Congratulations! You won.");
                    revealAll();
                }
            }
        }
    }

    private void revealAll() {
        for (int i = 0; i < mineField.rowNumber; i++) {
            for (int j = 0; j < mineField.colNumber; j++) {
                if (mineField.map[i][j] == -1) {
                    buttons[i][j].setText("X");
                    buttons[i][j].setBackground(Color.RED);
                }
            }
        }
    }

    public static void main(String[] args) {
        new MinesweeperGUI(10, 10);
    }
}