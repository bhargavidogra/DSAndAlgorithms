//279. Perfect Squares
//        Medium
//
//        7749
//
//        336
//
//        Add to List
//
//        Share
//        Given an integer n, return the least number of perfect square numbers that sum to n.
//
//        A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
//
//
//
//        Example 1:
//
//        Input: n = 12
//        Output: 3
//        Explanation: 12 = 4 + 4 + 4.
//        Example 2:
//
//        Input: n = 13
//        Output: 2
//        Explanation: 13 = 4 + 9.
//
//
//        Constraints:
//
//        1 <= n <= 104



class Solution {
    public int numSquares(int n) {
        int dp[]= new int[n+1];
        dp[0]=0;dp[1]=1;
        for(int i=2;i<=n;i++){
            int min=Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++){
                if(dp[i-(j*j)]<min){
                    min= dp[i-(j*j)];
                }
            }
            dp[i]=min+1;
        }
        return dp[n];
    }
}