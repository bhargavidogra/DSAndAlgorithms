//Buy And Sell Stocks - K Transactions Allowed
//        Easy  Prev   Next
//        1. You are given a number n, representing the number of days.
//        2. You are given n numbers, where ith number represents price of stock on ith day.
//        3. You are given a number k, representing the number of transactions allowed.
//        3. You are required to print the maximum profit you can make if you are allowed k transactions at-most.
//        Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).
//        Sample Input
//        6
//        9
//        6
//        7
//        6
//        3
//        8
//        1
//
//        Sample Output
//        5

import java.io.*;
import java.util.*;
class Scratch {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        int dp[][] = new int[k + 1][n];

        //naive Approach O(n^3)
        for (int t = 1; t <= k; t++) {
            for (int d = 1; d < n; d++) {
                int max = dp[t][d - 1];
                for (int pd = 0; pd < d; pd++) {
                    int pecm = dp[t - 1][pd] + arr[d] - arr[pd];
                    if (pecm > max) {
                        max = pecm;
                    }
                }
                dp[t][d] = max;
            }
        }

        //optimised Approach  O(n^2)
        for (int t = 1; t <= k; t++) {
            int max = Integer.MIN_VALUE;
            for (int d = 1; d < n; d++) {
                //if value@23 = ? , then  max = Max of (value@12-price@2 , max)
                if (dp[t - 1][d - 1] - arr[d - 1] > max) {
                    max = dp[t - 1][d - 1] - arr[d - 1];
                }
                //if (max + price@3 > value@22) , then value@23 =  max + price@3 else value@23 = value@22
                if (max + arr[d] > dp[t][d - 1]) {
                    dp[t][d] = max + arr[d];
                } else {
                    dp[t][d] = dp[t][d - 1];
                }

            }
        }

        System.out.println(dp[k][n - 1]);

    }
}