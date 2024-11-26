class Sudoku {
    private final int[][] board;
    public Sudoku(int[][] board){
        this.board = board;
    }
    public  boolean solveSudoku() {
        boolean solvable = isValidSudoku(this.board);
        if (!solvable) {
            System.out.println("Not possible to solve");
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (this.board[i][j] == 0) { // If cell is empty
                    for (int num = 1; num <= 9; num++) { // Try numbers 1 to 9
                        if (isValidMove(this.board, i, j, num)) {
                            this.board[i][j] = num; // Place the number
                            if (solveSudoku()) {
                                return true; // Solution found
                            }
                            this.board[i][j] = 0; // Undo move (backtrack)
                        }
                    }
                    return false; // No valid number found for this cell
                }
            }
        }
        return true;
    }
    public static boolean isValidMove(int[][] board,int row,int col,int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num && i != col) {
                return false;
            }
            if (board[i][col] == num && i != row) {
                return false;
            }
        }
        int subGridRowStart = (row / 3) * 3;
        int subGridColStart = (col / 3) * 3;

        for (int i = subGridRowStart; i < subGridRowStart + 3; i++) {
            for (int j = subGridColStart; j < subGridColStart + 3; j++) {
                if (board[i][j] == num && board[i][j] != board[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isValidSudoku(int[][] board) {
        boolean isValid = true;
        int rows = 0;
        while (isValid && rows < 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = i + 1; j < 9; j++) {
                    //check for columns and rows
                    if (board[rows][i] == board[rows][j] && board[rows][i] != 0 ||
                            board[i][rows] == board[j][rows] && board[i][rows] != 0) {
                        isValid = false;
                        break;
                    }
                }
            }
            rows++;
        }
        for (int i = 0; i < 9; i+=3) {
            for (int j = 0; j < 9; j+=3) {
                isValid = isValidSSubGrid(board,i,j);
            }
        }
        return isValid;
    }
    public static boolean isValidSSubGrid(int[][] board,int row,int column) {
        int subGridRowStart = (row / 3) * 3;
        int subGridColumnStart = (column / 3) * 3;

        for (int i = subGridRowStart; i < subGridRowStart + 3; i++) {
            for (int j = subGridColumnStart; j < subGridColumnStart + 3; j++) {
                for (int k = subGridRowStart; k < subGridRowStart + 3; k++) {
                    for (int l = subGridColumnStart; l < subGridColumnStart + 3; l++) {
                        if ((i != k || j != l) && board[i][j] != 0 &&
                                board[i][j] == board[k][l]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
