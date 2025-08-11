import java.util.*;

public class LC36_ValidSodoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int r = 0; r < 9; r++){
            for (int c = 0; c < 9; c++){
                char ch = board[r][c];
                if (ch == '.') continue;

                int d = ch - '1'; // Convert char num to int for use as index in boolean arrays
                int b = (r / 3) * 3 + (c / 3);

                if (rows[r][d] || cols[c][d] || boxes[b][d]) return false;

                rows[r][d] = cols[c][d] = boxes[b][d] = true;
            }
        }
        return true;
    }
}
