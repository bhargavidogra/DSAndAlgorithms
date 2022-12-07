//Interleaving Of Two Strings
//        Medium  Prev   Next
//        1. You are given three strings - s1, s2 and s3.
//        2. You have to find whether s3 is formed by interleaving of s1 and s2.
//        3. s3 is interleaving if it contains all characters of s1 and s2, and order of all characters in individual string is preserved.
//        Input Format
//        String s1
//        String s2
//        String s3
//        Output Format
//        true/false
//
//        Constraints
//        1 <= s1.length() <= 100
//        1 <= s2.length() <= 100
//        1 <= s3.length() <= 200
//        Sample Input
//        aabcc
//        dbbca
//        aadbbcbcac
//        Sample Output
//        true


import java.io.*;
import java.util.*;

public class Main {

    public static boolean solution(String s1, String s2, String s3) {
        // write your code here
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        Boolean dp[][][] = new Boolean[s1.length() + 1][s2.length() + 1][s3.length() + 1];

        return helper(s1, s2, s3, 0, 0, 0, dp);

    }

    //using memoisation
    public static boolean helper(String s1, String s2, String s3, int i, int j, int k, Boolean dp[][][]) {
        // write your code here
        if (i == s1.length() && j == s2.length()) {
            return true;
        }

        if (dp[i][j][k] != null) {
            return dp[i][j][k];
        }

        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            boolean f1 = helper(s1, s2, s3, i + 1, j, k + 1, dp);
            dp[i][j][k] = f1;
            if (f1 == true) {
                return true;
            }
        }

        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            boolean f2 = helper(s1, s2, s3, i, j + 1, k + 1, dp);
            dp[i][j][k] = f2;
            if (f2 == true) {
                return true;
            }
        }
        dp[i][j][k] = false;
        return false;
    }

    //using tabulation
    public static boolean solution1(String s1, String s2, String s3) {
        boolean dp[][] = new boolean[s1.length() + 1][s2.length() + 1];

        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        for (int i = 0; i < s1.length() + 1; i++) {
            for (int j = 0; j < s2.length() + 1; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) { // s1 is empty string
                    dp[i][j] = s2.charAt(j - 1) == s3.charAt(i + j - 1) ? dp[i][j - 1] : false;
                } else if (j == 0) { // s2 is empty string
                    dp[i][j] = s1.charAt(i - 1) == s3.charAt(i + j - 1) ? dp[i - 1][j] : false ;
                } else {
                    if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                        dp[i][j] = dp[i - 1][j] ;
                    }

                    if ( (dp[i][j] == false) && (s2.charAt(j - 1) == s3.charAt(i + j - 1)) ) {
                        dp[i][j] =  dp[i][j - 1] ;
                    }
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.nextLine();
        String s2 = scn.nextLine();
        String s3 = scn.nextLine();
        System.out.println(solution1(s1, s2, s3));
    }

}