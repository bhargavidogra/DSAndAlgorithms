//Print All Paths With Maximum Gold
//        Medium  Prev   Next
//        1. You are given a number n, representing the number of rows.
//        2. You are given a number m, representing the number of columns.
//        3. You are given n*m numbers, representing elements of 2d array a, which represents a gold mine.
//        4. You are standing in front of left wall and are supposed to dig to the right wall. You can start from any row in the left wall.
//        5. You are allowed to move 1 cell right-up (d1), 1 cell right (d2) or 1 cell right-down(d3).
//        6. Each cell has a value that is the amount of gold available in the cell.
//        7. You are required to identify the maximum amount of gold that can be dug out from the mine.
//        8. Also, you have to print all paths with maximum gold.
//        Constraints
//        1 <= n <= 10^2
//        1 <= m <= 10^2
//        0 <= e1, e2, .. n * m elements <= 1000
//        Sample Input
//        6
//        6
//        0 1 4 2 8 2
//        4 3 6 5 0 4
//        1 2 4 1 4 6
//        2 0 7 3 2 2
//        3 1 5 9 2 4
//        2 7 0 8 5 1
//        Sample Output
//        33
//        4 d3 d1 d2 d3 d1


import java.util.*;


public class Main {

    private static class Pair {
        String psf;
        int i;
        int j;

        public Pair(String psf, int i, int j) {
            this.psf = psf;
            this.i = i;
            this.j = j;
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        scn.close();

        int[][] dp = new int[arr.length][arr[0].length];

        for (int j = arr[0].length - 1; j >= 0; j--) {
            for (int i = 0; i < arr.length; i++) {
                if (j == arr[0].length - 1) {
                    dp[i][j] = arr[i][j];
                } else if (i == 0) {
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
                } else if (i == arr.length - 1) {
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
                } else {
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], Math.max(dp[i - 1][j + 1], dp[i + 1][j + 1]));
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i][0] > max) {
                max = dp[i][0];
            }
        }

        System.out.println(max);

        ArrayDeque< Pair> que = new ArrayDeque< >();

        for (int i = 0; i < dp.length; i++) {
            if (dp[i][0] == max) {
                que.add(new Pair(i + " ", i, 0));
            }
        }

        while (que.size() > 0) {
            Pair rem = que.removeFirst();

            if (rem.j == arr[0].length - 1) {
                System.out.println(rem.psf);
            } else if (rem.i == 0) {
                int g = Math.max(dp[rem.i][rem.j + 1], dp[rem.i + 1][rem.j + 1]);


                if (g == dp[rem.i][rem.j + 1]) {
                    que.add(new Pair(rem.psf + "d2 ", rem.i, rem.j + 1));
                }

                if (g == dp[rem.i + 1][rem.j + 1]) {
                    que.add(new Pair(rem.psf + "d3 ", rem.i + 1, rem.j + 1));
                }
            } else if (rem.i == arr.length - 1) {
                int g = Math.max(dp[rem.i][rem.j + 1], dp[rem.i - 1][rem.j + 1]);


                if (g == dp[rem.i - 1][rem.j + 1]) {
                    que.add(new Pair(rem.psf + "d1 ", rem.i - 1, rem.j + 1));
                }

                if (g == dp[rem.i][rem.j + 1]) {
                    que.add(new Pair(rem.psf + "d2 ", rem.i, rem.j + 1));
                }
            } else {
                int g = Math.max(dp[rem.i][rem.j + 1], Math.max(dp[rem.i - 1][rem.j + 1], dp[rem.i + 1][rem.j + 1]));

                if (g == dp[rem.i - 1][rem.j + 1]) {
                    que.add(new Pair(rem.psf + "d1 ", rem.i - 1, rem.j + 1));
                }

                if (g == dp[rem.i][rem.j + 1]) {
                    que.add(new Pair(rem.psf + "d2 ", rem.i, rem.j + 1));
                }

                if (g == dp[rem.i + 1][rem.j + 1]) {
                    que.add(new Pair(rem.psf + "d3 ", rem.i + 1, rem.j + 1));
                }
            }


        }
    }

}