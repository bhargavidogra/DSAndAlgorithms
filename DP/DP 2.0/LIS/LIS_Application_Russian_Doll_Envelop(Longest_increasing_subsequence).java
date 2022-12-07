//Russian Doll Envelopes
//        Hard  Prev   Next
//        1. You are given a number n, representing the number of envelopes.
//        2. You are given n pair of numbers, representing the width and height of each envelope.
//        3. You are required to print the count of maximum number of envelopes that can be nested inside each other.
//        Note -> Rotation is not allowed.
//
//        Sample Input
//        11
//        17 5
//        26 18
//        25 34
//        48 84
//        63 72
//        42 86
//        9 55
//        4 70
//        21 45
//        68 76
//        58 51
//        Sample Output
//        5


import java.io.*;
import java.util.*;

 class Main {

    public static class Envelop implements Comparable<Envelop> {
        int w;
        int h;
        Envelop(int w, int h) {
            this.w = w;
            this.h = h;
        }

        public int compareTo(Envelop o) {
            if (this.w != o.w) {
                return this.w - o.w;
            } else {
                return this.h - o.h;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Envelop envelops[] = new Envelop[n];
        for (int i = 0; i < n; i++) {
            int w = sc.nextInt();
            int h = sc.nextInt();
            envelops[i] = new Envelop(w, h);
        }

        Arrays.sort(envelops);

        int omax = Integer.MIN_VALUE;
        int dp[] = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (envelops[j].h < envelops[i].h) {
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