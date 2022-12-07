//Buy And Sell Stocks - One Transaction Allowed
//        Easy  Pr
//        1. You are given a number n, representing the number of days.
//        2. You are given n numbers, where ith number represents price of stock on ith day.
//        3. You are required to print the maximum profit you can make if you are allowed a single transaction.
//
//
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
//        17


import java.io.*;
import java.util.*;
class Scratch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int prices[] = new int[n];
        for(int i=0;i<n;i++){
            prices[i]= sc.nextInt();
        }

        int max_profit=0;
        int lsf= Integer.MAX_VALUE;
        int pist=0;
        for(int i=0;i<n;i++){
            if(prices[i]<lsf){
                lsf= prices[i];
            }
            pist = prices[i]-lsf;
            if(pist>max_profit){
                max_profit = pist;
            }

        }
        System.out.println(max_profit);
    }
}