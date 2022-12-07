//Longest Consecutive Sequence Of Elements
//        1. You are given a number n, representing the size of array a.
//        2. You are given n numbers, representing elements of array a.
//        3. You are required to print the longest sequence of consecutive elements in the array (ignoring duplicates).
//
//        Note -> In case there are two sequences of equal length (and they are also the longest), then print the one for which the starting point of which occurs first in the array.
//
// Input:
//        17
//        12
//        5
//        1
//        2
//        10
//        2
//        13
//        7
//        11
//        8
//        9
//        11
//        8
//        9
//        5
//        6
//        11
//
// Output:
//        5
//        6
//        7
//        8
//        9
//        10
//        11
//        12
//        13

import java.io.*;
import java.util.*;

 class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n ; i++) {
            arr[i] = sc.nextInt();
        }

        HashMap<Integer, Boolean> hm = new HashMap<>();
        for (int val : arr) {
            hm.put(val, true);
        }

        //if previous element for the current element of array exists in hm it can not be the starting point.
        //therefore make it false
        for (int val : arr) {
            if (hm.containsKey(val - 1)) {
                hm.put(val, false);
            }
        }

        int msp = arr[0];
        int ml = 1;
        for (int val : arr) {
            if (hm.get(val) == true) {
                int curr_sp =  val;
                int curr_l = 1;
                while (hm.containsKey(curr_sp + curr_l)) {
                    curr_l++;
                }
                if (curr_l > ml) {
                    msp = curr_sp;
                    ml = curr_l;
                }
            }
        }

        for (int i = 0; i < ml; i++) {
            System.out.println(msp + i);
        }


    }

}