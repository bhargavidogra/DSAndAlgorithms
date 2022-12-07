//Get Common Elements - 1
//1. You are given a number n1, representing the size of array a1.
//        2. You are given n1 numbers, representing elements of array a1.
//        3. You are given a number n2, representing the size of array a2.
//        4. You are given n2 numbers, representing elements of array a2.
//        5. You are required to print all elements of a2 which are also present in a1 (in order of their occurence in a2). Make sure to not print duplicates (a2 may have same value present many times).
//
//Input:
//        9
//        5
//        5
//        9
//        8
//        5
//        5
//        8
//        0
//        3
//        18
//        9
//        7
//        1
//        0
//        3
//        6
//        5
//        9
//        1
//        1
//        8
//        0
//        2
//        4
//        2
//        9
//        1
//        5
//Output:
//        9
//        0
//        3
//        5
//        8

import java.io.*;
import java.util.*;

 class Main{

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer,Integer> hm = new HashMap<>();

        int n1= sc.nextInt();
        int ar1[]= new int[n1];

        for(int i=0;i<n1;i++){
            ar1[i]= sc.nextInt();
            if(hm.containsKey(ar1[i])){
                int of = hm.get(ar1[i]);
                int nf= of+1;
                hm.put(ar1[i], nf);
            }else{
                hm.put(ar1[i],1);
            }
        }

        int n2= sc.nextInt();
        int ar2[]= new int[n2];
        for(int i=0; i<n2; i++){
            ar2[i]= sc.nextInt();
        }


        for(int val : ar2){
            if(hm.containsKey(val)){
                System.out.println(val);
                hm.remove(val);
            }
        }

    }

}