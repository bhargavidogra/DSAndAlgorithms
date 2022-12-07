// Merge K Sorted Lists
//        1. You are given a list of lists, where each list is sorted.
//        2. You are required to complete the body of mergeKSortedLists function. The function is expected to merge k sorted lists to create one sorted list.
//
// Input:
//        4
//        5
//        10 20 30 40 50
//        7
//        5 7 9 11 19 55 57
//        3
//        1 2 3
//        2
//        32 39
//
// Output:
//        1 2 3 5 7 9 10 11 19 20 30 32 39 40 50 55 57



import java.io.*;
import java.util.*;

 class Main {

    public static class Pair implements Comparable<Pair> {
        int li;
        int pi;
        int val;
        Pair(int li, int pi, int val) {
            this.li = li;
            this.pi = pi;
            this.val = val;
        }
        public int compareTo(Pair o) {
            return this.val - o.val;
        }

    }

    public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {
        ArrayList<Integer> rv = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        //insert into PQ first elements of all arraylists.
        for (int i = 0; i < lists.size(); i++) {
            pq.add(new Pair(i, 0, lists.get(i).get(0)));
        }

        //Algorithm: While PQ is not empty remove min value pair from PQ ,
        // increase the position index(pi), check if next index is valid index of list(i.e have value in list)
        //update the rem pair value with the value (cheked for update index)
        //add it to the PQ, repeat same process till PQ  is empty
        while (pq.size() > 0) {
            Pair rem = pq.remove();
            rv.add(rem.val);
            rem.pi++;
            if (rem.pi < lists.get(rem.li).size()) {
                rem.val = lists.get(rem.li).get(rem.pi);
                pq.add(rem);
            }
        }

        return rv;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ArrayList<Integer> list = new ArrayList<>();

            int n = Integer.parseInt(br.readLine());
            String[] elements = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                list.add(Integer.parseInt(elements[j]));
            }

            lists.add(list);
        }

        ArrayList<Integer> mlist = mergeKSortedLists(lists);
        for (int val : mlist) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

}