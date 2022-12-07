//Super Ugly Number
//        Medium  Prev   Next
//        1. You are given an array(arr) of size k which contains prime numbers in ascending order, and an integer N.
//        2. You have to find Nth super ugly number.
//        3. Super ugly number is defined as the number whose prime factors are elements of the given array.
//
//        Assumption -> 1 is the first super ugly number.
//
//        Constraints
//        1 <= K <= 100
//        1 <= arr[i] <= 1000
//        1 <= N <= 10^6
//        Sample Input
//        4
//        3 5 7 11
//        13
//        Sample Output
//        45


import java.io.*;
import java.util.*;

 class Main {

    public static class Pair implements Comparable<Pair> {
        int prime;
        int pointer;
        int value;
        public Pair(int prime, int pointer, int value) {
            this.prime = prime;
            this.pointer = pointer;
            this.value = value;
        }

        public int compareTo(Pair o) {
            return this.value - o.value;
        }
    }

    public static int solution2(int[] primes, int n) {
        int dp[] = new int[n + 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < primes.length; i++) {
            pq.add(new Pair(primes[i], 1, primes[i]));
        }
        dp[1] = 1;

        for (int i = 2; i <= n;) {
            Pair rp = pq.remove();
            if (dp[i - 1] != rp.value) {
                dp[i] = rp.value;
                i++;
            }

            pq.add(new Pair(rp.prime, rp.pointer + 1, rp.prime * dp[rp.pointer + 1]));
        }
        return dp[n];
    }

    public static int solution(int[] primes, int n) {
        // write your code here
        int pointers[] = new int[primes.length + 1];
        Arrays.fill(pointers, 1);
        int dp[] = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                min = Math.min(min, primes[j] * dp[pointers[j]]);
            }
            dp[i] = min;
            for (int j = 0; j < primes.length; j++) {
                if (primes[j]*dp[pointers[j]] == min) {
                    pointers[j]++;
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int k = scn.nextInt();
        int[] primes = new int[k];
        for (int i = 0 ; i < k; i++) {
            primes[i] = scn.nextInt();
        }
        int n = scn.nextInt();
        System.out.println(solution2(primes, n));
    }

}