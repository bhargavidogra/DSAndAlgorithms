//Scramble String
//        Hard  Prev   Next
//        1. You are given two strings s1 and s2.
//        2. A string can be represented as a binary tree by partitioning it to two non-empty substrings recursively.
//        3. If you choose any non-leaf node and swap its two children, then the string formed is the scramble of the original string.
//        4. You have to determine if s2 is a scrambled string of s1.
//
//        Constraints
//        1 < length of strings <= 100
//        Sample Input
//        great
//        rgeat
//        Sample Output
//        true


import java.io.*;
import java.util.*;

 class Main {

    //Using Recursion
    public static boolean isScramble(String s1, String s2)
    {
        if (s1.equals(s2)) {
            return true;
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 1; i < s1.length(); i++) {
            String s1_l = s1.substring(0, i);
            String s2_l = s2.substring(0, i);
            String s1_r = s1.substring(i);
            String s2_r = s2.substring(i);
            String s2_back_r = s2.substring(s2.length() - i);
            String s2_front_l = s2.substring(0, s2.length() - i);
                    //S1 = g|reat  S2 = t|aerg   checking g==t? ## S1 = g|reat    S2 = t|aerg   checking reat==aerg
            if (    ( isScramble(s1_l, s2_l) && isScramble(s1_r, s2_r) ) ||
                    // S1 = g|reat S2 = taer|g   checking g==g? ## S1 = g|reat    S2 = taer|g   checking reat== (taer-->reat)
                    ( isScramble(s1_l, s2_back_r) && isScramble(s1_r, s2_front_l) ) ) {
                return true;
            }
        }

        return false;
    }

    //Using Memoisation
    public static boolean isScrambleTab1(String s1, String s2, int si1, int ei1, int si2, int ei2, Boolean dp[][][][])
    {
        //write your code here
        if ((s1.substring(si1, ei1 + 1)).equals(s2.substring(si2, ei2 + 1))) {
            return true;
        }

        if (dp[si1][ei1][si2][ei2] != null) {
            return dp[si1][ei1][si2][ei2];
        }

        //S1 = great S2 = taerg
        for (int k = 0 ; k < ei1 - si1 ; k++) {
            // k= 1   S1 = g|reat    S2 = t|aerg   checking g==t?             S1 = g|reat    S2 = t|aerg   checking reat==aerg?
            if ( ( isScrambleTab1(s1, s2, si1, si1 + k, si2, si2 + k, dp) && isScrambleTab1(s1, s2, si1 + k + 1, ei1, si2 + k + 1, ei2, dp) ) ||
                    // k= 1   S1 = g|reat    S2 = taer|g   checking g==g?             S1 = g|reat    S2 = taer|g   checking reat== (taer-->reat)?
                    ( isScrambleTab1(s1, s2, si1, si1 + k, ei2 - k, ei2, dp) && isScrambleTab1(s1, s2, si1 + k + 1, ei1, si2, ei2 - k - 1, dp) )) {
                return dp[si1][ei1][si2][ei2] = true;
            }
        }

        return dp[si1][ei1][si2][ei2] = false;
    }


    //using 3D dp Tabulation
    public static boolean isScrambleTab2(String s1, String s2) {
        //write your code here
        int n = s1.length();
        boolean dp[][][] = new boolean [n][n][n + 1];

        for (int len = 1; len <= n; len++)
        {
            for (int i = 0; i <= n - len; i++)
            {
                for (int j = 0; j <= n - len; j++)
                {
                    if (len == 1) {
                        dp[i][j][len] = (s1.charAt(i)) == (s2.charAt(j));
                    } else {
                        for (int k = 1; k < len && !dp[i][j][len]; k++)
                        {
                            dp[i][j][len] = ( (dp[i][j][k] && dp[i + k][j + k][len - k] ) ) || ( dp[i][j + len - k][k] && dp[i + k][j][len - k] );
                        }
                    }
                }
            }
        }


        return dp[0][0][n];
    }


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        int ei1 = s1.length();
        int ei2 = s2.length();
        //Simple Recursion
        System.out.println(isScramble(s1, s2));
        //Using memoisation
        Boolean dp[][][][] = new Boolean[ei1 + 1][ei1 + 1][ei1 + 1][ei1 + 1];
        System.out.println(isScrambleTab1(s1, s2, 0, ei1 - 1, 0, ei2 - 1, dp));
        //using 3D dp Tabulation
        System.out.println(isScrambleTab2(s1, s2));

    }

}