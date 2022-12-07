//Distinct Transformations
//        Medium  Prev   Next
//        1. You are given two strings S1 and S2.
//        2. You have to find the number of unique ways in which you can transform S1 to S2.
//        3. Transformation can be achieved by removing 0 or more characters from S1, such that the sequence formed by the remaining characters of S1 is identical to S2.
//
//        Constraints
//        1 <= length of strings S1 and S2 <= 1000
//
//        Sample Input
//        abcccdf
//        abccdf
//
//        Sample Output
//        3

import java.io.*;
import java.util.*;

 class Main {

    public static int solution(String s, String t) {
        // write your code here
        int n = t.length();
        int m = s.length();
        int dp[][]= new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0 && j==0){
                    dp[i][j]=1;
                }else if(i==0){
                    dp[i][j]=1;
                }else if(j==0){
                    dp[i][j]=0;
                }else{
                    char c1= t.charAt(i-1);char c2= s.charAt(j-1);
                    if(c1!=c2){
                        dp[i][j]=dp[i][j-1];
                    }else{
                        dp[i][j]=dp[i][j-1]+dp[i-1][j-1];
                    }
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        System.out.println(solution(s1, s2));
    }

}