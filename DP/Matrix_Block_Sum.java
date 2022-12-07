//1314. Matrix Block Sum
//        Medium
//
//        1990
//
//        310
//
//        Add to List
//
//        Share
//        Given a m x n matrix mat and an integer k, return a matrix answer where each answer[i][j] is the sum of all elements mat[r][c] for:
//
//        i - k <= r <= i + k,
//        j - k <= c <= j + k, and
//        (r, c) is a valid position in the matrix.
//
//
//        Example 1:
//
//        Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
//        Output: [[12,21,16],[27,45,33],[24,39,28]]
//        Example 2:
//
//        Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 2
//        Output: [[45,45,45],[45,45,45],[45,45,45]]
//
//
//        Constraints:
//
//        m == mat.length
//        n == mat[i].length
//        1 <= m, n, k <= 100
//        1 <= mat[i][j] <= 100

import java.io.*;
import java.util.*;

public class Main {

    public int[][] matrixBlockSum(int[][] mat, int k) {

        int n = mat.length;
        int m = mat[0].length;
        int preSum[][] = new int [n][m];

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    //continue;
                    preSum[i][j] = mat[i][j];
                }
                else if (i == 0) {
                    preSum[i][j] +=  mat[i][j] + preSum[i][j - 1];
                } else if (j == 0) {
                    preSum[i][j] +=  mat[i][j] + preSum[i - 1][j];
                } else {
                    preSum[i][j] += mat[i][j] + preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1];
                }
            }
        }
        int a, b, c, d;

        int ans[][] = new int [n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a = Math.max(i - k, 0);
                b = Math.max(0, j - k);
                c = Math.min(i + k, n - 1);
                d = Math.min(j + k, m - 1);
                if (a == 0 && b == 0) {
                    ans[i][j] = preSum[c][d];
                } else if (a == 0) {
                    ans[i][j] = preSum[c][d] - preSum[c][b - 1];
                } else if (b == 0) {
                    ans[i][j] = preSum[c][d] - preSum[a - 1][d];
                } else {
                    ans[i][j] = preSum[c][d] + preSum[a - 1][b - 1] - preSum[a - 1][d] - preSum[c][b - 1];
                }
            }
        }
        return ans;
    }

    public int[][] matrixBlockSum1(int[][] mat, int k) {

        int n = mat.length;
        int m = mat[0].length;
        int ans[][] = new int [n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = getResult(mat, k, i, j);
            }
        }
        return ans;
    }

    public static int getResult(int[][]mat, int k, int ii, int jj) {
        int n = mat.length;
        int m = mat[0].length;
        int sum = 0;
        for (int i = ii - k; i <= ii + k; i++) {
            if (i >= 0 && i < mat.length) {
                for (int j = jj - k; j <= jj + k; j++) {
                    if (j >= 0 && j < mat[0].length) {
                        sum += mat[i][j];
                    }
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt()
        int arr[][]= new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]= scn.nextInt();
            }
        }
        int k = scn.nextInt();
        int res1[][] = matrixBlockSum1(arr,k);
        System.out.println(res1);
        int res2[][] = matrixBlockSum(arr,k);
        System.out.println(res);


    }

}