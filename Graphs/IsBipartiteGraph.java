//Is Graph Bipartite
//1. You are given a graph.
//2. You are required to find and print if the graph is bipartite
//
//Note -> A graph is called bipartite if it is possible to split it's vertices in two sets of mutually
//               exclusive and exhaustive vertices such that all edges are across sets.

//Input:
//        7
//        8
//        0 1 10
//        1 2 10
//        2 3 10
//        0 3 10
//        3 4 10
//        4 5 10
//        5 6 10
//        4 6 10
//output:
//        false

import java.io.*;
import java.util.*;

 class Main {
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
        int level;
        Pair(int v, String psf, int level) {
            this.v = v;
            this.psf = psf;
            this.level = level;
        }
    }

    public static boolean checkifGraphsIsBipartite( ArrayList<Edge>[] graph, int src, int[] visited) {
        ArrayDeque <Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(src, "" + src, 0));
        //r m* w, a*
        while (queue.size() > 0) {
            //remove from vertex queue
            Pair rem = queue.removeFirst();

            //if already visited vertex then
            if (visited[rem.v] != -1) {
                //check if removed vertex and previouly marked visited vertex level is not same returen false;
                if (visited[rem.v] != rem.level) {
                    return false;
                }
            }
            else { //if not already visited vertex then mark visited by adding removed vertex level to it.
                visited[rem.v] = rem.level;
            }

            //check for neighbours
            for (Edge e : graph[src]) {
                if (visited[e.nbr] == -1) {
                    queue.add(new Pair(e.nbr, rem.psf + e.nbr , rem.level + 1));
                }
            }
        }

        return true;

    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int vtces = sc.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = sc.nextInt();
        for (int i = 0; i < edges; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int wt = sc.nextInt();
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        int visited[] = new int[vtces];
        Arrays.fill(visited, -1);
        for (int v = 0; v < vtces; v++) {
            if (visited[v] == -1) {
                boolean isBipartite = checkifGraphsIsBipartite(graph, v, visited);
                if (isBipartite == false) {
                    System.out.println(false);
                    return;
                }
            }
        }
        System.out.println(true);
    }
}