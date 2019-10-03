Tic Tac Toe Game


Feature: I added something here too

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
            } else if(c==player && i!=0 && i!=col-1) {
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
    
    private static String checkDiagonals_v2(char[][] board, char player) {
        int row = board.length;
        int col = board[0].length;
        
      
        
        for(int i=0;i<row;i++) {
            char[][] input = new char[row][col];
            int j=0;
            
            int iPlus = i;
            do {
                input[iPlus][j]=board[iPlus][j];
                
                j++;
                iPlus++;
            } while(iPlus<row);
            
              
                print(input);
            
        }
        
        
           return null; 
    }
    
    private static String checkDia(char[][] input, char player) {
        
        char c;
        int i=0;
        int j=0;
        
        do {
                c = input[i][j];
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
    }
    
    private static void print(char[][] input) {
        for(int i=0;i<input.length;i++) {
            for(int j=0;j<input[0].length;j++) {
                System.out.print(input[i][j]);
            }
         System.out.println();
        }
    }
    
    
    private static String checkDiagonals(char[][] board, char player) {
        int row = board.length;
        int col = board[0].length;
        
        List<Character> ch = new ArrayList<>();
        
        for(int i=0;i<row;i++) {
            int j=0;
            
            int iPlus = i;
            do {
                ch.add(board[iPlus][j]);
                
                j++;
                iPlus++;
            } while(iPlus<row);
            
            if(ch.size()>=3) {
                char[] input = new char[ch.size()];
                for(int z=0; z<ch.size();z++) {
                    
                   input[z] = ch.get(z);
                }
              
                if(checkRowCol(input, player)) {
                   
                    return String.valueOf(iPlus-1) + findDiaIndex(input, player);
                }
            }
            ch.clear();
        }
        
        
           return null; 
    }
    
    private static String findDiaIndex(char[] input, char player) {
        
        if(input.length<3) { return null; }
        char c;
        int i=0;
        
        do {
            c = input[i];
            if(c==player && i==0) {
                if(c==input[i+1]) {
                    return String.valueOf(i+2);
                }
            } else if(c==player && i==input.length-1) {
                if(c==input[i-1]) {
                    return String.valueOf(i-2);
                }
            } else if(c==player && i!=0 && i!=input.length-1) {
              
                if(c==input[i-1]) {
                    return String.valueOf(i+1);
                } else if(c==input[i+1]) {
                    
                    return String.valueOf(i-1);
                }
            }
            i++;
            
        } while(i<input.length);
        return null;
    }
    
    private static String checkRows(char[][] board, char player) {
        int row = board.length;
        int col = board[0].length;
        
        char[] input = new char[col];
        
        for(int i = 0; i<row;i++) {
            int j;
            for(j=0;j<col;j++) {
                input[j] = board[i][j];
            }
            if(checkRowCol(input, player)) {
                return i + findIndex(input, player);
            }
        }
           return null; 
    }
    
    private static String checkColumns(char[][] board, char player) {
        int row = board.length;
        int col = board[0].length;
        
        char[] input = new char[row];
        
        for(int i = 0; i<col;i++) {
            int j;
            for(j=0;j<row;j++) {
                input[j] = board[j][i];
            }
            if(checkRowCol(input, player)) {
                return findIndex(input, player) + i;
            }
        }
           return null; 
    }
    
    private static String findIndex(char[] input, char player) {
        char c;
        int i=0;
        
        do {
            c = input[i];
            if(c==player && i==0) {
                if(c==input[i+1]) {
                    return String.valueOf(i+2);
                }
            } else if(c==player && i==input.length-1) {
                if(c==input[i-1]) {
                    return String.valueOf(i-2);
                }
            } else if(c==player && i!=0 && i!=input.length-1) {
                if(c==input[i-1]) {
                    return String.valueOf(i+1);
                } else if(c==input[i+1]) {
                    return String.valueOf(i-1);
                }
            }
            i++;
            
        } while(i<input.length);
        return null;
    }
            
    
    private static boolean checkRowCol(char[] input, char player) {
        if(input.length<3) { return false; }
         char c;
        int i =0;
        do {
            c = input[i];
            if(c==player && i==0) {
                if(c==input[i+1]) {
                    return true;
                }
            } else if(c==player && i==input.length-1) {
                if(c==input[i-1]) {
                    return true;
                }
            } else if(c==player && i!=0 && i!=input.length-1) {
                if(c==input[i-1] || c==input[i+1]) {
                    
                    return true;
                }
            }
            i++;
            
        } while(i<input.length);
                
        return false;
        
    }
}
