//generic trees

import java.util.*;
class Scratch {
    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<Node>();
    }
    public static void display(Node n){
        String str = n.data + " -> ";
        for(Node child: n.children){
            str+= child.data+" , ";
        }
        str+=" .";
        System.out.println(str);

        for(Node child: n.children){
            display(child);
        }
    }
    public static void main(String[] args) {
        Node root = null; //unique node for a tree
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Stack< Node> st = new Stack<Node>();

        for(int i=0;i<arr.length;i++){
            if(arr[i]==-1){
                st.pop();
            }else{
                Node t = new Node();
                t.data =arr[i];
                if (st.size() > 0) {
                    st.peek().children.add(t);
                }
                else
                {
                    root = t;
                }
                st.push(t);
            }
        }
        display(root);
    }
}