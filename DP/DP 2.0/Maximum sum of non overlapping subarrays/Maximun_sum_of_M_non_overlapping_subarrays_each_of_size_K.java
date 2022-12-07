//Maximum Sum Of M Non-overlapping Subarrays
//        Hard  Prev   Next
//        1. You are given an array(arr) of positive numbers and two numbers M and K.
//        2. You have to find the maximum sum of M non-overlapping subarrays of size K.
//        3. The size of the given array(arr) is greater than M*K.
//
//        Constraints
//        1 <= N <= 10^3
//        1 <= arr[i] <= 10^3
//        M >= 1
//        K >= 1
//        N >= M*K
//
//        Sample Input
//        7
//        2 10 7 18 5 33 0
//        3
//        1
//        Sample Output
//        61
//
//        Sample Input
//        4
//        3 2 100 1
//        2
//        2
//        Sample Output
//        106

import java.io.*;
import java.util.*;

public class Main {

    //Tabulation for finding the maximum sum of m non overlapping subarrays of size k each.
    public static int tab_solution(int[] arr, int m, int k) {
        // write your code here
        int n = arr.length;
        int ssum[] = new int[n];


        //finding  suffix processed sum array (i.e sum of last k elements in n-1th index, (n-k-1 -- n-2) sum in n-2th index and so on...till 0th index)
        int sum = 0;
        for (int i = arr.length - 1; i >= arr.length - k; i--) {
            ssum[arr.length - 1] += arr[i];
        }
        for (int i = arr.length - 2; i >= k - 1; i--) {
            ssum[i] = ssum[i + 1] + arr[i - k + 1] - arr[i + 1];
        }

        //then filling the dp
        //finding max of ( dp[i-1][j] , dp[i-k][j-1]+ssum[i-1] )
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], i - k >= 0 ? dp[i - k][j - 1] + ssum[i - 1] : 0);
            }
        }
        return dp[n][m];
    }

    //Memoisation with recursion for finding the maximum sum of m non overlapping subarrays of size k each. (inclusion/exclusion concept)
    public static int solution(int[] arr, int idx, int m, int k, int[] psum, int dp[][]) {
        if (m == 0)
            return 0;

        if (idx >= arr.length)
            return 0;

        if (dp[idx][m] != 0)
            return dp[idx][m];

        int exclude = 0 + solution(arr, idx + 1, m, k, psum, dp);
        int include = psum[idx] + solution(arr, idx + k, m - 1, k, psum, dp);

        int ans = Math.max(include, exclude);
        dp[idx][m] = ans;
        return ans;

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0 ; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int m = scn.nextInt();
        int k = scn.nextInt();

        //finding pre processed sum array (i.e sum of first k elements in 0th index, 1-k+1 sum in 2nd index and so on...till nth index)
        int psum[] = new int[n];
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        psum[0] = sum;
        for (int j = 0, i = k; i < n; i++, j++) {
            sum += arr[i] - arr[j];
            psum[i - k + 1] = sum;
        }

        //Memoisation with recursion
        System.out.println(solution(arr, 0, m, k, psum, new int[n + 1][m + 1]));
        //Tabulation
        System.out.println(tab_solution(arr, m, k));
    }

}