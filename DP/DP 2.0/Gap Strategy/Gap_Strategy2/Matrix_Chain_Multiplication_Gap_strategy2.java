//Matrix Chain Multiplication
//        Medium  Prev   Next
//        1. You are given an array(arr) of positive integers of length N which represents the dimensions of N-1 matrices such that the ith matrix is of dimension arr[i-1] x arr[i].
//        2. You have to find the minimum number of multiplications needed to multiply the given chain of matrices.
//
//        Constraints
//        2 <= N <= 1000
//        1 <= arr[i] <= 500
//        Sample Input
//        3
//        1
//        2
//        3
//        Sample Output
//        6


import java.io.*;
import java.util.*;

 class Main {

    public static int mcm(int[] arr) {
        //write your code here
        int n = arr.length;
        int dp[][] = new int[n - 1][n - 1];

        for (int g = 0; g < n - 1; g++) {
            for (int i = 0, j = g; j < n-1; i++, j++) {
                if (g == 0) {
                    dp[i][j] = 0;
                } else if (g == 1) {
                    dp[i][j] = arr[i] * arr[j] * arr[j + 1];
                } else {

                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        int left = dp[i][k];
                        int right = dp[k + 1][j];
                        int val = arr[i] * arr[k+1] * arr[j + 1];
                        int total = left + right + val;
                        if (total < min) {
                            min = total;
                        }
                    }
                    dp[i][j] = min;
                }
            }
        }



        return dp[0][n - 2];
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0 ; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(mcm(arr));
    }


}