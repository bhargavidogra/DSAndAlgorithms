//Print Nodes K Distance Away from given node
import java.io.*;
import java.util.*;

public class Main {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static void printKNodesFar(Node node, int data, int k) {
        // write your code here
        ArrayList<Node> nodeList = printKNodetoRootPath(node,data);

        for(int i=0;i<nodeList.size();i++){
            printKLevelFar(nodeList.get(i),k-i,i==0? null: nodeList.get(i-1));
        }

    }
    public static void printKLevelFar(Node node, int k,Node blocker) {
        if(node==null || k<0 || node== blocker)
            return;

        if(k==0)
            System.out.println(node.data);

        printKLevelFar(node.left,k-1,blocker);
        printKLevelFar(node.right,k-1,blocker);

    }

    public static ArrayList<Node> printKNodetoRootPath(Node node, int data){
        if(node==null)
        {
            return new ArrayList<Node>();
        }
        if(node.data == data)
        {
            ArrayList<Node> ar = new ArrayList<Node>();
            ar.add(node);
            return ar;
        }
        ArrayList<Node> lc =printKNodetoRootPath(node.left,data);
        if(lc.size()>0){
            lc.add(node);
            return lc;
        }
        ArrayList<Node> rc =printKNodetoRootPath(node.right,data);
        if(rc.size()>0){
            rc.add(node);
            return rc;
        }

        return new ArrayList<Node>();

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }

        int data = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        Node root = construct(arr);
        printKNodesFar(root, data, k);
    }

}