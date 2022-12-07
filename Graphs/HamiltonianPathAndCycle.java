//Hamiltonian Path And Cycle
//1. You are given a graph and a src vertex.
//        2. You are required to find and print all hamiltonian paths and cycles starting from src. The cycles must end with "*" and paths with a "."
//
//        Note -> A hamiltonian path is such which visits all vertices without visiting any twice. A hamiltonian path becomes a cycle if there is an edge between first and last vertex.
//        Note -> Print in lexicographically increasing order.
//
// Input
//        7
//        9
//        0 1 10
//        1 2 10
//        2 3 10
//        0 3 10
//        3 4 10
//        4 5 10
//        5 6 10
//        4 6 10
//        2 5 10
//        0
//
// Output
//        0123456.
//        0123465.
//        0125643*
//        0346521*



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

    public static void  hamiltonian(ArrayList<Edge>[] graph, int src, HashSet<Integer> visited, String psf, int osrc){
        if(visited.size()==graph.length-1){

            boolean closingegdefound=false;
            for(Edge e : graph[src]){
                if(e.nbr==osrc){
                    closingegdefound= true;
                    break;
                }
            }

            if(closingegdefound==true){
                System.out.println(psf+'*');
            }else{
                System.out.println(psf+'.');
            }
            return;
        }

        visited.add(src);
        for(Edge e:graph[src]){
            if(visited.contains(e.nbr)==false){
                hamiltonian(graph, e.nbr , visited, psf+e.nbr, osrc);
            }
        }
        visited.remove(src);

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

        int src = Integer.parseInt(br.readLine());

        HashSet<Integer> visited = new HashSet<>();
        hamiltonian(graph, src, visited, ""+src, src);
    }


}