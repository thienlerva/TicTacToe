import java.util.Random;

public class Game {

    private final char[][] board;
    private char currentPlayer;
    private static final int ROW = 3;
           private static final int COLUMN = 3;


    public Game(int row, int col, char player) {
        this.board = new char[row][col];
        this.currentPlayer = player;
        this.initializeBoard(row, col);
    }

    public Game() {

        this(ROW, COLUMN, 'x');
        this.initializeBoard(ROW, COLUMN);
    }

    //Gives us access to currentPlayerMark
    public char getCurrentPlayer()
    {
        return currentPlayer;
    }

    public char[][] getBoard() {
        return this.board;
    }


    // Set/Reset the board back to all empty values.
    public void initializeBoard(int row, int col) {

        // Loop through rows
        for (int i = 0; i < row; i++) {

            // Loop through columns
            for (int j = 0; j < col; j++) {
                board[i][j] = '-';
            }
        }
    }



    // Print the current board (may be replaced by GUI implementation later)
    public void printBoard() {
        String result = ("\n-------------------\n");

        for(int row=0; row<board.length;row++) {
            result += "| ";
            for(int col=0;col<board[row].length;col++) {
                result += board[row][col] + " | ";
            }
            result += "\n-------------------\n";
        }
        System.out.println(result);
    }


    // Loop through all cells of the board and if one is found to be empty (contains char '-') then return false.
// Otherwise the board is full.
    public boolean isBoardFull() {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }

        return true;
    }


    // Returns true if there is a win, false otherwise.
// This calls our other win check functions to check the entire board.

        public boolean isWinner() {
            for(int i=0;i<board.length;i++) {
                for(int j=0;j<board[i].length;j++) {
                    if(checkRow(i,j) || checkColumn(i,j) || checkDiagonal(i,j)) {
                        return true;
                    }
                }

            }
            return false;
        }



    private boolean isSafe(int x, int y) {

        return x >= 0 & x < board.length && y >= 0 && y < board[0].length && board[x][y]==this.currentPlayer;

    }


    // Check to see if all three values are the same (and not empty) indicating a win.
    private boolean checkRowCol(char c1, char c2, char c3) {
        return (c1 != '-') && (c1 == c2) && (c2 == c3);
    }

    private boolean checkRowColumn(char c1, char c2, char c3) {

        return (c1 != '-') && (c1 == c2) && (c2 == c3);
    }

    public boolean checkRow(int x, int y) {
        if(isSafe(x, y-1) && isSafe(x,y+1)) {

            return checkRowColumn(board[x][y-1], board[x][y], board[x][y+1]);
        }
        return false;
    }


    private boolean checkColumn(int x, int y) {
        if(isSafe(x-1, y) && isSafe(x+1,y)) {
            return checkRowColumn(board[x-1][y], board[x][y], board[x+1][y]);
        }
        return false;

    }

    private boolean checkDiagonal(int x, int y) {
        if(isSafe(x-1,y-1) && isSafe(x+1, y+1) && isSafe(x-1, y+1) & isSafe(x+1, y-1)) {
            return checkRowColumn(board[x-1][y-1], board[x][y], board[x+1][y+1]);
        }
        return false;


    }


    // Change player marks back and forth.
    public void changePlayer() {

        if (currentPlayer == 'x') {
            currentPlayer = 'o';
        }
        else {
            currentPlayer = 'x';
        }


    }

    // Places a mark at the cell specified by row and col with the mark of the current player.
    public boolean placeMark(int row, int col) {

        // Make sure that row and column are in bounds of the board.
        if (row >= 0 && row < board.length && col >= 0 && col < board[0].length) {

            if (board[row][col] == '-') {
                board[row][col] = currentPlayer;
                return true;
            }

        }

        return false;
    }

    public String toString() {
        String result = "\n-------------\n";

        for(int row=0; row<board.length;row++) {
            result += "| ";
            for(int col=0;col<board[0].length;col++) {
                result += board[row][col] + " | ";
            }
            result += "\n-------------\n";
        }
        return result;
    }
}
