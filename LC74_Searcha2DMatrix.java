public class LC74_Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        final int ROWS = matrix.length;
        final int COLS = matrix[0].length;

        int top = 0;
        int bot = ROWS - 1;
        int row = 0;

        while (top <= bot){
            row = (top + bot) / 2;
            if (target > matrix[row][COLS - 1]){
                top = row + 1;
            } else if (target < matrix[row][0]){
                bot = row - 1;
            } else {
                break;
            }
        }

        if (top > bot) return false;

        int l = 0;
        int r = COLS - 1;

        while (l <= r){
            int m = (l + r) / 2;
            if (target > matrix[row][m]){
                l = m + 1;
            } else if (target < matrix[row][m]){
                r = m - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
