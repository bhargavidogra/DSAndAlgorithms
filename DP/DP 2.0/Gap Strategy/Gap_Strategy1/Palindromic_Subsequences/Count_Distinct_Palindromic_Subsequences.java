
//Count Of Distinct Palindromic Subsequences
//        Medium  Prev   Next
//        1. You are given a string.
//        2. You have to print the count of distinct and non-empty palindromic subsequences in the given string.
//        3. Two sequences s1 and s2 are distinct if here is some i, for which ith character in s1 and s2 are different.
//
//        Note -> String contains only lowercase letters.
//        -> The answer will be in the integer range only.
//
//
//        Sample Input
//        bccb
//        Sample Output
//        6
//
//        Sample Input
//        abacdaea
//        Sample Output
//        14
//
//        Sample Input
//        abacdaeaca
//        Sample Output
//        28


import java.io.*;
import java.util.*;

 class Main {

    public static int solution(String str) {
        // write your code here
        int n = str.length();
        int dp[][] = new int[n][n];
        int prev[] = new int[n];
        int next[] = new int[n];

        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (hm.containsKey(c) == false) {
                prev[i] = -1;
            } else {
                prev[i] = hm.get(c);
            }
            hm.put(c, i);
        }

        hm.clear();

        for (int i = n - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (hm.containsKey(c) == false) {
                next[i] = -1;
            } else {
                next[i] = hm.get(c);
            }
            hm.put(c, i);
        }

        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                if (g == 0) {
                    dp[i][j] = 1;
                } else if (g == 1) {
                    dp[i][j] = 2;
                } else {
                    char sc = str.charAt(i);
                    char ec = str.charAt(j);

                    if (sc != ec) {
                        dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
                    } else {
                        int ni = next[i];
                        int pi = prev[j];

                        if (ni > pi) {
                            dp[i][j] = 2 * dp[i + 1][j - 1] + 2;
                        } else  if (ni == pi) {
                            dp[i][j] = 2 * dp[i + 1][j - 1] + 1;
                        } else {
                            dp[i][j] = 2 * dp[i + 1][j - 1] - dp[ni + 1][pi - 1];
                        }
                    }
                }
            }
        }

        return dp[0][n - 1];
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
    }

}