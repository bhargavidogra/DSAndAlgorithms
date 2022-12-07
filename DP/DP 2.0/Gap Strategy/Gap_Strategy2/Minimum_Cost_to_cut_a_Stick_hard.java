//Minimum Cost to Cut a Stick
//        Hard
//
//        2221
//
//        41
//
//        Add to List
//
//        Share
//        Given a wooden stick of length n units. The stick is labelled from 0 to n. For example, a stick of length 6 is labelled as follows:
//
//
//        Given an integer array cuts where cuts[i] denotes a position you should perform a cut at.
//
//        You should perform the cuts in order, you can change the order of the cuts as you wish.
//
//        The cost of one cut is the length of the stick to be cut, the total cost is the sum of costs of all cuts. When you cut a stick, it will be split into two smaller sticks (i.e. the sum of their lengths is the length of the stick before the cut). Please refer to the first example for a better explanation.
//
//        Return the minimum total cost of the cuts.
//
//
//
//        Example 1:
//
//
//        Input: n = 7, cuts = [1,3,4,5]
//        Output: 16
//        Explanation: Using cuts order = [1, 3, 4, 5] as in the input leads to the following scenario:
//
//        The first cut is done to a rod of length 7 so the cost is 7. The second cut is done to a rod of length 6 (i.e. the second part of the first cut), the third is done to a rod of length 4 and the last cut is to a rod of length 3. The total cost is 7 + 6 + 4 + 3 = 20.
//        Rearranging the cuts to be [3, 5, 1, 4] for example will lead to a scenario with total cost = 16 (as shown in the example photo 7 + 4 + 3 + 2 = 16).
//        Example 2:
//
//        Input: n = 9, cuts = [5,6,1,4,2]
//        Output: 22
//        Explanation: If you try the given cuts ordering the cost will be 25.
//        There are much ordering with total cost <= 25, for example, the order [4, 6, 5, 2, 1] has total cost = 22 which is the minimum possible.
//
//
//        Constraints:
//
//        2 <= n <= 106
//        1 <= cuts.length <= min(n - 1, 100)
//        1 <= cuts[i] <= n - 1
//        All the integers in cuts array are distinct.


class Solution {
    //Using Tabuulation
    public int minCost(int n, int[] cuts) {

        int  l = cuts.length;
        Arrays.sort(cuts);
        int ncuts[] = new int[l+2];
        ncuts[0]=0;
        ncuts[l+1]=n;
        for(int i=0;i<l;i++){
            ncuts[i+1]=cuts[i];
        }

        int dp[][]= new int[l+2][l+2];

        for(int g=1;g<l+1;g++){
            for(int i=1,j=g;j<l+1;j++,i++){
                int min = Integer.MAX_VALUE;

                for(int k=i;k<=j;k++){
                    int mycost = ncuts[j+1]-ncuts[i-1];
                    int left = dp[i][k-1];
                    int right = dp[k+1][j];
                    int tcost = mycost+left+right;

                    min = Math.min(min,tcost);
                }
                dp[i][j]=min;
            }
        }
        return dp[1][l];
    }

    //using Memoisation Approach
    public int minCost(int n, int[] cuts) {
        int len = cuts.length;
        Arrays.sort(cuts);
        Integer dp[][]= new Integer[n+1][n+1];
        return cost(cuts, 0, n, dp);
    }
    public int cost(int cuts[], int l, int r, Integer dp[][]) {

        if(dp[l][r]!= null){
            return dp[l][r];
        }

        int min = Integer.MAX_VALUE;

        for(int i : cuts) {
            if(i <= l || i >= r) {
                continue;
            }

            int temp = cost(cuts, l, i,dp);
            temp += cost(cuts, i, r,dp);
            min = Math.min(temp + r - l, min);
        }
        if(min == Integer.MAX_VALUE) {
            min = 0;
        }

        dp[l][r] = min;
        return min;
    }
}