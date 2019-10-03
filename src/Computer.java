import java.util.Random;

public class Computer {

    private char name;
    boolean[][] myBoard;
    char[][] board;
    private boolean isMyTurn;

    public Computer(char name, boolean isMyTurn) {
        this.name = name;
        this.isMyTurn = isMyTurn;
        this.myBoard = new boolean[3][3];
    }

    public void setBooleanBoard(char[][] board) {
        for(int row=0;row<3;row++) {
            for(int col=0;col<3;col++) {

                if(board[row][col]==this.name || board[row][col]=='-') {

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

    private boolean checkRows() {
        for (int row=0;row<3;row++) {
            if (checkRowCol(board[row][0], board[row][1], board[row][2])) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns() {
        for (int col=0;col<3;col++) {
            if (checkRowCol(board[0][col], board[1][col], board[2][col])) {
                return true;

            }
        }
        return false;
    }



    private String checkDiagonals() {

            if (checkRowCol(board[0][0], board[1][1], board[2][2])) {
                if (board[0][0]=='-') {
                    return "00";
                } else if (board[1][1]=='-') {
                    return "11";
                } else {
                    return "22";
                }
            }
        if (checkRowCol(board[0][2], board[1][1], board[2][0])) {
            if (board[0][0]=='-') {
                return "00";
            } else if (board[1][1]=='-') {
                return "11";
            } else {
                return "20";
            }
        }

        return null;
    }

    private String findRowIndex() {
        for (int row=0;row<3;row++) {
            if (checkRowCol(board[row][0], board[row][1], board[row][2])) {
                if (board[row][0]=='-') {
                    return row + "0";
                } else if (board[row][1]=='-') {
                    return row + "1";

                } else {
                    return row + "2";
                }
            }
        }
        return null;
    }

    private String findColumnIndex() {
        for (int col=0;col<3;col++) {
            if (checkRowCol(board[0][col], board[1][col], board[2][col])) {
                if (board[0][col]=='-') {
                    return "0" + col;
                } else if (board[1][col]=='-') {
                    return "1" + col;

                } else {
                    return "2" + col;
                }
            }
        }
        return null;
    }

    private boolean checkRowCol(char c1, char c2, char c3) {
        if(c1==this.name || c2==this.name || c3==this.name) {
            return false;
        } else if (c1=='o' && c2=='o') {
                return true;
        } else if (c1=='o' && c3=='0') {
            return true;
        } else if (c2=='o' && c3=='o') {
            return true;
        }
        return false;
    }

    private boolean isOpponentNearWin() {
        return checkRows() || checkColumns();
    }

    // AI computer playing
    public void placeMarkByComputer() {

        boolean[][] availableSpot = findAvailableSpots();
        if (checkRows()) {
            String str = findRowIndex();
            int row = Integer.valueOf(String.valueOf(str.charAt(0)));
            int col = Integer.valueOf(String.valueOf(str.charAt(1)));
            board[row][col] = this.name;
        } else if (checkColumns()) {
            String str = findColumnIndex();
            int row = Integer.valueOf(String.valueOf(str.charAt(0)));
            int col = Integer.valueOf(String.valueOf(str.charAt(1)));
            board[row][col] = this.name;
        } else if(availableSpot!=null) {
            Random r = new Random();
            int row, col;
            do {
                row = r.nextInt(3);
                col = r.nextInt(3);
                if(availableSpot[row][col]) {
                    board[row][col] = this.name;
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

    public boolean isBoardFull() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }

        return true;
    }

    public String toString() {
        String result = "\n-------------\n";

        for(int row=0; row<3;row++) {
            result += "| ";
            for(int col=0;col<3;col++) {
                result += myBoard[row][col] + " | ";
            }
            result += "\n-------------\n";
        }
        return result;
    }
}
