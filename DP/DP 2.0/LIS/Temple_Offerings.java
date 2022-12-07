//Temple Offerings
//        Medium  Prev   Next
//        1. Pepcoder is wishing to give offerings to all the temples along a mountain range.
//        2. The temples are located in a row at different heights.
//        3. You have to find the minimum number of offerings such that these conditions are fulfilled -
//        -> If two adjacent temples are at different heights, then the temple which is situated at greater height should receive more offerings.
//        -> If two adjacent temples are at the same height, then their offerings relative to each other does not matter.
//Sample Input
//        6
//        1 3 2 5 2 1
//        Sample Output
//        10


import java.io.*;
import java.util.*;
class Scratch {
    public static int totaloffering(int[] height) {
        // write your code her
        int n = height.length;
        int dpl[] = new int[n];
        int dpr[] = new int[n];
        dpl[0] = 1;
        dpr[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            if (height[i] > height[i - 1]) {
                dpl[i] = dpl[i - 1] + 1;
            } else {
                dpl[i] = 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (height[i] > height[i + 1]) {
                dpr[i] = dpr[i + 1] + 1;
            } else {
                dpr[i] = 1;
            }
        }
        int sum = 0;
        for (int j = 0; j < n; j++) {
            sum += Math.max(dpl[j], dpr[j]);
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int height[] = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = scn.nextInt();
        }
        System.out.println(totaloffering(height));
    }
}