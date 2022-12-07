//Longest Bitonic Subsequence
//        Easy  Prev   Next
//        1. You are given a number n, representing the number of elements.
//        2. You are given n numbers, representing the contents of array of length n.
//        3. You are required to print the length of longest bitonic subsequence of array.
//        Note -> bitonic subsequence begins with elements in increasing order, followed by elements in decreasing order.
//        Sample Input
//        10
//        10
//        22
//        9
//        33
//        21
//        50
//        41
//        60
//        80
//        1
//        Sample Output
//        7

import java.io.*;
import java.util.*;
class Scratch {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        //LIS Longest Increasing subsequence length

        int lis[] = new int[n];

        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if (lis[j] > max) {
                        max = lis[j];
                    }
                }
            }
            lis[i] = max + 1;
        }

        //LDS Longest Decreasing subsequence length

        int lds[] = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int max = 0;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i]) {
                    if (lds[j] > max) {
                        max = lds[j];
                    }
                }
            }
            lds[i] = max + 1;
        }


        //Finding LBS
        int omax = 0;

        for (int i = 0; i < n; i++) {
            if (lis[i] + lds[i] - 1 > omax) {
                omax = lis[i] + lds[i] - 1;
            }
        }

        System.out.println(omax);


    }
}