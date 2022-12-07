//Buy And Sell Stocks With Transaction Fee - Infinite Transactions Allowed
//        Medium  Prev   Next
//        1. You are given a number n, representing the number of days.
//        2. You are given n numbers, where ith number represents price of stock on ith day.
//        3. You are give a number fee, representing the transaction fee for every transaction.
//        4. You are required to print the maximum profit you can make if you are allowed infinite transactions, but has to pay "fee" for every closed transaction.
//        Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).
//        Sample Input
//        12
//        10
//        15
//        17
//        20
//        16
//        18
//        22
//        20
//        22
//        20
//        23
//        25
//        3
//        Sample Output
//        13

import java.io.*;
import java.util.*;
class Scratch {
    public static void main(String[] args) throws Exception {
        // write your code here


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int prices[] = new int[n];
        for(int i=0;i<n;i++){
            prices[i]= sc.nextInt();
        }

        int fee= sc.nextInt();

        int obsp=prices[0];
        int ossp=0;

        for(int i=1;i<n;i++){
            int nbsp=0,nssp=0;

            nbsp = Math.min(obsp, prices[i]-ossp);
            nssp = Math.max(ossp, prices[i]-obsp-fee);

            obsp = nbsp;
            ossp = nssp;
        }

        System.out.println(ossp);

    }
}