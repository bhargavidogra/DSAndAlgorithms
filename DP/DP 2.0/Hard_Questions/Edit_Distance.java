//Edit Distance
//        Hard  Prev   Next
//        1. You are given two strings s1 and s2.
//        2. You have to find the minimum number of operations needed to convert s1 to s2.
//        Operations allowed are -
//        Insert - You can insert any character in s1.
//        Remove - You can remove any character in s1.
//        Replace - You can replace any character in s1 with any other character.
//
//        Sample Input
//        pepperatcoding
//        pepcoding
//        Sample Output
//        5


import java.io.*;
import java.util.*;

public class Main {

    public static int solution(String str1, String str2) {
        //write your code here
        int dp[][] = new int [str1.length() + 1][str2.length() + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 0;
                } else if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        int f1 = dp[i - 1][j - 1]; //replace char c1 in str1
                        int f2 = dp[i - 1][j]; //delete char c1 in str1
                        int f3 = dp[i][j - 1]; //insert char c2 in str1 to make str equal
                        dp[i][j] = Math.min(f1, Math.min(f2, f3)) + 1;
                    }
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        System.out.println(solution(s1, s2));
    }

}