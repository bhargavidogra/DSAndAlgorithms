//  Paint House - Many Colors
//        1. You are given a number n and a number k separated by a space, representing the number of houses and number of colors.
//        2. In the next n rows, you are given k space separated numbers representing the cost of painting nth house with one of the k colors.
//        3. You are required to calculate and print the minimum cost of painting all houses without painting any consecutive house with same color.
//
//  Sample Input:
//                4 3
//                1 5 7
//                5 8 4
//                3 2 9
//                1 2 4
//
//  Sample Output:
//
//                8


import java.io.*;
import java.util.*;

 class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int k = sc.nextInt();
        int arr[][]= new int[n][k];
        for(int i=0;i<n;i++){
            for(int j=0;j<k;j++){
                arr[i][j]= sc.nextInt();
            }
        }

        int dp[][]= new int[n][k];
        int least=Integer.MAX_VALUE;
        int sleast=Integer.MAX_VALUE;
        for(int j=0;j<k;j++){
            dp[0][j]= arr[0][j];
            if(dp[0][j]<=least){
                sleast = least;
                least = dp[0][j];
            }else if(dp[0][j]>least && dp[0][j]<=sleast){
                sleast = dp[0][j];
            }
        }

        for(int i=1;i<n;i++){
            int nleast=Integer.MAX_VALUE;
            int nsleast=Integer.MAX_VALUE;
            for(int j=0;j<k;j++){
                if(dp[i-1][j]==least){
                    dp[i][j]= arr[i][j]+sleast;
                }else {
                    dp[i][j]= arr[i][j]+least;
                }

                if(dp[i][j]<=nleast){
                    nsleast = nleast;
                    nleast = dp[i][j];
                }else if(dp[i][j]>nleast && dp[i][j]<=nsleast){
                    nsleast = dp[i][j];
                }
            }
            least = nleast;
            sleast = nsleast;
        }

        // for(int i=1;i<n;i++){
        //     for(int j=0;j<k;j++){
        //         int min = Integer.MAX_VALUE;
        //         for(int l=0;l<k;l++){
        //             if(l!=j && dp[i-1][l]<min){
        //                 min= dp[i-1][l];
        //             }
        //         }
        //         dp[i][j]= arr[i][j]+min;
        //     }
        // }

        // int min = Integer.MAX_VALUE;
        //         for(int l=0;l<k;l++){
        //             if(dp[n-1][l]<min){
        //                 min= dp[n-1][l];
        //             }
        //         }



        System.out.println(least);
    }
}