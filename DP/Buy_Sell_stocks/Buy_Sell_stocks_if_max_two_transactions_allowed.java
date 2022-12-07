//Buy And Sell Stocks - Two Transactions Allowed
//        Easy  Prev   Next
//        1. You are given a number n, representing the number of days.
//        2. You are given n numbers, where ith number represents price of stock on ith day.
//        3. You are required to print the maximum profit you can make if you are allowed two transactions at-most.
//        Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).
//        Sample Input
//        9
//        11
//        6
//        7
//        19
//        4
//        1
//        6
//        18
//        4
//        Sample Output
//        30

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


        int lsf = arr[0];//initialize least so far with first array element
        int pist = 0; // profit if sold today
        int dpl[] = new int[n]; // max profit if sold uptill any point today or before today
        dpl[0] = 0; // first day max profit will be 0 as nothing can be sold
        for (int i = 1; i < n; i++) {
            if (arr[i] < lsf) {
                lsf = arr[i];
            }
            pist = arr[i] - lsf;
            if (pist > dpl[i - 1]) {
                dpl[i] = pist;
            } else {
                dpl[i] = dpl[i - 1];
            }
        }

        // maximum so far
        int msf = arr[n - 1];
        // profit earned if bought today and sold after today wehen price was maximum so far
        int pibt = 0;
        // max profit earned when bought today or anytime after today and sold when max price after that in future.
        int dpr[] = new int[n];
        //nothing can be gained after today as today is last day to buy or sell.if bought today will be sold at 0 profit same day
        dpr[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > msf) {
                msf = arr[i];
            }

            pibt = msf - arr[i];

            if (pibt > dpr[i + 1]) {
                dpr[i] = pibt;
            } else {
                dpr[i] = dpr[i + 1];
            }
        }

        //overall profit
        int of = 0;

        for (int i = 0; i < n; i++) {
            //sum of profits = max profit if sold uptill today + max profit if bought today or after today then sold at max price in future
            if (dpl[i] + dpr[i] > of) {
                of = dpl[i] + dpr[i];
            }
        }

        System.out.println(of);

    }
}