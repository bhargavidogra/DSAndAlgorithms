//Print All Paths With Minimum Jumps
//        Medium  Prev   Next
//        1. You are given a number N representing number of elements.
//        2. You are given N space separated numbers (ELE : elements).
//        3. Your task is to find & print
//        3.1) "MINIMUM JUMPS" need from 0th step to (n-1)th step.
//        3.2) all configurations of "MINIMUM JUMPS".
//        NOTE: Checkout sample question/solution video inorder to have more insight.
//        Input Format
//        A number N (representing "NUMBER OF ELEMENTS").
//        ELE1 ,ELE2 ,ELE3 ,ELE4 .... ELEn (N space separated numbers represnting numbers).
//        Output Format
//        1) A number representing "MINIMUM JUMPS" need from 0th step to (n-1)th step.
//        2) Strings representing configurations of "MINIMUM JUMPS".
//        Check the sample ouput and question video.
//        Constraints
//        1 <= N <= 100
//        1 <= ELE <= 1000
//        Sample Input
//        10
//        3
//        3
//        0
//        2
//        1
//        2
//        4
//        2
//        0
//        0
//        Sample Output
//        4
//        0 -> 3 -> 5 -> 6 -> 9 .
//        0 -> 3 -> 5 -> 7 -> 9 .

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

 class Main {

    static class Pair {
        int idx;
        int sz;
        int jmp;
        String psf;
        Pair(int i, int s, int v, String psf) {
            this.idx = i;
            this.sz = s;
            this.jmp = v;
            this.psf = psf;
        }
    }

    public static void Solution(int arr[]) {
        // write your code here
        int n = arr.length;
        Integer dp[] = new Integer[n];
        dp[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= arr[i] && i + j < n; j++) {
                if (dp[i + j] != null && dp[i + j] < min) {
                    min = dp[i + j];
                }
            }
            if (min != Integer.MAX_VALUE) {
                dp[i] = min + 1;
            }
        }

        System.out.println(dp[0]);

        ArrayDeque<Pair> qu = new ArrayDeque<Pair>();
        qu.add(new Pair(0, arr[0], dp[0], 0 + ""));
        while (qu.size() > 0) {
            Pair rem = qu.removeFirst();
            if (rem.jmp == 0) {
                System.out.println(rem.psf + " .");
            }

            for (int j = 1; j <= rem.sz && rem.idx + j < arr.length; j++) {
                int ci = rem.idx + j;
                if (dp[ci] != null && dp[ci] == rem.jmp - 1) {
                    qu.add(new Pair(ci, arr[ci], dp[ci], rem.psf + " -> " + ci));
                }
            }
        }
    }


    public static void main(String []args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int arr[] = new int[n];
        for (int i = 0 ; i < n ; i++)
            arr[i] = scn.nextInt();

        Solution(arr);
        scn.close();
    }
}
