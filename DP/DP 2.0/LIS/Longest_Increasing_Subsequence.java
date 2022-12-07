//Longest Increasing Subsequence
//        Medium  Prev   Next
//        1. You are given a number n, representing the number of elements.
//        2. You are given n numbers, representing the contents of array of length n.
//        3. You are required to print the length of longest increasing subsequence of array.
//        Sample Input
//        10
//        10
//        22
//        9
//        33
//        21
//        50
//        41
//        60
//        80
//        1
//        Sample Output
//        6

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

        int dp[] = new int[n];
        int omax = 0;
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if (dp[j] > max) {
                        max = dp[j];
                    }
                }
            }

            dp[i] = max + 1;

            if (dp[i] > omax) {
                omax = dp[i];
            }
        }
        System.out.println(omax);

    }
}