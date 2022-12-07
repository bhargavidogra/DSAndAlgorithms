//Longest Palindromic Substring
//        Medium  Prev   Next
//        1. You are given a string str.
//        2. You are required to print the length of longest of palindromic substrings in string str.
//
//        Sample Input
//        abccbc
//        Sample Output
//        4

import java.io.*;
import java.util.*;

 class Main {

    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();



        int l = s.length();
        boolean dp[][] = new boolean[l][l];
        //finding plindromic substrings
        int max_len = 0;
        for (int g = 0; g < l; g++) {
            for (int i = 0, j = g; j < l; j++, i++) {
                if (g == 0) {
                    dp[i][j] = true;

                } else if (g == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;

                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = false;
                    }
                }

                if (dp[i][j]) {
                    int len = (j + 1 - i);
                    if (len > max_len) {
                        max_len = len;
                    }
                }


            }
        }

        System.out.println(max_len);
    }

}