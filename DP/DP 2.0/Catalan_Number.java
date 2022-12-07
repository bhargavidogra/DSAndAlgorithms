Catalan Number
        Easy  Prev   Next
        1. You are given a number n.
        2. You are required to find the value of nth catalan number.
        C0 -> 1
        C1 -> 1
        C2 -> 2
        C3 -> 5
        C4 -> 14
        C5 -> 42
        ..
        Cn -> C0.Cn-1 + C1.Cn-2 + .. + Cn-2.C1 + Cn-1.C0

        Sample Input
        4
        Sample Output
        14


import java.io.*;
import java.util.*;
class Scratch {
    // write your code here
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int dp[]= new int[n+1];
    dp[0]=1;
    dp[1]=1;
    for(int i=2;i<=n;i++){
        int s=0;
        int e=i-1;
        while(s<i){
            dp[i]+=dp[s]*dp[e];
            s++;
            e--;
        }
    }
    System.out.println(dp[n]);

}
}