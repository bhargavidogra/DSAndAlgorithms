//Kadane's Algorithm
//        Easy  Prev   Next
//        1. You are given an array(arr) of integers.
//        2. You have to find maximum subarray sum in the given array.
//        3. The subarray must have at least one element.
//
//        Sample Input
//        3
//        1
//        2
//        3
//        Sample Output
//        6
//
//        Sample Input
//        5
//        -3436
//        -46
//        -3456
//        -4637
//        -100
//        Sample Output
//        -46





import java.io.*;
import java.util.*;

 class Main {

    public static int solution(int[] arr) {
        // write your code here
        int max_sum = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum < 0) {
                sum = arr[i];
            } else {
                sum += arr[i];
            }

            if (max_sum < sum) {
                max_sum = sum;
            }
        }

        return max_sum;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }
}