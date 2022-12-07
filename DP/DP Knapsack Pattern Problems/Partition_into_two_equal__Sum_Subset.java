//416. Partition Equal Subset Sum
//        Medium
//
//        9316
//
//        153
//
//        Add to List
//
//        Share
//        Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
//
//
//
//        Example 1:
//
//        Input: nums = [1,5,11,5]
//        Output: true
//        Explanation: The array can be partitioned as [1, 5, 5] and [11].
//        Example 2:
//
//        Input: nums = [1,2,3,5]
//        Output: false
//        Explanation: The array cannot be partitioned into equal sum subsets.
//
//
//        Constraints:
//
//        1 <= nums.length <= 200
//        1 <= nums[i] <= 100


class Solution {
    public boolean canPartition(int[] nums) {

        int sum=0;
        int n= nums.length;
        for(int v: nums){
            sum+=v;
        }

        if(sum%2!=0){
            return false;
        }

        sum=sum/2;
        Boolean dp[][]= new Boolean[n+1][sum+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0 && j==0){
                    dp[i][j]= true;
                }else if(i==0){
                    dp[i][j]= false;
                }else if(j==0){
                    dp[i][j]= true;
                }else{
                    if(j-nums[i-1]>=0){
                        dp[i][j]= dp[i-1][j]||dp[i-1][j-nums[i-1]];
                    }else{
                        dp[i][j]= dp[i-1][j];
                    }
                }
            }
        }

        return dp[n][sum];

    }
}