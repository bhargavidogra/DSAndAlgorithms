//Burst Balloons
//        Hard  Prev   Next
//        1. You are given an array(arr) of length N which represents N number of balloons.
//        2. Each balloon is painted with a number on it.
//        3. You have to collect maximum coins by bursting all the balloons.
//        4. If you burst a balloon with index i, you will get (arr[i-1] * arr[i] * arr[i+1]) number of coins.
//        5. If arr[i-1] and arr[i+1] don't exist, then you may assume their value as 1.
//
//        Constraints
//        1 <= N <= 1000
//        1 <= arr[i] <= 100
//
//        Sample Input
//        3
//        1
//        2
//        3
//
//        Sample Output
//        12


import java.io.*;
import java.util.*;

 class Main {

    public static int solution(int[] arr) {
        //write your code here
        int n = arr.length;
        int dp[][] = new int[n][n];

        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                int max = Integer.MIN_VALUE;

                for (int k = i; k <= j; k++) {
                    int left = k == i ? 0 : dp[i][k - 1];
                    int right = k == j ? 0 : dp[k + 1][j];
                    int val = (i == 0 ? 1 : arr[i - 1]) * arr[k] * (j == n - 1 ? 1 : arr[j + 1]);

                    int total = left + right + val;
                    if (total > max) {
                        max = total;
                    }
                }
                dp[i][j] = max;
            }
        }


        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }

}