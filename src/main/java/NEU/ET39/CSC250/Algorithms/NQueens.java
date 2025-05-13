package NEU.ET39.CSC250.Algorithms;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public static List<char[][]> solveNQueens(int n) {
        List<char[][]> solutions = new ArrayList<>(); // List to store all solutions
        char[][] board = new char[n][n]; // 2D array to represent the chessboard

        // Initialize the board with empty cells
        for (int i = 0; i < n; i++) { // O(n)
            for (int j = 0; j < n; j++) { // O(n)
                board[i][j] = '.';
            }
        }

        solve(board, 0, solutions, n); // Start solving from the first row
        return solutions; // Return all found solutions
    }

    private static void solve(char[][] board, int row, List<char[][]> solutions, int n) {
        if (row == n) { // All queens are placed successfully
            // Add a deep copy of the board to solutions
            char[][] solution = new char[n][n]; // O(n)
            for (int i = 0; i < n; i++) { // O(n)
                solution[i] = board[i].clone(); // O(n) - cloning each row
            }
            solutions.add(solution); // O(1) - adding to the list
            return; // Found a valid solution
        }

        for (int col = 0; col < n; col++) { // O(n) - iterate through columns
            if (isValidPlacement(board, row, col, n)) { // O(n) - check if the placement is valid
                placeQueen(board, row, col); // Place the queen
                solve(board, row + 1, solutions, n); // Recurse to the next row
                removeQueen(board, row, col); // Backtrack
            }
        }
    }

    private static boolean isValidPlacement(char[][] board, int row, int col, int n) {
        // Check vertical column
        for (int r = 0; r < row; r++) { // O(n)
            if (board[r][col] == 'Q') { // Check if there's a queen in the same column
                return false;
            }
        }

        // Check top-left diagonal
        int r = row - 1, c = col - 1; // row - 1, col - 1
        while (r >= 0 && c >= 0) { // O(n)
            if (board[r][c] == 'Q') { // Check if there's a queen in the left diagonal
                return false; // Invalid placement
            }
            r--; // Move up
            c--; // Move left
        }

        // Check top-right diagonal
        r = row - 1; // row - 1 - move up
        c = col + 1; // col + 1 - move right
        while (r >= 0 && c < n) { // O(n) - check within bounds
            if (board[r][c] == 'Q') { // Check if there's a queen in the right diagonal
                return false;
            }
            r--; // Move up
            c++; // Move right
        }

        return true; // Valid placement
    }

    private static void placeQueen(char[][] board, int row, int col) {
        board[row][col] = 'Q'; // Place the queen on the board
    }

    private static void removeQueen(char[][] board, int row, int col) {
        board[row][col] = '.'; // Remove the queen from the board
    }

    public static void main(String[] args) {
        int n = 16; //  input
        List<char[][]> solutions = solveNQueens(n);

        // Print all solutions
        for (char[][] solution : solutions) {
            for (char[] row : solution) {
                System.out.println(new String(row));
            }
            System.out.println();
        }

        System.out.println("Total solutions: " + solutions.size());
    }
}
