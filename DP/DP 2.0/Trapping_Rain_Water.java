//42. Trapping Rain Water
//        Hard
//
//        24029
//
//        334
//
//        Add to List
//
//        Share
//        Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
//
//
//
//        Example 1:
//
//
//        Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
//        Output: 6
//        Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
//        Example 2:
//
//        Input: height = [4,2,0,3,2,5]
//        Output: 9
//
//
//        Constraints:
//
//        n == height.length
//        1 <= n <= 2 * 104
//        0 <= height[i] <= 105

class Solution {
    public int trap(int[] height) {

        int n = height.length;
        int dpl[] = new int[n];
        int dpr[]= new int[n];
        dpl[0]=height[0];
        dpr[n-1]= height[n-1];
        for(int i=1;i<n;i++){
            dpl[i]=Math.max(dpl[i-1],height[i]);
        }

        for(int i=n-2;i>=0;i--){
            dpr[i]=Math.max(dpr[i+1],height[i]);
        }

        int res =0;
        for(int i=0;i<n;i++){
            int water_trapped_at_a_spot = Math.min(dpl[i],dpr[i]) - height[i] ;
            res+=water_trapped_at_a_spot;
        }

        return res;

    }
}