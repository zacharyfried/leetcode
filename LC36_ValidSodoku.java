import java.util.*;

public class LC36_ValidSodoku {
    public boolean isValidSudoku(char[][] board) {
        int rStart = 0;
        int cStart = 0;

        for (int type = 1; type < 10; type++){
            switch(type){
                case 1:
                    break;
                case 2:
                    rStart = 3;
                    cStart = 0;
                    break;
                case 3:
                    rStart = 6;
                    cStart = 0;
                    break;
                case 4:
                    rStart = 0;
                    cStart = 3;
                    break;
                case 5:
                    rStart = 3;
                    cStart = 3;
                    break;
                case 6:
                    rStart = 6;
                    cStart = 3;
                    break;
                case 7:
                    rStart = 0;
                    cStart = 6;
                    break;
                case 8:
                    rStart = 3;
                    cStart = 6;
                    break;
                case 9:
                    rStart = 6;
                    cStart = 6;
            }


            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < 9; i++){
                set.add((char) ('1' + i));
            }
            for (int row = rStart; row < rStart + 3; row++){
                for (int col = cStart; col < cStart + 3; col++){
                    if (!set.remove(board[row][col]) && board[row][col] != '.'){
                        return false;
                    }
                }
            }
        }

        HashSet<Character> set;

        // Do Rows
        for (int row = 0; row < 9; row++){
            set = new HashSet<>();
            for (int i = 0; i < 9; i++){
                set.add((char) ('1' + i));
            }
            for (int col = 0; col < 9; col++){
                if (!set.remove(board[row][col]) && board[row][col] != '.'){
                    return false;
                }
            }
        }

        // Do Cols
        for (int col = 0; col < 9; col++){
            set = new HashSet<>();
            for (int i = 0; i < 9; i++){
                set.add((char) ('1' + i));
            }
            for (int row = 0; row < 9; row++){
                if (!set.remove(board[row][col]) && board[row][col] != '.'){
                    return false;
                }
            }
        }


        return true;
    }
}
