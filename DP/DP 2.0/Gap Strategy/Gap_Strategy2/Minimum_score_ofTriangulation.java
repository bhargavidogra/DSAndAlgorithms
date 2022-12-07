//Minimum Score Of Triangulation
//        Medium  Prev   Next
//        1. You are given an array of integers, which represents the vertices of an N-sided convex polygon in clockwise order.
//        2. You have to triangulate the given polygon into N-2 triangles.
//        3. The value of a triangle is the product of the labels of vertices of that triangle.
//        4. The total score of the triangulation is the sum of the value of all the triangles.
//        5. You have to find the minimum score of the triangulation of the given polygon.
//        Sample Input
//        3
//        1
//        2
//        3
//        Sample Output
//        6
//
//uses - gap Strategy, catalan number. how to triangulate property.

import java.io.*;
import java.util.*;
class Scratch {
    public static int minScoreTriangulation(int[] arr) {
        //write your code here
        int n = arr.length;
        int dp[][]  = new int[n][n];

        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g ; j < n; i++, j++) {
                if (g == 0) {
                    dp[i][j] = 0;
                } else if (g == 1) {
                    dp[i][j] = 0;
                } else if (g == 2) {
                    dp[i][j] = arr[i] * arr[i + 1] * arr[i + 2];
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int k = i + 1; k <= j - 1; k++) {
                        int v1 = arr[i] * arr[j] * arr[k];
                        int v2 = dp[i][k];
                        int v3 = dp[k][j];

                        int total = v1 + v2 + v3;
                        //    System.out.println(total);
                        if (total <= min) {
                            min = total;
                        }
                    }
                    dp[i][j] = min;
                }
            }
        }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(" "+dp[i][j]);
        //     }
        //     System.out.println();
        // }


        return dp[0][n - 1];
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0 ; i  < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(minScoreTriangulation(arr));
    }
}