//1567. Maximum Length of Subarray With Positive Product
//        Medium
//
//        1935
//
//        50
//
//        Add to List
//
//        Share
//        Given an array of integers nums, find the maximum length of a subarray where the product of all its elements is positive.
//
//        A subarray of an array is a consecutive sequence of zero or more values taken out of that array.
//
//        Return the maximum length of a subarray with positive product.
//
//
//
//        Example 1:
//
//        Input: nums = [1,-2,-3,4]
//        Output: 4
//        Explanation: The array nums already has a positive product of 24.
//        Example 2:
//
//        Input: nums = [0,1,-2,-3,-4]
//        Output: 3
//        Explanation: The longest subarray with positive product is [1,-2,-3] which has a product of 6.
//        Notice that we cannot include 0 in the subarray since that'll make the product 0 which is not positive.
//        Example 3:
//
//        Input: nums = [-1,-2,-3,0,1]
//        Output: 2
//        Explanation: The longest subarray with positive product is [-1,-2] or [-2,-3].
//
//
//        Constraints:
//
//        1 <= nums.length <= 105
//        -109 <= nums[i] <= 109

class Solution {
    public int getMaxLen(int[] nums) {
        int n = nums.length;

        int pos =0, neg=0;

        int maxPos = Integer.MIN_VALUE;

        if(nums[0]>0){
            pos = 1;
        }else if(nums[0]<0){
            neg = 1;
        }

        maxPos = Math.max(maxPos,pos);
        for(int i=1;i<n;i++){

            if( nums[i] < 0){
                int pre_pos = pos;

                pos = neg > 0 ? neg+1 : 0;
                neg = pre_pos>0 ? pre_pos+1 : 1;
            }else if( nums[i] > 0 ){
                pos = pos + 1 ;
                neg = neg > 0 ? neg+1 : 0;
            }else{
                pos = 0;
                neg = 0;
            }

            maxPos= Math.max( maxPos , pos );
        }
        return maxPos==Integer.MIN_VALUE ? 0 : maxPos;
    }
}