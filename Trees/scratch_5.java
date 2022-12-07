//is-balanced-binary-tree-official
//input
//21
//50 25 12 n n 37 30 n n 51 n n 75 62 60 n n 70 n n n
//output
//false
import java.io.*;
import java.util.*;

 class Main {
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
    public static class BalPair{
        boolean isBal;
        int ht;
    }

    public static BalPair checkIsTreeBalanced(Node node){

        if(node==null) {
            BalPair bp = new BalPair();
            bp.isBal = true;
            bp.ht = 0;
            return bp;
        }

        BalPair lp= checkIsTreeBalanced(node.left);
        BalPair rp= checkIsTreeBalanced(node.right);

        BalPair mp = new BalPair();
        mp.ht= Math.max(lp.ht,rp.ht)+1;
        mp.isBal = lp.isBal && rp.isBal && (Math.abs(lp.ht-rp.ht)<=1);
        return mp;
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

        Node root = construct(arr);
        BalPair rs= checkIsTreeBalanced(root);
        System.out.println(rs.isBal);
        // write your code here
    }

}