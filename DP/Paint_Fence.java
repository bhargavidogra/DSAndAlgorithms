//Paint Fence
//1. You are given a number n and a number k in separate lines, representing the number of fences and number of colors.
//2. You are required to calculate and print the number of ways in which the fences could be painted so that not more than two consecutive  fences have same colors.

//Sample Input:
//        8
//        3
//Sample Output:
//        3672

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int k= sc.nextInt();
        int last2fence_in_same_color_ii = k*1;
        int last2fence_in_diff_color_ij = k*(k-1);
        int total= last2fence_in_same_color_ii+last2fence_in_diff_color_ij;

        for(int i=3;i<=n;i++){
            last2fence_in_same_color_ii = last2fence_in_diff_color_ij * 1;
            last2fence_in_diff_color_ij = total * (k-1);
            total= last2fence_in_same_color_ii+last2fence_in_diff_color_ij;
        }

        System.out.println(total);
    }
}