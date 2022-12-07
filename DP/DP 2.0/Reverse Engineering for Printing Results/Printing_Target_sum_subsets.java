//Print All Paths With Target Sum Subset
//        Medium  Prev   Next
//        1. You are given a number n, representing the count of elements.
//        2. You are given n numbers.
//        3. You are given a number "tar".
//        4. You are required to calculate and print true or false, if there is a subset the elements of which add up to "tar" or not.
//        5. Also, you have to print the indices of elements that should be selected to achieve the given target.
//        6. You have to print all such configurations.
//
//        Constraints
//        1 <= n <= 30
//        0 <= n1, n2, .. n elements <= 20
//        0 <= tar <= 50
//
//        Sample Input
//        5
//        4
//        2
//        7
//        1
//        3
//        10
//
//        Sample Output
//        true
//        2 4
//        1 2 3
//        0 1 3 4

import java.io.*;
import java.util.*;

 class Main {

    public static class Pair {
        int i;
        int j;
        String psf;

        public Pair(int i, int j, String psf) {
            this.i = i;
            this.j = j;
            this.psf = psf;
        }
    }

    public static void  printTargetSumSubset(int arr[], int tar) {
        int n = arr.length;

        //DP for target sum subset

        boolean dp[][] = new boolean[n + 1][tar + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < tar + 1; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    dp[i][j] = true;
                } else {
                    if (j >= arr[i - 1]) {
                        if (dp[i - 1][j] || dp[i - 1][j - arr[i - 1]]) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = false;
                        }
                    } else {
                        if (dp[i - 1][j]) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = false;
                        }
                    }
                }
            }
        }
        System.out.println(dp[n][tar]);

        //BFS
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(n, tar, ""));
        while (q.size() > 0) {
            Pair rp = q.remove();
            if (rp.i == 0 || rp.j == 0) {
                System.out.println(rp.psf);
            } else {
                boolean exc = dp[rp.i - 1][rp.j];
                boolean inc = rp.j - arr[rp.i - 1] >= 0 ? dp[rp.i - 1][rp.j - arr[rp.i - 1]] : false;

                if (inc == true) {
                    q.add(new Pair(rp.i - 1, rp.j - arr[rp.i - 1], (rp.i - 1) + " " + rp.psf ));
                }
                if (exc == true) {
                    q.add(new Pair(rp.i - 1, rp.j, rp.psf));
                }
            }
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int tar = Integer.parseInt(br.readLine());

        //write your code here
        printTargetSumSubset(arr, tar);
    }
}
