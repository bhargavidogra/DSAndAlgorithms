//576. Out of Boundary Paths
//        Medium
//
//        2861
//
//        226
//
//        Add to List
//
//        Share
//        There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn]. You are allowed to move the ball to one of the four adjacent cells in the grid (possibly out of the grid crossing the grid boundary). You can apply at most maxMove moves to the ball.
//
//        Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out of the grid boundary. Since the answer can be very large, return it modulo 109 + 7.
//
//
//
//        Example 1:
//
//
//        Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
//        Output: 6
//        Example 2:
//
//
//        Input: m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
//        Output: 12
//
//
//        Constraints:
//
//        1 <= m, n <= 50
//        0 <= maxMove <= 50
//        0 <= startRow < m
//0 <= startColumn < n


class Solution {

    //Memoisation
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn, long dp[][][]) {
        int mod = 1000000007;
        if(startRow<0 || startRow >=m || startColumn<0 || startColumn>=n){
            return 1;
        }

        if(maxMove<=0){
            return 0;
        }
        if(dp[startRow][startColumn][maxMove]!=0){
            return (int)dp[startRow][startColumn][maxMove]%mod;
        }

        long count = 0;

        count+= findPaths(m,n,maxMove-1,startRow+1,startColumn, dp);
        count+= findPaths(m,n,maxMove-1,startRow-1,startColumn, dp);
        count+= findPaths(m,n,maxMove-1,startRow,startColumn+1, dp);
        count+= findPaths(m,n,maxMove-1,startRow,startColumn-1, dp);
        dp[startRow][startColumn][maxMove] = count%mod;
        return (int)dp[startRow][startColumn][maxMove]%mod;
    }


    //Tabulation
    public int findPaths(int m, int n, int maxMove, int r, int c) {

        if(r<0 || c<0 || r>=m  || c>=n || maxMove==0) return 0;
        int mod = (int)1e9 + 7;

        long[][][]dp= new long[m][n][maxMove+1];



        for(int move =1 ; move<=maxMove ; move++){
            for(int i=0 ; i<m ; i++){
                for(int j=0 ; j<n ; j++){


                    long up = (i-1>=0)? dp[i-1][j][move-1]%mod:1;
                    long down = (i+1<m)? dp[i+1][j][move-1]%mod:1;
                    long lft = (j-1>=0)? dp[i][j-1][move-1]%mod:1;
                    long rt = (j+1<n)? dp[i][j+1][move-1]%mod :1;

                    dp[i][j][move]= (up+ down+ lft+ rt)%mod;

                }
            }
        }



        return (int)dp[r][c][maxMove]%mod;
    }
}