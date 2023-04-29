//Squares Of A Sorted Array
//        Easy  Prev   Next
//        1. Given an integer array 'nums' sorted in non-decreasing order.
//        2. Return an array of the squares of each number sorted in non-decreasing order.
//        Input Format
//        nums = [-4,-1,0,3,10]
//        Output Format
//        [0,1,9,16,100]
//        Explanation: After squaring, the array becomes [16,1,0,9,100].
//        After sorting, it becomes [0,1,9,16,100].
//
//        Sample Input
//        9
//        -6 -2 -1 0 1 4 5 7 9
//        Sample Output
//        0 1 1 4 16 25 36 49 81

import java.util.*;

 class GetSortedSquareArrayOptimised {

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~

    public static int[] sortedSquares(int[] nums) {
        // write your code here
        int l = 0;
        int r = nums.length-1;
        int result[]= new int[nums.length];
        int k=nums.length-1;
        while(l<r){
            int v1= nums[l]*nums[l];
            int v2= nums[r]*nums[r];
            if(v1>v2){
                result[k]=v1;
                l++;
            }else{
                result[k]=v2;
                r--;
            }
            k--;
        }
        return result;

    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] nums = new int[n];

        for(int i = 0; i < n; i++)
            nums[i] = scn.nextInt();

        int[] res = sortedSquares(nums);

        for(int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
    }
}