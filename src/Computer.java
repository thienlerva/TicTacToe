public class Computer {

    private char name;
    boolean[][] myBoard;
    private boolean isMyTurn;

    public Computer(char name, boolean isMyTurn) {
        this.name = name;
        this.isMyTurn = isMyTurn;
        this.myBoard = new boolean[3][3];
    }

    public void myBoard(char[][] board) {
        for(int row=0;row<3;row++) {
            for(int col=0;col<3;col++) {

                if(board[row][col]==this.name || board[row][col]=='-') {

                    myBoard[row][col]=true;
                }
            }
        }


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
