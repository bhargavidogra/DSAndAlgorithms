//  K Largest Elements
//        1. You are given a number n, representing the size of array a.
//        2. You are given n numbers, representing elements of array a.
//        3. You are given a number k.
//        4. You are required to find and print the k largest elements of array in increasing order.
//
//  Input:
//        13
//        12
//        62
//        22
//        15
//        37
//        99
//        11
//        37
//        98
//        67
//        31
//        84
//        99
//        4
//
//  Output:
//        84
//        98
//        99
//        99

import java.io.*;
import java.util.*;

 class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int k = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i=0;i<arr.length;i++){
            if(i<k){
                pq.add(arr[i]);
            }else{
                if(arr[i]>pq.peek()){
                    pq.remove();
                    pq.add(arr[i]);
                }
            }
        }

        while(pq.size()>0){
            System.out.println(pq.remove());
        }
    }

}