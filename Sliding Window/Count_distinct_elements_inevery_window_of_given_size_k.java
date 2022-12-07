//  Count distinct elements in every window of given size k
//
//
//      Input:
//        N = 7, K = 4
//        A[] = {1,2,1,3,4,2,3}
//        Output: 3 4 4 3
//        Explanation: Window 1 of size k = 4 is
//        1 2 1 3. Number of distinct elements in
//        this window are 3.
//        Window 2 of size k = 4 is 2 1 3 4. Number
//        of distinct elements in this window are 4.
//        Window 3 of size k = 4 is 1 3 4 2. Number
//        of distinct elements in this window are 4.
//        Window 4 of size k = 4 is 3 4 2 3. Number
//        of distinct elements in this window are 3.
//
//       Input:
//        N = 3, K = 2
//        A[] = {4,1,1}
//        Output: 2 1

import java.util.Scanner;
import java.util. *;

class Scratch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        int k = sc.nextInt();
        int n = sc.nextInt();
        int A[]= new int[n];
        for (int i=0;i<n;i++){
            A[i]= sc.nextInt();
        }
        ArrayList<Integer> arr = countDistinct(A,n,k);
        for(int a:arr){
            System.out.print(a+" ");
        }

    }

   public static ArrayList<Integer> countDistinct(int A[], int n, int k)
    {
        int i=0,j=k;

        ArrayList<Integer> ar = new  ArrayList<Integer>();

        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int l=0;l<k;l++){

            hm.put(A[l],hm.getOrDefault(A[l],0)+1);
        }

        ar.add(hm.size());
        for( i=1,j=k;i<=n-k && j<n;i++,j++)
        {

            int cr = A[i-1];
            int ci = A[j];

            int f = hm.get(cr);
            if(f==1){
                hm.remove(cr);
            }else{
                f=f-1;
                hm.put(cr,f);
            }

            if(hm.containsKey(ci)){
                f = hm.get(ci);
                f=f+1;
                hm.put(ci,f);
            }else{
                hm.put(ci,1);
            }


            ar.add(hm.size());
        }
        return ar;
    }
}