//Area under the histogram
import java.io.*;
import java.util.*;

 class Main{


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int rb[]= new int[n];//nse index on right
        int lb[]=new int [n];//nse index on left
        int area[]= new int [n];
//nse on right
        Stack<Integer> st = new Stack<Integer>();
        st.push(n-1);
        rb[n-1]=arr.length;
        for(int i=arr.length-2;i>=0;i--){
            while(st.size()>0 && arr[i]<=arr[st.peek()]){
                st.pop();
            }
            if(st.size()==0){
                rb[i]=arr.length;
            }else{
                rb[i]=st.peek();
            }
            st.push(i);
        }

//nse on left
        Stack<Integer> stl = new Stack<Integer>();
        stl.push(0);
        rb[0]=-1;
        for(int i=1;i<arr.length;i++){
            while(stl.size()>0 && arr[i]<=arr[stl.peek()]){
                stl.pop();
            }
            if(stl.size()==0){
                rb[i]=-1;
            }else{
                rb[i]=stl.peek();
            }
            stl.push(i);
        }


        int maxarea=0;
        for(int i=0;i<n;i++){
            int width= rb[i]-lb[i]-1;
            area[i]= arr[i]*width;
            if(area[i]>maxarea){
                maxarea= area[i];
            }
        }
        System.out.println(maxarea);
    }
}