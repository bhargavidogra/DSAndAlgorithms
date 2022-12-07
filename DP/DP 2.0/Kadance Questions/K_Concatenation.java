//K Concatenation
//        Medium  Prev   Next
//        1. You are given an array(arr1) of integers and an integer k.
//        2. Another array(arr2) is formed by concatenating K copies of arr1.
//        For example, if arr1 = {1,2} and k = 3, then arr2 = {1,2,1,2,1,2}.
//        3. You have to find the maximum subarray sum in arr2.
//        Constraints
//        1 <= N <= 10^5
//        1 <= K <= 10^5
//        -10^6 <= arr1[i] <= 10^6
//        Sample Input
//        3
//        1
//        2
//        3
//        3
//        Sample Output
//        18

import java.io.*;
import java.util.*;

 class Main {

    public static long kadance(int arr[]) {
        int csum = arr[0];
        int msum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (csum >= 0) {
                csum += arr[i];
            } else {
                csum = arr[i];
            }
            if (csum > msum) {
                msum = csum;
            }
        }
        return msum;
    }

    public static long kadanceOfTwo(int arr[]) {
        int n = arr.length;
        int narr[] = new int[n * 2];
        for (int i = 0; i < n; i++) {
            narr[i] = arr[i];
        }
        for (int i = 0; i < n; i++) {
            narr[n + i] = arr[i];
        }

        return kadance(narr);

    }
    public static long solution(int[] arr, int k, long sum) {
        // write your code here

        if (k == 1) {
            return kadance(arr);
        } else if (sum < 0) {
            return kadanceOfTwo(arr);
        } else {
            return (k - 2) * sum + kadanceOfTwo(arr);
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
            sum += arr[i];
        }
        int k = scn.nextInt();
        System.out.println(solution(arr, k, sum));
    }

}