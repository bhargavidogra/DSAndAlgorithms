//Arithmetic Slices 1 - count the AP's int the given array
//        Medium  Prev   Next
//        1. You are given an array(arr) of integers.
//        2. You have to find the count of arithmetic slices in the given array.
//        3. Arithmetic slice is defined as the sub-array having all its elements in A.P and the length of sub-array should be greater than or equal to 3.
//
//        Constraints
//        1 <= N <= 10^8
//        -10^8 <= arr[i] <= 10^8
//        Sample Input
//        4
//        1
//        2
//        3
//        4
//        Sample Output
//        3

import java.io.*;
import java.util.*;

 class Main {

    public static int solution(int[] arr) {
        //write your code here
        int ans=0;
        int n= arr.length;

        int dp[]= new int[n];
        for(int i=2;i<n;i++){
            if(arr[i]-arr[i-1]==arr[i-1]-arr[i-2]){
                dp[i]=dp[i-1]+1;
                ans+=dp[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0 ; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }

}