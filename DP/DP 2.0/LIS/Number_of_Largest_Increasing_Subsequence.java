//673. Number of Longest Increasing Subsequence
//        Medium
//
//        4385
//
//        196
//
//        Add to List
//
//        Share
//        Given an integer array nums, return the number of longest increasing subsequences.
//
//        Notice that the sequence has to be strictly increasing.
//
//
//
//        Example 1:
//
//        Input: nums = [1,3,5,4,7]
//        Output: 2
//        Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
//        Example 2:
//
//        Input: nums = [2,2,2,2,2]
//        Output: 5
//        Explanation: The length of the longest increasing subsequence is 1, and there are 5 increasing subsequences of length 1, so output 5.
//
//
//        Constraints:
//
//        1 <= nums.length <= 2000
//        -106 <= nums[i] <= 106

import java.util.Arrays;

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int lis=Integer.MIN_VALUE;
        int dp[]= new int[nums.length];
        int fre[]= new int[nums.length];
        Arrays.fill(fre, 1);
        dp[0]=1;

        for(int i=1;i<nums.length;i++){
            int cmax = 0;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    if(dp[j]==cmax){
                        cmax=dp[j];
                        fre[i]+=fre[j];
                    }else if(dp[j]>cmax){
                        cmax=dp[j];
                        fre[i]=fre[j];
                    }
                }
            }
            dp[i] = cmax+1;
            if(dp[i]>=lis){
                lis=dp[i];
            }
        }
        int noOfLIS = 0;
        for( int i=0 ; i<nums.length ; i++ ){
            if(dp[i] == lis) noOfLIS += fre[i];
        }

        return noOfLIS;

    }
}