/*According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.*/

class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        int n = board[0].length;
        int m = board.length;
        int[][] newboard = new int[m][n];
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n ; j++){
                int cnt = 0; 
                if(i > 0 && j > 0){
                    cnt += board[i - 1][j - 1];
                }
                if(i > 0){
                    cnt += board[i - 1][j];
                }
                if(i > 0 && j < n - 1){  
                    cnt += board[i - 1][j + 1];
                }
                if(j > 0){
                    cnt += board[i][j - 1];
                }
                if(j < n - 1){
                    cnt += board[i][j + 1];
                }
                if(j > 0 && i < m - 1){
                    cnt += board[i + 1][j - 1];
                }
                if(i < m - 1){
                    cnt += board[i + 1][j];
                }
                if(i < m - 1 && j < n - 1){
                    cnt += board[i + 1][j + 1];
                }
                if (board[i][j] == 1) {  
                    if(cnt >= 2 && cnt <= 3)
                    {
                        newboard[i][j] = 1; 
                    }else{
                        newboard[i][j] = 0; 
                    }
                    
                }
                if (board[i][j] == 0) {
                    if(cnt == 3)
                        newboard[i][j] = 1; 
                    else
                        newboard[i][j] = 0; 
                }
            }
        }

         for(int i = 0; i < m ; i++){
            for(int j = 0; j < n ; j++){
                board[i][j] = newboard[i][j];
            }
         }
    }
}