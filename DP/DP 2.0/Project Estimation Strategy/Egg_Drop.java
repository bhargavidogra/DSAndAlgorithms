//Egg Drop
//        Hard  Prev   Next
//        1. You are given two integers N and K. N represents the number of eggs and K represents the number of floors in a building.
//        2. You have to find the minimum number of attempts you need in order to find the critical floor in the worst case while using the best strategy.
//        3. The critical floor is defined as the lowest floor from which you drop an egg and it doesn't break.
//        4. There are certain which you have to follow -
//        a. All eggs are identical.
//        b. An egg that survives a fall can be used again.
//        c. A broken egg can't be used again.
//        d. If the egg doesn't break at a certain floor, it will not break at any floor below.
//        e. If the egg breaks at a certain floor, it will break at any floor above.
//
//        Constraints
//        1 <= N <= 100
//        1 <= k <= 50
//        Sample Input
//        3
//        10
//        Sample Output
//        4

import java.io.*;
import java.util.*;

 class Main {

    public static int eggDrop(int n, int k){
        //write your code here
        //n = no of eggs
        //k= no of floors
        int dp[][]= new int[n+1][k+1];

        for(int egg=1;egg<=n;egg++){
            for(int floor=1;floor<=k;floor++){
                if(egg==1){
                    dp[egg][floor]=floor;
                }else if(floor==1){
                    dp[egg][floor]=1;
                }else{
                    int min= Integer.MAX_VALUE;
                    for(int mj=floor-1,pj=0;mj>=0;mj--,pj++){
                        int val1 = dp[egg][mj]; // egg survives
                        int val2 = dp[egg-1][pj]; // egg breaks
                        int val = Math.max(val1,val2);
                        min = Math.min(min,val);
                    }
                    dp[egg][floor] = min+1;
                }
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        //n -> number of eggs and k -> number of floors
        int n = scn.nextInt();
        int k = scn.nextInt();
        System.out.println(eggDrop(n,k));
    }

}