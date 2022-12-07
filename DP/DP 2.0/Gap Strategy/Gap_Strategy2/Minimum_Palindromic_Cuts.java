//Minimum Palindromic Cut
//        Easy  Prev   Next
//        1. You are given a string.
//        2. You have to find the minimum number of cuts required to convert the given string into palindromic partitions.
//        3. Partitioning of the string is a palindromic partitioning if every substring of the partition is a palindrome.
//
//        Sample Input
//        abccbc
//        Sample Output
//        2



import java.io.*;
import java.util.*;

 class Main {

    public static int minPalindromicCut(String s) {
        //write your code here
        int l = s.length();
        boolean dp[][] = new boolean[l][l];
        //finding plindromic substrings
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
            }
        }
        //finding minimum cuts required in string
        int dp1[][] = new int[l][l];
        for (int g = 0; g < l; g++) {
            for (int i = 0, j = g; j < l; j++, i++) {
                if (g == 0) {
                    dp1[i][j] = 0;
                } else if (g == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp1[i][j] = 0;
                    } else {
                        dp1[i][j] = 1;
                    }
                } else {
                    if (dp[i][j]) {
                        dp1[i][j] = 0;
                    } else {
                        int min = Integer.MAX_VALUE;
                        for (int k = i; k < j; k++) {
                            int val = dp1[i][k] + dp1[k + 1][j] + 1;
                            if (val < min) {
                                min = val;
                            }
                        }
                        dp1[i][j] = min == Integer.MAX_VALUE ? 0 : min;
                    }
                }
            }

        }



        return dp1[0][l - 1];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        System.out.println(minPalindromicCut(str));
    }
}