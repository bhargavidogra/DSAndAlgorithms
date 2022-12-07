//Partition Into Subsets
//        Easy  Prev   Next
//        1. You are given a number n, representing the number of elements.
//        2. You are given a number k, representing the number of subsets.
//        3. You are required to print the number of ways in which these elements can be partitioned in k non-empty subsets.
//        E.g.
//        For n = 4 and k = 3 total ways is 6
//        12-3-4
//        1-23-4
//        13-2-4
//        14-2-3
//        1-24-3
//        1-2-34
//        Input Format
//        A number n
//        A number k
//        Output Format
//        A number representing the number of ways in which these elements can be partitioned in k non-empty subsets.
//
//
//        Sample Input
//        4
//        3
//        Sample Output
//        6



import java.io.*;
import java.util.*;

 class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();

        long res = partitionKSubset(n, k);
        System.out.println(res);
    }

    public static long partitionKSubset(int n, int k){

        long dp[][] = new long[k+1][n+1];

        for(int teams=0;teams<k+1;teams++){
            for(int p=0;p<n+1;p++){
                if(teams==0){
                    dp[teams][p]=0;
                }else if(p==0){
                    dp[teams][p]=0;
                }else if(teams==1){
                    dp[teams][p]=1;
                }else if(teams==p){
                    dp[teams][p]=1;
                }
                else if(p<teams){
                    dp[teams][p]=0;
                }else {
                    dp[teams][p]= dp[teams-1][p-1]+ teams*dp[teams][p-1];
                }
            }
        }
        return dp[k][n];
    }
}