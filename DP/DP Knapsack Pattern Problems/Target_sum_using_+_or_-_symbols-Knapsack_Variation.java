//Target Sum using symbols '+' and '-' -Knapsack variation
//        Medium
//
//        8382
//
//        302
//
//        Add to List
//
//        Share
//        You are given an integer array nums and an integer target.
//
//        You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
//
//        For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
//        Return the number of different expressions that you can build, which evaluates to target.
//
//
//
//        Example 1:
//
//        Input: nums = [1,1,1,1,1], target = 3
//        Output: 5
//        Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
//        -1 + 1 + 1 + 1 + 1 = 3
//        +1 - 1 + 1 + 1 + 1 = 3
//        +1 + 1 - 1 + 1 + 1 = 3
//        +1 + 1 + 1 - 1 + 1 = 3
//        +1 + 1 + 1 + 1 - 1 = 3
//        Example 2:
//
//        Input: nums = [1], target = 1
//        Output: 1




class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum =0;
        for(int n: nums){
            sum+=n;
        }

        int dp[][]= new int[nums.length+1][2*sum +1];

        dp[0][0+sum]=1;

        if(target< -sum || target>sum){
            return 0;
        }

        for(int i=1;i<nums.length+1;i++){
            for(int j= 0;j<2*sum+1;j++){
                if(j+nums[i-1]<2*sum+1){
                    dp[i][j]+=dp[i-1][j+nums[i-1]];
                }

                if(j-nums[i-1]>=0){
                    dp[i][j]+=dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[nums.length][sum+target];
    }
}