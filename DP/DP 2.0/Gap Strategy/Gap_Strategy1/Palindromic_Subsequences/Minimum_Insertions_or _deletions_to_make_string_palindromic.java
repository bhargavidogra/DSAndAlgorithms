//Minimum Insertions/Minimum Deletions To Make Palindrome
//        Easy  Prev   Next
//        1. You are given a string(str).
//        2. You have to find the minimum number of characters to be inserted to convert it to a palindrome.
//
//        Concept: Find LPS longest Palindromic subsequence (length) then subtract that length from string size to get result.
//
//        Constraints
//        1 <= length of s1 <= 10000
//
//        Sample Input
//        pepperatcoding
//
//        Sample Output
//        10


import java.io.*;
import java.util.*;

 class Main {

    public static int solution(String str) {
        // write your code here

        int n = str.length();
        int dp[][]= new int [n][n];

        for(int g=0;g<n;g++){
            for(int i=0,j=g;j<n;i++,j++){
                if(g==0){
                    dp[i][j]=1;
                }else if(g==1){
                    char c1=str.charAt(i);
                    char c2 = str.charAt(j);
                    if(c1==c2){
                        dp[i][j]=2;
                    }else{
                        dp[i][j]=1;
                    }
                }else{
                    char c1=str.charAt(i);
                    char c2 = str.charAt(j);
                    if(c1==c2){
                        dp[i][j]=dp[i+1][j-1]+2;
                    }else{
                        dp[i][j]=Math.max(dp[i][j-1],dp[i+1][j]);
                    }
                }
            }
        }

        return n-dp[0][n-1];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
    }
}