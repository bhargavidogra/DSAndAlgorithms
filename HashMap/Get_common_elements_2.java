//Get Common Elements - 2
//        1. You are given a number n1, representing the size of array a1.
//        2. You are given n1 numbers, representing elements of array a1.
//        3. You are given a number n2, representing the size of array a2.
//        4. You are given n2 numbers, representing elements of array a2.
//        5. You are required to find the intersection of a1 and a2. To get an idea check the example below:
//
//        if a1 -> 1 1 2 2 2 3 5
//        and a2 -> 1 1 1 2 2 4 5
//        intersection is -> 1 1 2 2 5
//
//  Input:
//        1
//        1
//        2
//        2
//        2
//        3
//        5
//        7
//        1
//        1
//        1
//        2
//        2
//        4
//        5
//
//  Output:
//        1
//        1
//        2
//        2
//        5

import java.io.*;
import java.util.*;

 class Main{

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> hm = new HashMap<>();

        int n1 = sc.nextInt();
        int ar1[] = new int[n1];

        for (int i = 0; i < n1; i++) {
            ar1[i] = sc.nextInt();
            if (hm.containsKey(ar1[i])) {
                int of = hm.get(ar1[i]);
                int nf = of + 1;
                hm.put(ar1[i], nf);
            } else {
                hm.put(ar1[i], 1);
            }
        }

        int n2 = sc.nextInt();
        int ar2[] = new int[n2];
        for (int i = 0; i < n2; i++) {
            ar2[i] = sc.nextInt();
        }


        for (int val : ar2) {
            if (hm.containsKey(val) && hm.get(val)>0) {
                System.out.println(val);
                int of = hm.get(val);
                int nf = of - 1;
                hm.put(val, nf);
            }
        }

    }

}