//Ugly Number
//        Medium  Prev   Next
//        1. You are given a number N.
//        2. You have to find Nth ugly number.
//        3. Ugly number is defined as the number whose prime factors are only 2,3 and 5.
//        4. First eleven ugly numbers are -> 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15.
//
//        Assumption -> 1 is the first ugly number.
//        Constraints
//        1 <= N <= 10^4
//        Sample Input
//        4
//        Sample Output
//        4


import java.io.*;
import java.util.*;

 class Main {

    public static int solution(int n) {
        // write your code here
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        int p2 = 1;
        int p3 = 1;
        int p5 = 1;
        for (int i = 2; i < n + 1; i++) {
            int f1 = 2 * dp[p2];
            int f2 = 3 * dp[p3];
            int f3 = 5 * dp[p5];
            int min = Math.min(f1, Math.min(f2, f3));

            dp[i] = min;

            if (f1 == min)
                p2++;

            if (f2 == min)
                p3++;

            if (f3 == min)
                p5++;

        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(solution(n));
    }

}