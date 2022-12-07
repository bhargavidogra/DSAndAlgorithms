//Maximum Sum Subarray With At Least K Elements
//        Medium  Prev   Next
//        1. You are given an array(arr) of integers and a number k.
//        2. You have to find maximum subarray sum in the given array.
//        3. The subarray must have at least k elements.
//        Constraints
//        1 <= N <= 10^5
//        1 <= arr[i] <= 10^5
//        1 <= K <= N
//        Sample Input
//        3
//        1
//        2
//        3
//        2
//        Sample Output
//        6

import java.io.*;
import java.util.*;

 class Main {

    public static int solution(int[] arr, int k) {
        // write your code here
        int n = arr.length;
        int dp[] = new int[n];
        int ans = Integer.MIN_VALUE;
        dp[0] = arr[0];
        int curr_sum = arr[0];

        for (int i = 1; i < n; i++) {
            if (curr_sum >= 0) {
                curr_sum += arr[i];
            } else {
                curr_sum = arr[i];
            }
            dp[i] = curr_sum;
        }
        int exactK = 0;
        for (int i = 0; i < k; i++) {
            exactK += arr[i];
        }

        if (exactK > ans) {
            ans = exactK;
        }
        for (int i = k, j = 0; i < n; i++, j++) {
            exactK += arr[i] - arr[j];

            if (exactK > ans) {
                ans = exactK;
            }

            if (exactK + dp[j] > ans) {
                ans = exactK + dp[j];
            }
        }


        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        System.out.println(solution(arr, k));
    }
}