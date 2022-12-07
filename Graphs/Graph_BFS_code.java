//Breadth First Traversal
//        1. You are given a graph, and a src vertex.
//        2. You are required to do a breadth first traversal and print which vertex is reached via which path,
//        starting from the src.
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
//        2
//
//Output:
//        2@2
//        1@21
//        3@23
//        0@210
//        4@234
//        5@2345
//        6@2346

import java.io.*;
import java.util.*;

 class Main {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
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
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        int src = Integer.parseInt(br.readLine());
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[vtces];
        queue.add(new Pair(src, src + ""));

        while (queue.size() > 0) {
            //Algorithm
            //r *m w *a

            //remove  (r)
            Pair rem = queue.removeFirst();
            if (visited[rem.v] == true) {
                continue;
            }

            //mark star/visited (m*)
            visited[rem.v] = true;

            //Do work (w) here means print elements of queue
            System.out.println(rem.v + "@" + rem.psf);

            //check for neighbours/ add to queue

            for (Edge e : graph[rem.v]) {
                if (visited[e.nbr] == false) {
                    queue.add(new Pair(e.nbr, rem.psf + e.nbr));
                }
            }
        }
    }
}