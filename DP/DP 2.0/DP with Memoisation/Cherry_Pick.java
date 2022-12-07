//Cherry Pickup
//        Hard  Prev   Next
//        1. You are given a number N, which represents the rows and columns of a 2-D matrix.
//        2. Matrix contains only three values -
//        a. Cell is empty.
//        b. Cell contains a cherry.
//        c. Cell contains a thorn and you can not pass through this cell.
//        3. You have to find the maximum number of cherries that you can collect following these rules :
//        a. You have to start from (0,0) and travel till (N-1,N-1) by moving right or down,
//        one step at a time.
//        b. After reaching (N-1,N-1), you have to come back to (0,0) by moving left or up,
//        one step at a time.
//
//        Note -> If there is no valid path between the top-left cell and bottom-right cell, then no cherries can be collected.
//
//        Constraints
//        1 <= N <= 50
//        Cells can have only three values 0,1 and -1.
//        Sample Input
//        3
//        0
//        1
//        -1
//        1
//        0
//        -1
//        1
//        1
//        1
//        Sample Output
//        5

import java.io.*;
import java.util.*;

 class Main {

    public static int Solution(int r1, int c1, int r2, int c2, int[][] arr, int[][][][] dp) {
        //write your code here
        if ( r1 >= arr.length || r2 >= arr.length || c1 >= arr[0].length || c2 >= arr[0].length || arr[r1][c1] == -1 || arr[r2][c2] == -1 ) {
            return Integer.MIN_VALUE;
        }

        //If Person1 reaches the end spot similarly Person2 will also whould have reached  so we return the last cell value
        if ( r1 == arr.length - 1 && c1 == arr[0].length - 1 ) {
            return arr[r1][c1];
        }

        if (dp[r1][c1][r2][c2] != 0) {
            return dp[r1][c1][r2][c2];
        }

        int cherries = 0;

        //If Person1 reaches the same spot as the Person2, the cherry in the cell will only  be picked up once, otherwise we add both cells cherries
        if (r1 == r2 && c1 == c2) {
            cherries += arr[r1][c1];
        } else {
            cherries += arr[r1][c1] + arr[r2][c2];
        }

        int f1 = Solution(r1, c1 + 1, r2, c2 + 1, arr, dp); //hh
        int f2 = Solution(r1, c1 + 1, r2 + 1, c2, arr, dp); //hv
        int f3 = Solution(r1 + 1, c1, r2 + 1, c2, arr, dp); //vv
        int f4 = Solution(r1 + 1, c1, r2, c2 + 1, arr, dp); //vh

        int res = cherries + Math.max(Math.max(f1, f2), Math.max(f3, f4));

        dp[r1][c1][r2][c2] = res;

        return res;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0 ; j < n; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        int ans = Math.max(0, Solution(0, 0, 0, 0, arr, new int[n][n][n][n]));
        System.out.println(ans);
    }

}