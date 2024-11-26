import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[][] initialBoard = {{5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9},
        };
        game(initialBoard,s);

    }
    public static void game(int[][] initialBoard,Scanner s){
        Board board = new Board(initialBoard);
        Sudoku solving = new Sudoku(initialBoard);
        System.out.println("type 'play' to display the board");
        String input = s.nextLine();
        if (input.equals("play")) {
            board.setBoard();
            solving.solveSudoku();
            System.out.println("if you like puzzle to be solved press 1");
            int answer = s.nextInt();
            if (answer == 1) {
                board.setBoard();
            }
        }
    }
}
