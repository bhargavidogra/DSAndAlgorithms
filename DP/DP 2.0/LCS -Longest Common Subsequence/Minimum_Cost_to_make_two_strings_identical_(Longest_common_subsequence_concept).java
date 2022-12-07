//Minimum Cost To Make Two Strings Identical
//        Easy  Prev   Next
//        1. You are given two strings S1, S2, and two numbers x and y.
//        2. The cost of deleting a character from S1 is x and the cost of deleting a character from S2 is y.
//        3. You can delete characters from both the strings.
//        4. You have to find the minimum cost required to make the given two strings identical.
//
//        Sample Input
//        sea
//        eat
//        10
//        7
//        Sample Output
//        17

import java.io.*;
import java.util.*;

 class Main {

    public static int solution(String s1, String s2, int c1, int c2) {
        // write your code here


        int s1l = s1.length();
        int s2l = s2.length();
        int dp[][]= new int[s1l+1][s2l+1];
        for(int i=s1l;i>=0;i--){
            for(int j=s2l;j>=0;j--){
                if((i==s1l) || (j==s2l)){
                    dp[i][j]=0;
                }
                else{
                    char c11 = s1.charAt(i);
                    char c22 = s2.charAt(j);
                    if(c11==c22){
                        dp[i][j]= dp[i+1][j+1]+1;
                    }else{
                        dp[i][j]=Math.max(dp[i+1][j],dp[i][j+1]);
                    }
                }
            }
        }

        int cost1= s1l-dp[0][0];
        int cost2 = s2l-dp[0][0];
        int total = c1*cost1 + c2*cost2;
        return total;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        int x = scn.nextInt();
        int y = scn.nextInt();
        System.out.println(solution(s1, s2,x, y));
    }

}