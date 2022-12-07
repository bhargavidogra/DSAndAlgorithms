//1690. Stone Game VII
//        Medium
//
//        797
//
//        138
//
//        Add to List
//
//        Share
//        Alice and Bob take turns playing a game, with Alice starting first.
//
//        There are n stones arranged in a row. On each player's turn, they can remove either the leftmost stone or the rightmost stone from the row and receive points equal to the sum of the remaining stones' values in the row. The winner is the one with the higher score when there are no stones left to remove.
//
//        Bob found that he will always lose this game (poor Bob, he always loses), so he decided to minimize the score's difference. Alice's goal is to maximize the difference in the score.
//
//        Given an array of integers stones where stones[i] represents the value of the ith stone from the left, return the difference in Alice and Bob's score if they both play optimally.
//
//
//
//        Example 1:
//
//        Input: stones = [5,3,1,4,2]
//        Output: 6
//        Explanation:
//        - Alice removes 2 and gets 5 + 3 + 1 + 4 = 13 points. Alice = 13, Bob = 0, stones = [5,3,1,4].
//        - Bob removes 5 and gets 3 + 1 + 4 = 8 points. Alice = 13, Bob = 8, stones = [3,1,4].
//        - Alice removes 3 and gets 1 + 4 = 5 points. Alice = 18, Bob = 8, stones = [1,4].
//        - Bob removes 1 and gets 4 points. Alice = 18, Bob = 12, stones = [4].
//        - Alice removes 4 and gets 0 points. Alice = 18, Bob = 12, stones = [].
//        The score difference is 18 - 12 = 6.
//        Example 2:
//
//        Input: stones = [7,90,5,1,100,10,10,2]
//        Output: 122
//
//
//        Constraints:
//
//        n == stones.length
//        2 <= n <= 1000
//        1 <= stones[i] <= 1000

class Solution {
    public int stoneGameVII(int[] stones) {

        int n = stones.length;
        int pre_sum[] = new int[n];
        pre_sum[0] = stones[0];
        for (int s = 1; s < n; s++) {
            pre_sum[s] = pre_sum[s - 1] + stones[s];
        }

        int dp[][] = new int[n][n];

        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; j++, i++) {
                if (g == 0) {
                    dp[i][j] = 0;
                } else if (g == 1) {
                    dp[i][j] = Math.max(stones[i], stones[j]);
                } else {

                    dp[i][j] = Math.max(
                            //For sum [A,B,C] choices are:
                            //       when Alice chooses A  {Alice's score - Bob's score}
                            // MAX of[                     {    B+C       - max(B,C)} ,
                            //        when Alice chooses C {Alice's score - Bob's score}
                            //                                 A+B        - max(A,B) ]
                            //get sum(B+C) pre_sum[j]-pre_sum[i] using prefix sum and add to optimal choice of dp[i+1, j] (max(B,C))
                            pre_sum[j] - pre_sum[i] - dp[i + 1][j],
                            //get sum(A+B) pre_sum[j-1]-pre_sum[i-1] using prefix sum and add to optimal choice of dp[i, j-1] max(A,B)
                            pre_sum[j - 1] - (i - 1 >= 0 ? pre_sum[i - 1] : 0) - dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }
}