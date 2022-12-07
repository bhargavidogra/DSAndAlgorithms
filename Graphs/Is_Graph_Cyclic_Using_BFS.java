//Is Graph Cyclic - using BFS
//        1. You are given a graph.
//        2. You are required to find and print if the graph is cyclic.
//
//Input:
//        7
//        6
//        0 1 10
//        1 2 10
//        2 3 10
//        3 4 10
//        4 5 10
//        5 6 10
//Output:
//        false


import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    static class Pair {
        int v;
        String psf;
        Pair(int v, String psf) {
            this.v = v;
            this.psf = psf;
        }
    }
    public static boolean IsCyclic(ArrayList<Edge>[] graph, int src, boolean[] visited) {
        ArrayDeque<Pair> queue = new ArrayDeque<Pair>();
        queue.add(new Pair(src, src + ""));

        while (queue.size() > 0) {
            //Algo --> r m* w a*
            //remove (r)
            Pair rem =  queue.removeFirst();
            if (visited[rem.v] == true) {
                return true;
            }
            //mark visited (m*)
            visited[rem.v] = true;
            //do work (w) -> in this case no work to do

            //add neighbours/check neighbours (a*)
            for (Edge e : graph[src]) {
                if (visited[e.nbr] == false) {
                    queue.add(new Pair(e.nbr, rem.psf + e.nbr));
                }
            }
        }
        return false;

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }
        boolean visited[] = new boolean[vtces];
        for (int v = 0; v < vtces; v++) {
            if (visited[v] == false) {
                boolean iscyclic = IsCyclic(graph, v, visited);
                if (iscyclic) {
                    System.out.println(true);
                    return;
                }
            }
        }
        System.out.println(false);
    }
}