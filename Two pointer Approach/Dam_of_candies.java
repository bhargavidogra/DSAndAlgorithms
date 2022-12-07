// Dam of Candies (GFG)

//Input: N = 3, height[] = {1, 3, 4}
//        Output: 1
//        Explanation:
//        1. Area between book of height 1 and book of
//        height 3 is 0 as there is no space between
//        them.
//        2. Area between book of height 1 and book of
//        height 4 is 1 by removing book of height 3.
//        3. Area between book of height 3 and book of
//        height 4 is 0 as there is no space between them.
//
//        Input: N = 6, height[] = {2, 1, 3, 4, 6, 5}
//        Output: 8
//        Explanation: Remove the 4 books in the middle
//        creating length = 4 for the candy dam. Height
//        for dam will be min(2,5) = 2.
//        Area between book of height 2 and book
//        of height 5 is 2 x 4 = 8.

import java.util.ArrayList;
import java.util.Scanner;

class Scratch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int A[]= new int[n];
        for (int i=0;i<n;i++){
            A[i]= sc.nextInt();
        }
        int res = maxCandy(A,n);

            System.out.print(res);

    }
    public static int maxCandy(int height[], int n)
    {
        // Your code goes here

        int max_candy=Integer.MIN_VALUE;



        for(int i=0,j=n-1;i<j;){
            int  val1= (j-i-1) * Math.min(height[j],height[i]);
            if(val1>max_candy){
                max_candy= val1;

            }
            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
        }


        return max_candy==Integer.MIN_VALUE?0:max_candy;

    }
}