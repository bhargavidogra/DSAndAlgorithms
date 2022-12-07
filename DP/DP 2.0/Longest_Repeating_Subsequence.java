//Longest Repeating Subsequence
//        Medium  Prev   Next
//        1. You are given a string str.
//        2. You have to find the length of longest subsequence which is appearing twice in the string.
//        3. Every ith character in both the subsequences must have different indices in the original string.
//
//
//        Constraints
//        1 < length of strings str <= 2000
//        Sample Input
//        abcdgh
//        Sample Output
//        0
//        Sample Input
//        abcabc
//        Sample Output
//        3


import java.io.*;
import java.util.*;

public class Main {

    public static int solution(String str){
        //write your code here
        int n = str.length;
        int dp[][]= new int[n+1][n+1];
        for(int i=n;i>=0;i--){
            for(int j=n;j>=0;j--){
                if(i==n && j==n){
                    dp[i][j]=0;
                }else if(i==n || j==n){
                    dp[i][j]=0;
                }else{
                    if(str.charAt(i)==str.charAt(j) && i!=j){
                        dp[i][j]=dp[i+1][j+1]+1;
                    }else{
                        dp[i][j]=Math.max(dp[i+1][j],dp[i][j+1]);
                    }
                }
            }
        }


        return dp[0][0];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
    }

}