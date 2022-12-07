//Rod Cutting
//        Easy  Prev   Next
//        1. You are given an integer N, which represents the length of a rod, and an array of integers, which represents the prices of rod pieces of length varying from 1 to
//        N.
//        2. You have to find the maximum value that can be obtained by selling the rod.
//        3. You can sell it in pieces or as a whole.
//
//        Sample Input
//        8
//        1
//        5
//        8
//        9
//        10
//        17
//        17
//        20
//        Sample Output
//        22




import java.io.*;
import java.util.*;

public class Main {

    public static int solution(int[] prices) {
        // write your code here
        int n = prices.length;
        int np[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            np[i + 1] = prices[i];
        }
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = np[1];

        for (int i = 2; i < n + 1; i++) {
            int max = Integer.MIN_VALUE;
            int left = 1;
            int right = i - 1;
            while (left <= right) {
                int val = dp[left] + dp[right];
                max = Math.max(max, val);
                left++;
                right--;
            }
            dp[i] =  Math.max(max, np[i]);
        }


        return dp[n];
    }

    public static int solution2(int[] prices) {
        int n = prices.length;
        int p2[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            p2[i + 1] = prices[i];
        }

        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = p2[1];
        for (int i = 2; i < n + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j < i; j++) {
                int val = p2[j] + dp[i - j];
                max = Math.max(max, val);
            }
            max = Math.max(max, p2[i]);
            dp[i] = max;
        }


        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }
        System.out.println(solution2(prices));
    }

}