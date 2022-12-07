//Longest Palindromic Subsequences
//        Medium  Prev   Next
//        1. You are given a string str.
//        2. You are required to print the length of longest palindromic subsequence of string str.
//
//        Sample Input
//        abcgackbc
//        Sample Output
//        5


import java.io.*;
import java.util.*;

 class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int l = str.length();

        int dp[][] = new int[l][l];


        for (int g = 0; g < l; g++) {
            for (int i = 0, j = g; j < l; j++, i++) {
                if (g == 0) {
                    dp[i][j] = 1;
                } else if (g == 1) {
                    if (str.charAt(i) == str.charAt(j)) {
                        dp[i][j] = 2;
                    } else {
                        dp[i][j] = 1;
                    }
                } else {
                    if (str.charAt(i) == str.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                    }
                }
            }
        }

        System.out.println(dp[0][l - 1]);
    }

}