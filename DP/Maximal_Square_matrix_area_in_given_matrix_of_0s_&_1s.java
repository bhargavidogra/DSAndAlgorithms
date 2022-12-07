//221. Maximal Square
//        Medium
//
//        8245
//
//        177
//
//        Add to List
//
//        Share
//        Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
//
//
//
//        Example 1:
//
//
//        Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
//        Output: 4
//        Example 2:
//
//
//        Input: matrix = [["0","1"],["1","0"]]
//        Output: 1
//        Example 3:
//
//        Input: matrix = [["0"]]
//        Output: 0
//
//
//        Constraints:
//
//        m == matrix.length
//        n == matrix[i].length
//        1 <= m, n <= 300
//        matrix[i][j] is '0' or '1'.


class Solution {
    public int maximalSquare(char[][] matrix) {

        int n= matrix.length;int m= matrix[0].length;

        int dp[][]= new int[n][m];
        int omax=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i==n-1 || j==m-1){
                    dp[i][j]= (int)(matrix[i][j]-'0');
                }else{
                    dp[i][j]=matrix[i][j]=='0' ? 0 : Math.min(dp[i][j+1],Math.min(dp[i+1][j+1],dp[i+1][j]))+1;
                }
                if(dp[i][j]>omax)
                    omax=dp[i][j];
            }
        }

        return omax*omax;
    }
}