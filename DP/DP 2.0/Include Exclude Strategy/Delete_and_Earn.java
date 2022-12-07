//740. Delete and Earn
//        Medium
//
//        5854
//
//        312
//
//        Add to List
//
//        Share
//        You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:
//
//        Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
//        Return the maximum number of points you can earn by applying the above operation some number of times.
//
//
//
//        Example 1:
//
//        Input: nums = [3,4,2]
//        Output: 6
//        Explanation: You can perform the following operations:
//        - Delete 4 to earn 4 points. Consequently, 3 is also deleted. nums = [2].
//        - Delete 2 to earn 2 points. nums = [].
//        You earn a total of 6 points.
//        Example 2:
//
//        Input: nums = [2,2,3,3,3,4]
//        Output: 9
//        Explanation: You can perform the following operations:
//        - Delete a 3 to earn 3 points. All 2's and 4's are also deleted. nums = [3,3].
//        - Delete a 3 again to earn 3 points. nums = [3].
//        - Delete a 3 once more to earn 3 points. nums = [].
//        You earn a total of 9 points.
//
//
//        Constraints:
//
//        1 <= nums.length <= 2 * 104
//        1 <= nums[i] <= 104

class Solution {


    public int deleteAndEarn1(int[] nums) {
        int[] sum = new int[10002];

        for(int i = 0; i < nums.length; i++){
            sum[nums[i]] += nums[i];
        }

        for(int i = 2; i < sum.length; i++){
            sum[i] = Math.max(sum[i-1], sum[i-2] + sum[i]);
        }
        return sum[10001];
    }


    public int deleteAndEarn(int[] nums) {
        int[] fre = new int[10002];

        for(int i = 0; i < nums.length; i++){
            fre[nums[i]] ++;
        }

        int inc =0,exc =0;
        for(int i=0;i<10002;i++){
            int ninc = exc + fre[i]*i;
            int nexc = Math.max(inc,exc);

            inc = ninc;
            exc = nexc;
        }

        return Math.max(inc,exc);
    }

}