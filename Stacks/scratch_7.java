//Stack print next greatest element to right
//example:5 5 3 8 -2 7
//output:(NGE) 8 8 -1  7  -1
//output:(NSE) 3 -2 -2 -1 -1

import java.io.*;
import java.util.*;

 class Main{
    public static void display(int[] a){
        StringBuilder sb = new StringBuilder();

        for(int val: a){
            sb.append(val + "\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] nge = solveNGER(a);
        display(nge);
        int[] nse = solveNSER(a);
        display(nse);
    }

     public static int[] solveNSER(int[] arr){
         // solve
         int l = arr.length;
         int out[]= new int[l];
         Stack<Integer> st = new Stack<>();
         out[l-1]=-1;
         st.push(arr[l-1]);
         for(int i=l-2;i>=0;i--){
             while(st.size()>0 && st.peek()>=arr[i]){
                 st.pop();
             }
             if(st.size()==0){
                 out[i]=-1;
             }else{
                 out[i]=st.peek();
             }
             st.push(arr[i]);
         }

         return out;
     }


     public static int[] solveNGER(int[] arr){
        // solve
        int l = arr.length;
        int out[]= new int[l];
        Stack<Integer> st = new Stack<>();
        out[l-1]=-1;
        st.push(arr[l-1]);
        for(int i=l-2;i>=0;i--){
            while(st.size()>0 && st.peek()<=arr[i]){
                st.pop();
            }
            if(st.size()==0){
                out[i]=-1;
            }else{
                out[i]=st.peek();
            }
            st.push(arr[i]);
        }

        return out;
    }

}