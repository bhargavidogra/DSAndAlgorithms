//  Perfect Friends
//        1. You are given a number n (representing the number of students). Each student will have an id
//        from 0 to n - 1.
//        2. You are given a number k (representing the number of clubs)
//        3. In the next k lines, two numbers are given separated by a space. The numbers are ids of
//        students belonging to same club.
//        4. You have to find in how many ways can we select a pair of students such that both students are
//        from different clubs.
//
//  Input:
//        7
//        5
//        0 1
//        2 3
//        4 5
//        5 6
//        4 6
//
//  Output:
//        16

import java.io.*;
import java.util.*;

 class Main {
    public static class Edge {
        int vert;
        int nbr;
        Edge(int v, int n) {
            this.vert = v;
            this.nbr = n;
        }
    }
    public static void DrawTreeandGetComponents( ArrayList<Edge>[] graph, int src, ArrayList<Integer> comp, boolean[] visited ) {
        visited[src] = true;
        comp.add(src);

        for (Edge e : graph[src]) {
            if (visited[e.nbr] == false) {
                DrawTreeandGetComponents(graph, e.nbr, comp, visited);
            }
        }
    }


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        ArrayList<Edge>[] graph = new ArrayList[n];

        for (int v = 0; v < n; v++) {
            graph[v] = new ArrayList<Edge>();
        }

        for (int i = 0; i < k; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            Edge e1 = new Edge(v1, v2);
            Edge e2 = new Edge(v2, v1);
            graph[v1].add(e1);
            graph[v2].add(e2);
        }
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for (int v = 0; v < n; v++) {
            if (visited[v] == false) {
                ArrayList<Integer> comp = new ArrayList<>();
                DrawTreeandGetComponents(graph, v, comp, visited);
                comps.add(comp);
            }
        }

        int count = 0;
        for (int i = 0; i < comps.size(); i++) {
            for (int j = i+1; j < comps.size(); j++) {
                int cc = comps.get(i).size() * comps.get(j).size();
                count += cc;
            }
        }

        System.out.println(count);
    }

}