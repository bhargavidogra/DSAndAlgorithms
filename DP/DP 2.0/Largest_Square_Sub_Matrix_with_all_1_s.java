//Largest Square Sub-matrix With All 1's
//        Medium  Prev   Next
//        1. You are given a matrix of 0's and 1's.
//        2. You have to find the maximum size square sub-matrix with all 1's.
//        Input Format
//        A number N, which represents number of rows in matrix
//        A number M, which represents number of columns in matrix
//        arr1
//        arr2...N*M numbers
//
//        Constraints
//        1 <= N,M <= 100
//        0<= arr[i][j] <= 1
//
//        Sample Input
//        5 6
//        0 1 0 1 0 1
//        1 0 1 0 1 0
//        0 1 1 1 1 0
//        0 0 1 1 1 0
//        1 1 1 1 1 1
//
//        Sample Output
//        3

import java.io.*;
import java.util.*;

 class Main {

    public static int solution(int[][] arr) {
        //write your code here
        int n = arr.length;
        int m = arr[0].length;
        int dp[][] = new int[n][m];
        int max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 || j == m - 1) {
                    dp[i][j] = arr[i][j];
                } else {
                    if (arr[i][j] == 0) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = Math.min(dp[i][j + 1], Math.min(dp[i + 1][j], dp[i + 1][j + 1])) + 1;
                    }
                }
                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0 ; i < n; i++) {
            for (int j = 0 ; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        System.out.println(solution(arr));
    }

}