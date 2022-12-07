//1014. Best Sightseeing Pair
//        Medium
//
//        2112
//
//        46
//
//        Add to List
//
//        Share
//        You are given an integer array values where values[i] represents the value of the ith sightseeing spot. Two sightseeing spots i and j have a distance j - i between them.
//
//        The score of a pair (i < j) of sightseeing spots is values[i] + values[j] + i - j: the sum of the values of the sightseeing spots, minus the distance between them.
//
//        Return the maximum score of a pair of sightseeing spots.
//
//
//
//        Example 1:
//
//        Input: values = [8,1,5,2,6]
//        Output: 11
//        Explanation: i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
//        Example 2:
//
//        Input: values = [1,2]
//        Output: 2
//
//
//        Constraints:
//
//        2 <= values.length <= 5 * 104
//        1 <= values[i] <= 1000


class Solution {
    //Naive Approach T.C : O(n)
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int dp[]= new int[n];
        dp[0]= values[0];
        int omax = Integer.MIN_VALUE;
        for(int j = 1;j<n;j++){
            int max =0;
            for(int i=0;i<j;i++){
                int val = values[i]+values[j]+i-j;
                max = Math.max(max,val);
            }
            dp[j]= max;
            omax= Math.max(omax,dp[j]);
        }
        return omax;
    }

//    The apporach here is maintain a max value along with its pos which if added to some index j gives result. Then we are returing the maxSum. So in simple terms
//    Consider no 12 6 11 18
//    Initial max = 12;
//    Loc = 0;
//    Now starting from index 1 to all the way to end. We will be updating max and we will be caculating sum and in the end we will return the maxSum.
//    Now the main thing is how to decide which value should be replace with max value.
//
//            3 conditions
//
//    If next value is > max, replace max with next value,agree?
//    If next value is == max why?? because we need to consider indexes as well while calulating sum
//    If next value is < max. In this we need to consider one thing
//if(max - nextvalue < j - loc)
//    means even if the max is bigger but because it farther from the current j, it won't increase the sum if we use it
//            for ex consider 12 & 11
//    max = 12;
//    loc = 0;
//
//    nextValue = 11
//    j = 2
//
//            12-11 < 2 - 0
//    It means 11 should be our next max considering its location.
//
//    Another example
//14 6 11 18
//
//    Max = 14
//    loc = 0;
//    NextValue = 11
//    j = 2;
//14-11 > 2-0
//    here max - nextvalue is greater than the diff b/w locations. It means still we can compenstate for the distance and can go for the current max
//
//            Approach
//    Complexity
//    Time complexity: O(n)
//    Space complexity:  O(1)

    public int maxScoreSightseeingPair1(int[] values) {
        int max = values[0];
        int loc = 0;
        int sum = 0;
        for(int i = 1; i < values.length;i++)
        {
            sum = Math.max(sum, max + values[i] + loc - i);
            if(values[i] >= max)
            {
                max = values[i];
                loc = i;
            }
            else
            {
                if(max - values[i] <= i - loc)
                {
                    max = values[i];
                    loc = i;
                }
            }
        }
        return sum;
    }
}