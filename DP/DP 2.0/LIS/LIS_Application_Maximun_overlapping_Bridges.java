//Maximum Non-overlapping Bridges
//        Easy  Prev   Next
//        1. You are given a number n, representing the number of bridges on a river.
//        2. You are given n pair of numbers, representing the north bank and south bank co-ordinates of each bridge.
//        3. You are required to print the count of maximum number of non-overlapping bridges.
//
//        Sample Input
//        10
//        10 20
//        2 7
//        8 15
//        17 3
//        21 40
//        50 4
//        41 57
//        60 80
//        80 90
//        1 30
//        Sample Output
//        7

import java.io.*;
import java.util.*;

 class Main {

    public static class Bridge implements Comparable<Bridge> {
        int n;
        int s;
        Bridge(int n, int s) {
            this.n = n;
            this.s = s;
        }

        public int compareTo(Bridge o) {
            if (this.n != o.n) {
                return this.n - o.n;
            } else {
                return this.s - o.n;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Bridge bridges[] = new Bridge[n];
        for (int i = 0; i < n; i++) {
            int north = sc.nextInt();
            int south = sc.nextInt();
            bridges[i] = new Bridge(north, south);
        }

        Arrays.sort(bridges);

        int omax = Integer.MIN_VALUE;
        int dp[] = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (bridges[j].s < bridges[i].s) {
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