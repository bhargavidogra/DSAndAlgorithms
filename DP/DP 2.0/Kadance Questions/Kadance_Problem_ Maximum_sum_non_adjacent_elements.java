//Kadance Problem - Maximum sum non-adjacent elements
//You are given an array arr of size sizeOfArr. You need to find the maximum sum in the array provided that you cannot sum neighboring elements or adjacent elements.
//
//        Example 1:
//
//        Input:
//        sizeOfArr = 4
//        arr[] = {4,5,6,7,8}
//        Output: 18
//        Explanation:The given elements are 4 5 6 7 8
//        For 4, the maximum sum will be 4 as no
//        element other than 4 from index 0 to 0
//        For 5, the maximum sum will be 5 as we cannot
//        add 4 and 5(neighboring elements).
//        For 6, the maximum sum will be 10 as we can
//        add 6 and 4.
//        For 7, the maximum sum will be 12 as we can
//        add 7 and 5.
//        For 8, the maximum sum will be 18 as we can
//        add 4 and 6 and 8.
//        Example 2:
//
//        Input:
//        sizeOfArr = 5
//        arr[] = {-9,-8,8,3,-4}
//        Output: 8
//
//        Example 3:
//        Input:
//        sizeOfArr = 8
//        arr[] = {-366 50 677 -13 -33 -923 495 -851}
//
//        Output: 1172
//
//        Your Task:
//        This is a function problem. You only need to complete the function maximumSum() that takes array and sizeOfArray and returns the maximum sum of the array provided that you cannot sum neighboring elements.
//
//        Expected Time Complexity: O(N).
//        Expected Auxiliary Space: O(N).
//
//        Constraints:
//        1 ≤ sizeOfArr ≤ 104
//        -103 ≤ arri ≤ 103

class Solution
{
    //Function to return the maximum sum without adding adjacent elements.
    public long maximumSum(int arr[], int sizeOfArray)
    {
        if(sizeOfArray==1){
            return Math.max(0,arr[0]);
        }
        int dp[] = new int[sizeOfArray];

        dp[0]= Math.max(Integer.MIN_VALUE,arr[0]);
        dp[1]= Math.max(dp[0],arr[1]);
        for(int i=2;i<sizeOfArray;i++){
            //Three factor's : max sum at any point can be attained by either adding current or leaving it:
            //1) do not include ele - maximum sum uptill last position is max sum at current pos as well
            //2) include current element so now two ways
            //   i) either sum it up with max sum uptill i-2 elememts
            //   ii) either current element itself is more than any of the above two choice so we keep that.
            dp[i]=Math.max(arr[i], Math.max(dp[i-1],dp[i-2]+arr[i]));
        }

        return dp[sizeOfArray-1];

    }

}