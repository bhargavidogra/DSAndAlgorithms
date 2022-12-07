//Print All Longest Increasing Subsequences
//        Easy  Prev   Next
//        1. You are given a number N representing number of elements.
//        2. You are given N space separated numbers (ELE : elements).
//        3. Your task is to find & print
//        3.1) Length of "Longest Increasing Subsequence"(LIS).
//        3.2) All "Longest Increasing Subsequence(s)"(LIS).
//        NOTE: Checkout sample question/solution video inorder to have more insight.
//        Sample Input
//        10
//        10 22 9 33 21 50 41 60 80 1
//        Sample Output
//        6
//        10 -> 22 -> 33 -> 41 -> 60 -> 80
//        10 -> 22 -> 33 -> 50 -> 60 -> 80


import java.io.*;
import java.util.*;
class Scratch {
    public static class Pair {
        int l;
        int i;
        int v;
        String psf;

        Pair(int l, int i, int v, String psf) {
            this.l = l;
            this.i = i;
            this.v = v;
            this.psf = psf;
        }
    }

    public static void solution(int []arr) {
// write your code here
        int n = arr.length;
        int omax = 0;
        int dp[] = new int[n];

        //LIS code
        for (int i = 0; i < n ; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if (dp[j] >= max) {
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

     //BFS done inorder to get the result . reverse tree formed.
        ArrayDeque<Pair> queue = new ArrayDeque<Pair>();
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == omax) {
                //add to the queue pairs with max longest increasing subsequence value(omax) in dp array,
                // its index, corresponding value in array and Path so far(psf)
                queue.add(new Pair(dp[i], i, arr[i], arr[i] + ""));
            }
        }

        while (queue.size() > 0) {
            Pair rem = queue.remove();
            if (rem.l == 1) {
                System.out.println(rem.psf);
            }
            for (int j = rem.i-1; j >= 0; j--) {
                //If removed pair length minus 1 == dp's previous indexes and
                // value of that index in array is less than or equal to removed pair value
                if ((dp[j] == rem.l - 1) && (arr[j] <= rem.v)) {
                    queue.add(new Pair(dp[j], j, arr[j], arr[j] + " -> " + rem.psf));
                }
            }
        }
    }



    public static void main(String []args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int arr[] = new int[n];
        for (int i = 0 ; i < n ; i++) {
            arr[i] = scn.nextInt();
        }

        solution(arr);

        scn.close();
    }
}