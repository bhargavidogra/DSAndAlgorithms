import java.io.*;
import java.util.*;
class Scratch {
    public static void quickSort(int[] arr, int lo, int hi) {
        //write your code here
        if(lo>=hi)
            return;

        int pivot = arr[(lo+hi)/2];
        int idx = partition(arr,pivot);
        quickSort(arr,lo,idx-1);
        quickSort(arr,idx,hi);
    }

    public static int partition(int[] arr, int pivot){
        //write your code here
        int l=0,r=arr.length-1;
        while(l<=r){
            while(arr[l]<pivot){
                l++;
            }
            while(arr[r]>pivot){
                r--;
            }
            if(l<=r){
                swap(arr,l,r);
                l++;
                r--;
            }
        }
        return l;
    }

    // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        quickSort(arr, 0, arr.length - 1);
        print(arr);
    }
}