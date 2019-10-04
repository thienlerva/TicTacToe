import java.util.ArrayList;
import java.util.List;

public class AppV2 {

    public static void main(String[] args) {

        char[][] board = {
                {'-', 'x', '-', 'x'},
                {'x', '-', 'x', '-'},
                {'-', 'x', 'x', '-'},
                {'x', '-', '-', '-'},
        };

        System.out.println(checkDiagonals_v2(board, 'x'));
    }

    private static String checkDiagonals_v2(char[][] board, char player) {
        int row = board.length;
        int col = board[0].length;



        for(int i=0;i<row;i++) {
            char[][] input = new char[row][col];
            List<Integer> rowList = new ArrayList<>();
            List<Integer> colList = new ArrayList<>();

            int j=0;

            int iPlus = i;
            do {
                rowList.add(iPlus);
                colList.add(j);

                j++;
                iPlus++;
            } while(iPlus<row);

            if (checkDiagonals(board, rowList, colList, 'x')) {
                return findDiagonalIndex(board, rowList, colList, 'x');
            }
//           for (int x=0;x<rowList.size();x++) {
//               System.out.print(board[rowList.get(x)][colList.get(x)]);
//           }
//            System.out.println();

        }


        return null;
    }

    private static boolean checkDiagonals(char[][] board, List<Integer> rowIndex, List<Integer> colIndex, char player) {

        char c;
        int i = 0;
        do {
            int row = rowIndex.get(i);
            int col = colIndex.get(i);

            c = board[row][col];


            // on upper row boundary
            if(c==player && row==0) {
                if(c==board[rowIndex.get(row+1)][colIndex.get(col+1)]) {
                    return true;
                }
                //on lower row boundary
            } else if(c==player && row==row-1) {
                if(c==board[rowIndex.get(row-1)][colIndex.get(col-1)]) {
                    return true;
                }
                // on the middle
            } else if(c==player && row!=row-1) {
                if(c==board[rowIndex.get(row-1)][colIndex.get(col-1)] || c==board[rowIndex.get(row+1)][colIndex.get(col+1)]) {

                    return true;
                }
            }
            i++;
        } while (i<rowIndex.size());
        return false;
    }

    private static String findDiagonalIndex(char[][] board, List<Integer> list1, List<Integer> list2, char player) {
        char c;
        int i = 0;
        do {
            int row = list1.get(i);
            int col = list2.get(i);

            c = board[row][col];

            // on upper row boundary
            if(c==player && row==0) {
                if(c==board[list1.get(row+1)][list2.get(col+1)]) {
                    return String.valueOf(row+1) + String.valueOf(col+1);
                }
                //on lower row boundary
            } else if(c==player && row==row-1) {
                if(c==board[list1.get(row-1)][list2.get(col-1)]) {
                    return String.valueOf(row-1) + String.valueOf(col-1);
                }
                // on the middle
            } else if(c==player && row!=row-1) {
                if(c==board[list1.get(row-1)][list2.get(col-1)]) {
                    return String.valueOf(row+1) + String.valueOf(col+1);
                } else if (c==board[list1.get(row+1)][list2.get(col+1)]) {

                    return String.valueOf(row-1) + String.valueOf(col-1);
                }
            }
            i++;
        } while (i<list1.size());
        return null;
    }

    private static String checkRow_v2(char[][] board, char player) {
        int row = board.length;
        int col = board[0].length;

        char[][] input = new char[row][col];

        for(int i = 0; i<row;i++) {
            int j;
            for(j=0;j<col;j++) {
                input[i][j] = board[i][j];
            }
            if(checkRowCol_v2(input, player, i, "row")) {
                return findIndex_v2(input, player, i, "row");
            }
        }
        return null;
    }

    private static boolean checkRowCol_v2(char[][] input, char player, int index, String type) {
        int row = input.length;
        int col = input[0].length;

        char c;
        int i =0;

        switch(type) {
            case "row":
                do {
                    c = input[index][i];
                    if(c==player && i==0) {
                        if(c==input[index][i+1]) {
                            return true;
                        }
                    } else if(c==player && i==col-1) {
                        if(c==input[index][i-1]) {
                            return true;
                        }
                    } else if(c==player && i!=0 && i!=col-1) {
                        if(c==input[index][i-1] || c==input[index][i+1]) {

                            return true;
                        }
                    }
                    i++;

                } while(i<col);
                break;
            case "column":
                do {
                    c = input[i][index];
                    if(c==player && i==0) {
                        if(c==input[i+1][index]) {
                            return true;
                        }
                    } else if(c==player && i==row-1) {
                        if(c==input[i-1][index]) {
                            return true;
                        }
                    } else if(c==player && i!=0 && i!=row-1) {
                        if(c==input[i-1][index] || c==input[i+1][index]) {

                            return true;
                        }
                    }
                    i++;

                } while(i<row);
                break;
            case "diagonal":
                do {
                    c = input[i][index];
                    if(c==player && i==0) {
                        if(c==input[i+1][index]) {
                            return true;
                        }
                    } else if(c==player && i==row-1) {
                        if(c==input[i-1][index]) {
                            return true;
                        }
                    } else if(c==player && i!=0 && i!=row-1) {
                        if(c==input[i-1][index] || c==input[i+1][index]) {

                            return true;
                        }
                    }
                    i++;

                } while(i<row);
                break;
            default:
                throw new IllegalArgumentException("Wrong input type!");

        }
        return false;


    }

    private static String findIndex_v2(char[][] input, char player, int index, String type) {
        int row = input.length;
        int col = input[0].length;
        char c;
        int i=0;

        switch(type) {
            case "row":
                do {
                    c = input[index][i];
                    if(c==player && i==0) {
                        if(c==input[index][i+1]) {
                            return String.valueOf(index) + String.valueOf(i+2);
                        }
                    } else if(c==player && i==col-1) {
                        if(c==input[index][i-1]) {
                            return String.valueOf(index) + String.valueOf(i-2);
                        }
                    } else if(c==player && i!=col-1) {
                        if(c==input[index][i-1]) {
                            return String.valueOf(index) + String.valueOf(i+1);
                        } else if(c==input[index][i+1]) {
                            return String.valueOf(index) + String.valueOf(i-1);
                        }
                    }
                    i++;

                } while(i<col);
                break;
            case "column":
                do {

                    c = input[i][index];
                    if(c==player && i==0) {
                        if(c==input[i+1][index]) {
                            System.out.println("In here");
                            return String.valueOf(i+2) + index;
                        }
                    } else if(c==player && i==row-1) {
                        if(c==input[i-1][index]) {
                            return String.valueOf(i-2) + index;
                        }
                    } else if(c==player && i!=0 && i!=row-1) {
                        if(c==input[i-1][index]) {
                            return String.valueOf(i+1) + index;
                        } else if (c==input[i+1][index]) {

                            return String.valueOf(i-1) + index;
                        }
                    }
                    i++;

                } while(i<row);
                break;
            default:
                throw new IllegalArgumentException("Wrong input type!");

        }
        return null;
    }

    private static String checkColumn_v2(char[][] board, char player) {
        int row = board.length;
        int col = board[0].length;

        char[][] input = new char[row][col];

        for(int i = 0; i<col;i++) {
            int j;
            for(j=0;j<row;j++) {
                input[j][i] = board[j][i];
            }
            if(checkRowCol_v2(input, player, i, "column")) {
                return findIndex_v2(input, player, i, "column");
            }
        }
        return null;
    }


    private static void print(char[][] input) {
        for(int i=0;i<input.length;i++) {
            for(int j=0;j<input[0].length;j++) {
                System.out.print(input[i][j]);
            }
            System.out.println();
        }
    }
}
