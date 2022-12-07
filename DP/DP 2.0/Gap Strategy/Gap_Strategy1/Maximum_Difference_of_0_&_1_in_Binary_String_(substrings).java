//Maximum Difference Of Zeros And Ones In Binary String (substrings)
//        Easy  Prev   Next
//        1. You are given a string containing only 0's and 1's.
//        2. You have to find the length of substring which is having maximum difference of number of 0s and number of 1s i.e (Number of 0's - Number of 1's).
//        3. If there are all 1's present in the given string, then print '-1'.
//
//        Sample Input
//        11000010001
//        Sample Output
//        6

import java.io.*;
import java.util.*;

 class Main {

     //Solution using gap strategy complexity: o(n^2)
    public static int solution(String str) {
        // write your code here
        int n = str.length();
        int dp[][] = new int[n][n];
        int omax = Integer.MIN_VALUE;
        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                if (g == 0) {
                    char ch = str.charAt(i);
                    if (ch == '0') {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = -1;
                    }
                } else if (g == 1) {
                    char c1 = str.charAt(i);
                    char c2 = str.charAt(j);
                    if (c1 == c2) {
                        if (c1 == '0') {
                            dp[i][j] = 2;
                        } else {
                            dp[i][j] = -2;
                        }
                    } else {
                        dp[i][j] = 0;
                    }

                } else {
                    char c1 = str.charAt(i);
                    char c2 = str.charAt(j);

                    if (c1 == c2) {
                        if (c1 == '0') {
                            dp[i][j] = 2 + dp[i + 1][j - 1];
                        } else {
                            dp[i][j] = -2 + dp[i + 1][j - 1];
                        }
                    } else {
                        dp[i][j] = 0 + dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] > omax) {
                    omax = dp[i][j];
                }
            }
        }

        return omax;
    }

     //Solution using Kadance Algorithm complexity: o(n)
    public static int solution2(String str) {
        int n = str.length();
        int max_sum = Integer.MIN_VALUE;
        int max_sum_so_far = 0;
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            int v = 0;

            if (c == '0') {
                v = 1;
            } else {
                v = -1;
            }

            max_sum_so_far = Math.max(max_sum_so_far + v, v);
            max_sum = Math.max(max_sum, max_sum_so_far);
        }

        return max_sum;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String string = scn.next();

        //using gap strategy complexity: o(n^2)
        System.out.println(solution(string));

        // using Kadance Algorithm complexity: o(n)
        System.out.println(solution2(string));
    }

}