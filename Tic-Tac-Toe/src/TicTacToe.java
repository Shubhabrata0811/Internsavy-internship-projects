import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame implements ActionListener {
    JButton[][] buttons;
    
    char currentPlayer;
    JLabel statusLabel;

    JButton bReset = new JButton("Reset");

    public TicTacToe() {

        buttons = new JButton[3][3];
        currentPlayer = 'X';

        JPanel panel = new JPanel(new GridLayout(3, 3));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 50));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].addActionListener(this);
                panel.add(buttons[i][j]);
            }
        }

        statusLabel = new JLabel("Player " + currentPlayer + "'s turn");
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(panel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.NORTH);

        bReset.setBackground(Color.RED);
        bReset.setForeground(Color.WHITE);
        bReset.setFont(new Font("Osward",Font.BOLD,18));
        bReset.setHorizontalAlignment(SwingConstants.CENTER);
        bReset.addActionListener(this);
        add(bReset, BorderLayout.SOUTH);

        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();

        if (clickedButton.getText().equals("")) {
            clickedButton.setText(String.valueOf(currentPlayer));
            clickedButton.setEnabled(false);
            if (checkWin()) {
                statusLabel.setText("Player " + currentPlayer + " wins!");
                JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " wins!");
                disableAllButtons();
            } else if (isBoardFull()) {
                statusLabel.setText("It's a draw!");
                JOptionPane.showMessageDialog(null, "It's a draw!");
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                statusLabel.setText("Player " + currentPlayer + "'s turn");
            }
        }
        if(clickedButton == bReset){
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    buttons[i][j].setText("");
                    buttons[i][j].setEnabled(true);
                }
            }
            currentPlayer = 'X';
            statusLabel.setText("Player " + currentPlayer + "'s turn");
        }
    }

    private boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            // Horizontal win
            if (buttons[i][0].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[i][1].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[i][2].getText().equals(String.valueOf(currentPlayer))) {
                return true; 
            }

            // Vertical win
            if (buttons[0][i].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[1][i].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[2][i].getText().equals(String.valueOf(currentPlayer))) {
                return true;
            }
        }

        // Diagonal win (top-left to bottom-right)
        if (buttons[0][0].getText().equals(String.valueOf(currentPlayer)) &&
            buttons[1][1].getText().equals(String.valueOf(currentPlayer)) &&
            buttons[2][2].getText().equals(String.valueOf(currentPlayer))) {
            return true;
        }

        // Diagonal win (top-right to bottom-left)
        if (buttons[0][2].getText().equals(String.valueOf(currentPlayer)) &&
            buttons[1][1].getText().equals(String.valueOf(currentPlayer)) &&
            buttons[2][0].getText().equals(String.valueOf(currentPlayer))) {
            return true;
        }

        return false;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    private void disableAllButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }

    public static void main(String[] args) {
        new TicTacToe();
    }
}