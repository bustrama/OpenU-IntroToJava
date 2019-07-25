
public class N_Queens_Problem
{
    public static void solveNQueens(int n){
        char[][] board = new char[n][n];
        if (solveNQueens(board,0)){
            printBoard(board);
        }
        else {
            System.out.println("no soution");
        }
    }

    private static boolean solveNQueens(char[][] board, int i) {
        if (i == board.length){
            return true;
        }
        for (int j=0; j < board.length; j++){
            if (isSafe(board,i,j)){
                board[i][j] = 'Q';
                if (solveNQueens(board,i+1)){
                    return true;
                }
                else{
                    board[i][j] = '_';
                }
            }
        }
        return false;
    }

    private static boolean isSafe(char[][] board, int i, int j) {
        //attacked by other in left diagonal
        for (int r = 1; (j-r > -1) && (i-r > -1); r++){
            if (board[i-r][j-r] == 'Q'){
                return false;
            }
        }
        //attacked by other in right diagonal
        for (int r = 1; (j+r < board.length) && (i-r > -1); r++){
            if (board[i-r][j+r] == 'Q'){
                return false;
            }
        }
        // check if there is another queen in same column
        for (int r = 0; r < i; r++){
            if (board[r][j] == 'Q'){
                return false;
            }
        }
        return true;
    }

    private static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board.length; column++) {
                if (board[row][column] == 0)
                    board[row][column] = '_';
                System.out.print("|"+board[row][column] + "|");
                if (column == board.length-1)
                    System.out.print("\n");
            }
        }
    }
}