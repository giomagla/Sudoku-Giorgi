import javax.swing.*;
import java.awt.*;
class Board{
    private final JFrame frame;
    private final JPanel grid;
    private final JTextField[][] textFields;
    private final int[][] board;

    public Board(int[][] board) {    //constructor
        this.board = board;
        frame = new JFrame("Sudoku Board");
        grid = new JPanel();
        textFields = new JTextField[9][9];
        grid.setLayout(new GridLayout(9, 9));
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public  void setBoard(){
        grid.removeAll();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                textFields[row][col] = new JTextField();
                textFields[row][col].setHorizontalAlignment(JTextField.CENTER); // Center align text
                textFields[row][col].setFont(new Font("Arial", Font.BOLD, 18)); // Set font size
                textFields[row][col].setText(String.valueOf(board[row][col])); // Initially, cells are empty
                grid.add(textFields[row][col]); // Add to the grid panel
            }
        }
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                int top = 1, left = 1, bottom = 1, right = 1;

                // Thicker borders for the grid's outer edges
                if (row == 0) top = 4; // Top border
                if (col == 0) left = 4; // Left border
                if (row == 8) bottom = 4; // Bottom border
                if (col == 8) right = 4; // Right border

                // Thicker borders for the internal 3x3 subgrid boundaries
                if (row % 3 == 0 && row != 0) top = 4; // Horizontal subgrid boundary
                if (col % 3 == 0 && col != 0) left = 4; // Vertical subgrid boundary

                // Set the border for the cell
                textFields[row][col].setBorder(BorderFactory.createMatteBorder(top, left, bottom, right, Color.BLACK));
            }
        }
        frame.add(grid);
        frame.setVisible(true);
    }
}