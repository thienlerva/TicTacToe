public class Test {

    public static void main(String args[])
    {

        Bot aBot = new Bot();
        aBot.print();

        System.out.println(aBot.findColumnIndex(1,0));
    }
}

class Game1 {

    private final char[][] board;
    private char currentPlayer;
    /**
     0 - open space
     1 - my space
     2 - opponent space
     */
    private static final char[][] SAMPLE_BOARD =
            {{'o','x','-','x'},
            {'x','o','o','x'},
            {'x','o','-','o'},
            {'-','-','o','o'}};

    public Game1(char[][] board, char player) {
        this.board = board;
        this.currentPlayer = player;
    }

    public Game1() {
        this(SAMPLE_BOARD, 'x');
    }

    public void print() {
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

    public char getCurrentPlayer() {
        return this.currentPlayer;
    }

    private boolean isSafe(int x, int y) {

        return x >= 0 & x < board.length && y >= 0 && y < board[0].length && board[x][y]==this.currentPlayer;

    }
    public boolean isBoardFull() {
        int i =0, j=0;
        do {
            if(board[i][j]=='-') {
                return false;
            }

        } while(i<board.length && j < board[0].length);
        return true;
    }

    private boolean checkRowColumn(char c1, char c2, char c3) {

        return c1==c2 && c2==c3 && c1==c3;
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


    public char[][] getBoard() {
        return this.board;
    }

    public boolean isWin() {
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[i].length;j++) {
                if(checkRow(i,j) || checkColumn(i,j) || checkDiagonal(i,j)) {
                    return checkRow(i,j);
                }
            }

        }
        return false;
    }
}

class Bot extends Game1 {

    private char[][] board;
    private char player;

    public Bot() {
        this.board = this.getBoard();
        this.player = this.getCurrentPlayer();
    }

    public boolean isSafe(int x, int y) {

        return x >= 0 & x < board.length && y >= 0 && y < board[0].length && (board[x][y]==player || board[x][y]=='-');
    }
    public String findRowIndex(int x, int y) {
        char c1,c2,c3;

        if(isSafe(x,y) && isSafe(x, y+1) && isSafe(x, y+2)) {
            c1=board[x][y];
            c2=board[x][y+1];
            c3=board[x][y+2];

            if (c1=='-' && c2==player && c3==player) {
                return String.valueOf(x) + String.valueOf(y);
            } else if (c1==player && c2=='-' && c3==player) {
                return String.valueOf(x) + String.valueOf(y+1);
            } else if (c1==player && c2==player && c3=='-') {
                return String.valueOf(x) + String.valueOf(y+2);
            }
        }


        return null;
    }

    public String findDiagonalIndex(int x, int y) {
        char c1,c2,c3;
        if(isSafe(x,y) && isSafe(x+1, y+1) && isSafe(x+2, y+2)) {
            c1=board[x][y];
            c2=board[x+1][y+1];
            c3=board[x+2][y+2];

            if (c1=='-' && c2==player && c3==player) {
                return String.valueOf(x) + String.valueOf(y);
            } else if (c1==player && c2=='-' && c3==player) {
                return String.valueOf(x+1) + String.valueOf(y+1);
            } else if (c1==player && c2==player && c3=='-') {
                return String.valueOf(x+2) + String.valueOf(y+2);
            }
        }
        return null;
    }

    public String findColumnIndex(int x, int y) {
        char c1,c2,c3;

        if(isSafe(x,y) && isSafe(x+1, y) && isSafe(x+2, y)) {
            c1=board[x][y];
            c2=board[x+1][y];
            c3=board[x+2][y];

            if (c1=='-' && c2==player && c3==player) {
                return String.valueOf(x) + String.valueOf(y);
            } else if (c1==player && c2=='-' && c3==player) {
                return String.valueOf(x+1) + String.valueOf(y);
            } else if (c1==player && c2==player && c3=='-') {
                return String.valueOf(x+2) + String.valueOf(y);
            }
        }
        return null;
    }

}
