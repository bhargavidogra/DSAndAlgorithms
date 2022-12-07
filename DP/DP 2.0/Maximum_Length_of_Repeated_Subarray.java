//Maximum Length Of Repeated Subarray
//        Medium  Prev   Next
//        1. You are given two arrays of integers arr1 and arr2.
//        2. You have to find the maximum length of subarray that appears in both the given arrays.
//        Input Format
//        A number N
//        a1
//        a2.. N numbers
//        A number M
//        b1
//        b2.. M numbers
//        Output Format
//        An integer representing the maximum length of repeated subarray.
//
//        Constraints
//        1 <= N,M <= 10^4
//        0 <= a[i], b[i] <= 10^3
//        Sample Input
//        5
//        5 4 3 2 1
//        6
//        7 8 4 3 2 5
//        Sample Output
//        3


import java.io.*;
import java.util.*;

 class Main {

    public static int solution(int[] arr1, int[] arr2) {
        // write your code here
        int n = arr1.length;
        int m = arr2.length;

        int dp[][] = new int[n + 1][m + 1];
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] += dp[i - 1][j - 1] + 1;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0 ; i < n; i++) {
            arr1[i] = scn.nextInt();
        }

        int m = scn.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0 ; i < m; i++) {
            arr2[i] = scn.nextInt();
        }
        System.out.println(solution(arr1, arr2));
    }

}