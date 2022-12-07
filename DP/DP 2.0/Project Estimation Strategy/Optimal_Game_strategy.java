//Optimal Strategy For A Game
//        Easy  Prev   Next
//        1. You are given an array(arr) of length N, where N is an even number.
//        2. The elements of the array represent N coins of values arr1,arr1...arrN.
//        3. You are playing a game against an opponent in an alternative way, where the opponent is equally smart.
//        4. In this game, a player selects either the first or the last coin from the row in every turn, removes it from the row permanently, and receives the value of the coin.
//        5. You have to find the maximum possible amount of money you can win if you make the first move.
//        Input Format
//        Sample Input
//        4
//        5
//        3
//        7
//        10
//        Sample Output
//        15


import java.io.*;
import java.util.*;

 class Main {

    public static void optimalStrategy(int[] arr) {
        //write your code here
        int n = arr.length;
        int dp[][] = new int[n][n];

        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                if (g == 0) {
                    dp[i][j] = arr[i];
                } else if (g == 1) {
                    dp[i][j] = Math.max(arr[i], arr[j]);
                } else {
                    dp[i][j] = Math.max(
                            arr[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]),
                            arr[j] + Math.min(dp[i][j - 2], dp[i + 1][j - 1])
                    );
                }
            }
        }
        System.out.println(dp[0][n - 1]);

    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = scn.nextInt();
        }
        optimalStrategy(a);
    }

}