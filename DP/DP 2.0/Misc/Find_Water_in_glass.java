//Find Water In Glass
//        Medium  Prev   Next
//        1. Pepcoder arranged some glasses in the form of pascal triangle.
//        2. Capacity of each glass is 1 litre. If you pour K amount of water in a glass, it will retain 1 litre and
//        rest of it gets equally distributed in left bottom glass and right bottom glass.
//        3. If pepcoder pours K litres of water in the topmost glass, you have to find out the amount of water in Cth glass of Rth row.
//
//        Assumption -> There are enough glasses in the triangle till no glass overflows.
//
//        Constraints
//        1 <= K <= 500
//        1 <= R,C <= K
//
//        Sample Input
//        3
//        1
//        0
//
//        Sample Output
//        1.0

import java.io.*;
import java.util.*;

 class Main {

    public static double solution(int k, int r, int c) {
        // write your code here
        double dp[][] = new double[k + 1][k + 1];

        dp[0][0] = (double) k;

        for (int i = 0; i <= k; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j] > 1.0) {
                    double rem = dp[i][j] - 1.0;
                    dp[i][j] = 1.0;
                    dp[i + 1][j] += rem / 2.0;
                    dp[i + 1][j + 1] += rem / 2.0;
                }
            }
        }

        return dp[r][c];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int k = scn.nextInt();
        int r = scn.nextInt();
        int c = scn.nextInt();
        System.out.println(solution(k, r, c));
    }

}