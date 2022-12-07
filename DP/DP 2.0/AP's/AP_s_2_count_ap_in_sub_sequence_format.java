//Arithmetic Slices 2 count ans sum the AP's in the given array with size greater than or equal to 3
//        Hard  Prev   Next
//        1. You are given an array(arr) of integers.
//        2. You have to find the count of arithmetic slices in the given array.
//        3. Arithmetic slice is defined as the sub-sequence of an array having all its elements in A.P and length of sub-sequence should be greater than or equal to 3.
//
//        Constraints
//        1 <= N <= 1000
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
        int ans = 0;
        int n = arr.length;

        HashMap<Integer, Integer> maps[] = new HashMap[n];

        for (int i = 0; i < n; i++) {
            maps[i] = new HashMap<Integer, Integer>();
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++ ) {
                long cd = (long) arr[i] - (long)arr[j];
                if (cd <= Integer.MIN_VALUE || cd >= Integer.MAX_VALUE) {
                    continue;
                }
                int apEndingonJ = maps[j].getOrDefault((int)cd, 0);
                int apEndingonI = maps[i].getOrDefault((int)cd, 0);
                ans += apEndingonJ;
                maps[i].put((int)cd, apEndingonJ + apEndingonI + 1);
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