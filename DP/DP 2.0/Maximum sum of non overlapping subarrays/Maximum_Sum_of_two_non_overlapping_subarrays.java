//Maximum Sum Of Two Non-overlapping Subarrays
//        Medium  Prev   Next
//        1. You are given an array(arr) of positive numbers and two numbers X and Y.
//        2. You have to find the maximum sum of elements in two non-overlapping subarrays.
//        3. One subarray must of length X and the other must be of length Y.
//
//        Sample Input
//        9
//        0 6 5 2 2 5 1 9 4
//        1
//        2
//        Sample Output
//        20


import java.io.*;
import java.util.*;

public class Main {

    public static int solution(int[] arr, int x, int y) {
        // write your code here

        int n = arr.length;
        int dp1[] = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (i < x) {
                sum += arr[i];
                dp1[i] = sum;
            } else {
                sum = sum + arr[i] - arr[i - x];
                dp1[i] = Math.max(dp1[i - 1], sum);
            }
        }


        sum = 0;
        int dp2[] = new int[n];
        for (int i = n-1; i >= 0; i--) {
            if (i + y >= n) {
                sum += arr[i];
                dp2[i] = sum;
            } else {
                sum = sum + arr[i] - arr[i + y];
                dp2[i] = Math.max(dp2[i + 1], sum);
            }
        }
        int ans = 0;
        for (int i = x - 1; i < n - y; i++) {
            ans = Math.max(ans, dp1[i] + dp2[i + 1]);
        }


        int dp11[] = new int[n];
        sum = 0;
        for (int i = 0; i < n; i++) {
            if (i < y) {
                sum += arr[i];
                dp11[i] = sum;
            } else {
                sum = sum + arr[i] - arr[i - y];
                dp11[i] = Math.max(dp11[i - 1], sum);
            }
        }


        sum = 0;
        int dp22[] = new int[n];
        for (int i = n-1; i >= 0; i--) {
            if (i + x >= n) {
                sum += arr[i];
                dp22[i] = sum;
            } else {
                sum = sum + arr[i] - arr[i + x];
                dp22[i] = Math.max(dp22[i + 1], sum);
            }
        }

        for (int i = y - 1; i < n - x; i++) {
            ans = Math.max(ans, dp11[i] + dp22[i + 1]);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0 ; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int x = scn.nextInt();
        int y = scn.nextInt();
        System.out.println(solution(arr, x, y));
    }

}