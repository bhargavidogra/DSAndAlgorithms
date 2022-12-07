//find all pairs formation possibilities in an array
import java.io.*;
import java.util.*;
class Solution {

    public static void main(String[] args) {
        int arr[]= new int[4];
        arr[0]=1;
        arr[1]=2;
        arr[2]=3;
        arr[3]=4;

        getAllPairs(arr,0);
    }
    public static void getAllPairs( int arr[], int idx) {
        if (idx >= arr.length )
            return;
        getAllPairs(arr, idx+1);
        for (int i = 0; i < arr.length; i++) {
            if(idx!=i)
            System.out.println(arr[idx] + ", " + arr[i]);
        }
        System.out.println();
        System.out.println();
    }
}