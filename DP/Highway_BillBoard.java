//Highway Billboard
//        Medium  Prev   Next
//        1. You are given a number M representing length of highway(range).
//        2. You are given a number N representing number of bill boards.
//        3. You are given N space separated numbers representing (P)position of bill-boards.
//        4. You are given N space separated numbers representing (R)revenue corresponding to each (P)position.
//        5. You are given a number T such that bill-boards can only be placed after specific distance(T).
//        6. Find the maximum revenue that can be generated.
//        Input Format
//        A number M(length of highway)
//        A number N(number of bill boards)
//        P1 ,P2 ,P3 ,P4 ,P5 .... Pn (placement of N bill-boards)
//        R1 ,R2 ,R3 ,R4 ,R5 .... Rn (revenue from each bill-board)
//        A number T (neccessary distance b/w two bill-board)
//        Output Format
//        Find the maximum revenue that can be generated.
//        Check the sample output and question video.
//        Constraints
//        1 <= M <= 100000
//        1 <= N <= 50000
//        1 <= Pi <= M
//        1 <= Ri <= 100
//        1 <= T
//        Sample Input
//        20
//        5
//        6 7 12 14 15
//        5 8 5 3 1
//        5
//        Sample Output
//        11

import java.util.Scanner;
import java.util.*;
 class Main {
    public static int solution(int m, int[] x, int[] rev, int t) {
        // write your code here
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < x.length; i++) {
            map.put(x[i], rev[i]);
        }

        int dp[] = new int[m + 1];
        dp[0] = 0;
        int max_rev = Integer.MIN_VALUE;
        for (int i = 1; i <= m; i++) {
            if (map.containsKey(i) == false) {
                dp[i] = dp[i - 1];
            } else {
                int bni = dp[i - 1];
                int bi = map.get(i) + 0 + (i - 1 - t > 0 ? dp[i - 1 - t] : 0);

                dp[i] = Math.max(bni, bi);
            }
            max_rev = Math.max(max_rev, dp[i]);
        }

        return max_rev;
    }
    public static void input(int []arr, Scanner scn) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
    }
    public static void main(String []args) {
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();

        int x[] = new int[n];
        input(x, scn);

        int revenue[] = new int[n];
        input(revenue, scn);

        int t = scn.nextInt();

        System.out.println(solution(m, x, revenue, t));
        scn.close();
    }
}