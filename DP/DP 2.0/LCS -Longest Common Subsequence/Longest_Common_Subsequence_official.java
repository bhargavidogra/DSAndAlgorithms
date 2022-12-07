//Longest Common Subsequence
//        Medium  Prev   Next
//        1. You are given a string str1.
//        2. You are given another string str2.
//        3. You are required to print the length of longest common subsequence of two strings.
//
//        Sample Input
//        abcd
//        aebd
//        Sample Output
//        3

import java.io.*;
import java.util.*;

 class Main {

    public static int solution(String s1, String s2) {

        int s1l = s1.length();
        int s2l = s2.length();
        int dp[][] = new int[s1l + 1][s2l + 1];
        for (int i = s1l; i >= 0; i--) {
            for (int j = s2l; j >= 0; j--) {
                if ((i == s1l) || (j == s2l)) {
                    dp[i][j] = 0;
                }
                else {
                    char c11 = s1.charAt(i);
                    char c22 = s2.charAt(j);
                    if (c11 == c22) {
                        dp[i][j] = dp[i + 1][j + 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                    }
                }
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        System.out.println(solution(s1, s2));
    }

}