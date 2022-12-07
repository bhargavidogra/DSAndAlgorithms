//Equal Sum Partition - Target sum subset Variation - Knapsack Variation
//        Given a set of numbers, check whether it can be partitioned into two subsets such that the sum of elments in both subsets is same or not
//
//        Input:
//        N = 4
//        arr[] = {1,5,11,5}
//        Output: YES
//        Explanation: There exists two subsets
//        such that {1, 5, 5} and {11}.
//
//        Input:
//        N = 3
//        arr[] = {1,3,5}
//        Output: NO

class Solution {
    //Function to check whether a set of numbers can be partitioned into
    //two subsets such that the sum of elements in both subsets is same.
    public boolean findPartition(int[] a, int n) {
        // code here
        int sum = 0;
        for (int num : a) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }

        sum = sum / 2;
        Boolean dp[][] = new Boolean[n + 1][sum + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    dp[i][j] = true;
                } else {
                    if (j - a[i - 1] >= 0) {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - a[i - 1]];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        return dp[n][sum];
    }
}