//Prims Algorithm
//Minimum Wire Required To Connect All Pcs
//        1. You are given a graph and a source vertex. The vertices represent computers and the edges
//        represent length of LAN wire required to connect them.
//        2. You are required to find the minimum length of wire required to connect all PCs over a network.
//        Print the output in terms of which all PCs need to be connected, and the length of wire between
//        them.
//
//        Note -> For output, check the sample output and question video.
//
//Input:
//        7
//        8
//        0 1 10
//        1 2 10
//        2 3 10
//        0 3 40
//        3 4 2
//        4 5 3
//        5 6 3
//        4 6 8
//
//Output:
//
//        [1-0@10]
//        [2-1@10]
//        [3-2@10]
//        [4-3@2]
//        [5-4@3]
//        [6-5@3]



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

    static class Pair implements Comparable<Pair>{
        int vertex;
        int acquired_vertex;
        int current_vertex_wt;
        Pair(int v, int psf, int wt){
            this.vertex = v;
            this.acquired_vertex = psf;
            this.current_vertex_wt = wt;
        }
        public int compareTo(Pair o){
            return this.current_vertex_wt-o.current_vertex_wt;
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
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,-1,0));
        boolean[] visited = new boolean[vtces];

        while(pq.size()>0){
            Pair rem = pq.remove();

            if(visited[rem.vertex]==true){
                continue;
            }
            visited[rem.vertex]=true;
            if(rem.acquired_vertex!= -1){
                System.out.println("["+rem.vertex+"-"+rem.acquired_vertex + "@"+ rem.current_vertex_wt+"]");
            }
            for(Edge e : graph[rem.vertex]){
                if(visited[e.nbr]==false){
                    pq.add(new Pair(e.nbr, rem.vertex , e.wt));
                }
            }

        }

    }
}