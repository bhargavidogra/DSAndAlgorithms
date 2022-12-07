//Print All Results In 0-1 Knapsack
//        Medium  Prev   Next
//        1. You are given a number n, representing the count of items.
//        2. You are given n numbers, representing the values of n items.
//        3. You are given n numbers, representing the weights of n items.
//        3. You are given a number "cap", which is the capacity of a bag you've.
//        4. You are required to calculate and print the maximum value that can be created in the bag without overflowing it's capacity.
//        5. Also, you have to print the indices of items that should be selected to make maximum profit.
//        6. You have to print all such configurations.
//
//        Note -> Each item can be taken 0 or 1 number of times. You are not allowed to put the same item again and again.
//
//        Constraints
//        1 <= n <= 10^2
//        1 <= m <= 10^2
//        0 <= e1, e2, .. n * m elements <= 1000
//        Sample Input
//        5
//        15 14 10 45 30
//        2 5 1 3 4
//        7
//        Sample Output
//        75
//        3 4


import java.io.*;
import java.util.*;

public class Main {
    private static class Pair {
        int i;
        int j;
        String psf;
        Pair(int i, int j, String psf) {
            this.i = i;
            this.j = j;
            this.psf = psf;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] values = new int[n];
        String str1 = br.readLine();
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(str1.split(" ")[i]);
        }

        int[] wts = new int[n];
        String str2 = br.readLine();
        for (int i = 0; i < n; i++) {
            wts[i] = Integer.parseInt(str2.split(" ")[i]);
        }

        int cap = Integer.parseInt(br.readLine());

        //write your code here
        print_01_Knapsack(values, wts, cap);
    }

    public static void print_01_Knapsack(int [] values, int [] wts, int cap) {
        int n = wts.length;
        int dp[][] = new int[n + 1][cap + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j <= cap; j++) {
                if (j - wts[i - 1] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wts[i - 1]] + values[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[n][cap]);

        ArrayDeque<Pair> qu = new ArrayDeque<Pair>();

        qu.add(new Pair(n, cap, ""));

        while (qu.size() > 0) {
            Pair rm = qu.removeFirst();

            if (rm.i == 0 || rm.j == 0) {
                System.out.println(rm.psf);
            }
            else {

                if (rm.j - wts[rm.i - 1] >= 0) {
                    int inc = dp[rm.i - 1][rm.j - wts[rm.i - 1]] + values[rm.i - 1];
                    if (dp[rm.i][rm.j] == inc) {
                        qu.add(new Pair(rm.i - 1, rm.j - wts[rm.i - 1], (rm.i - 1) + " " + rm.psf ));
                    }
                }

                int exc = dp[rm.i - 1][rm.j];
                if (dp[rm.i][rm.j] == exc) {
                    qu.add(new Pair(rm.i - 1, rm.j, rm.psf + " "));
                }


            }


        }
    }
}








