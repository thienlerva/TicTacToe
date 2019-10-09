import java.util.Random;

public class Computer extends Game {

    private char[][] board;
    private char player;

    public Computer() {
        this.board = super.getBoard();
        this.player = super.getCurrentPlayer();
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

    private String isRowNearWin() {
        for (int i=0; i<board.length;i++) {
            for (int j=0;j<board[0].length;j++) {
                if (findRowIndex(i, j) != null) {
                    return findRowIndex(i, j);
                }
            }
        }
    }

    private String isColumnNearWin() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (findColumnIndex(i, j) != null) {
                    return findColumnIndex(i, j);
                }
            }
        }
    }

    private String isDiagonalNearWin() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (findDiagonalIndex()(i, j) != null) {
                    return findDiagonalIndex(i, j);
                }
            }
        }
    }

    public void setBooleanBoard(char[][] board) {
        for(int row=0;row<3;row++) {
            for(int col=0;col<3;col++) {

                if(board[row][col]==this. || board[row][col]=='-') {

                    myBoard[row][col]=true;
                } else {
                    myBoard[row][col] = false;
                }
            }
        }
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }


    // AI computer playing
    public void placeMarkByComputer() {

        boolean[][] availableSpot = findAvailableSpots();

        String rowIndex=isRowNearWin();
        String colIndex = isColumnNearWin();
        String diaIndex = isDiagonalNearWin();
        if (rowIndex!=null) {
            int row = Integer.valueOf(String.valueOf(rowIndex.charAt(0)));
            int col = Integer.valueOf(String.valueOf(rowIndex.charAt(1)));
            board[row][col] = this.player;
        } else if (colIndex!=null) {

            int row = Integer.valueOf(String.valueOf(colIndex.charAt(0)));
            int col = Integer.valueOf(String.valueOf(colIndex.charAt(1)));
            board[row][col] = this.player;
        } else if(diaIndex!=null) {
            int row = Integer.valueOf(String.valueOf(diaIndex.charAt(0)));
            int col = Integer.valueOf(String.valueOf(diaIndex.charAt(1)));
            board[row][col] = this.player;
        } else if(availableSpot!=null) {
            Random r = new Random();
            int row, col;
            do {
                row = r.nextInt(3);
                col = r.nextInt(3);
                if(availableSpot[row][col]) {
                    board[row][col] = this.player;
                }
            } while(!availableSpot[row][col]);
        }
    }

    private boolean[][] findAvailableSpots() {
        if(!isBoardFull()) {
            boolean[][] spot = new boolean[3][3];

            for(int row=0; row<3; row++) {
                for(int col=0; col<3; col++) {
                    if(board[row][col]=='-') {
                        spot[row][col] = true;
                    }
                }
            }
            return spot;
        } else {
            return null;
        }
    }

}
