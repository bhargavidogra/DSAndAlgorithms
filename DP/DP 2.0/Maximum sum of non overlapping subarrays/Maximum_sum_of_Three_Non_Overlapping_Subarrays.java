//Maximum Sum Of Three Non-overlapping Subarrays
//        Hard  Prev   Next
//        1. You are given an array(arr) of positive numbers and a number K.
//        2. You have to find the maximum sum of elements in three non-overlapping subarrays.
//        3. Also, you have to print indices representing the starting position of every subarray.
//        4. If there are multiple answers, print the lexicographically smallest one.
//        Sample Input
//        8
//        1 2 1 2 6 7 5 1
//        2
//        Sample Output
//        23 0 3 5


import java.io.*;
import java.util.*;

 class Main {

    public static void solution(int[] arr, int k) {
        // write your code here


        int n = arr.length;
        //max sum subarray of size k from left
        int dp1[] = new int[n];
        //max sum subarray of size k from left
        int dp2[] = new int[n];

        int prefix_sum[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                prefix_sum[i] = arr[i];
            } else {
                prefix_sum[i] = prefix_sum[i - 1] + arr[i];
            }
        }

        int sum = 0;
        //fill left array
        for (int i = 0; i < n; i++) {
            if (i < k) {
                sum += arr[i];
                dp1[i] = sum;
            } else {
                sum = sum + arr[i] - arr[i - k];
                dp1[i] = Math.max(dp1[i - 1], sum);
            }
        }

        sum = 0;
        //fill right array
        for (int i = n - 1; i >= 0; i--) {
            if (i + k >= n) {
                sum += arr[i];
                dp2[i] = sum;
            } else {
                sum = sum + arr[i] - arr[i + k];
                dp2[i] = Math.max(dp2[i + 1], sum);
            }
        }
        int max_sum = 0;
        int lsum = 0;
        int spma = -1;
        int rsum = 0;

        //n- 2*k because left array of size k then right array of size k
        // therefore starting points for middle array of size k shall rage between k to n-2*k
        for (int i = k; i < n - 2 * k; i++) {
            // if sum of left + right + middle array > max then update max answer left array point, right array, point and middle array point.
            if ((dp1[i - 1] + dp2[i + k] + prefix_sum[i + k - 1] - prefix_sum[i - 1] ) > max_sum) {
                max_sum = dp1[i - 1] + dp2[i + k] + prefix_sum[i + k - 1] - prefix_sum[i - 1];
                lsum = dp1[i - 1];// starting point left array
                rsum = dp2[i + k];// starting point right array
                spma = i;// starting point middle array
            }
        }
        //printing max_sum
        System.out.print(max_sum + " ");

        //printing left array starting point
        for (int i = k - 1; i < spma; i++) {
            if ((prefix_sum[i] - (i - k < 0 ? 0 : prefix_sum[i - k])) == lsum) {
                System.out.print((i - k + 1) + " ");
                break;
            }
        }
        //printing middle array starting point
        System.out.print(spma + " ");
        //printing right array starting point
        for (int i = spma + 2 * k - 1 ; i < n; i++) {
            if (prefix_sum[i] - (prefix_sum[i - k]) == rsum) {
                System.out.print((i - k + 1) + " ");
                break;
            }
        }


    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0 ; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        solution(arr, k);
    }

}