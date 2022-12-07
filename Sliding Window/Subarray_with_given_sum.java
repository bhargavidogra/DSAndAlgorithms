//  Subarray with given sum
// find continuous subarray with given sum. incase multiple present give first subarry as answer.
//
//
//    Input:
//        N = 5, S = 12
//        A[] = {1,2,3,7,5}
//        Output: 2 4
//        Explanation: The sum of elements
//        from 2nd position to 4th position
//        is 12.
//
//
//        Input:
//        N = 10, S = 15
//        A[] = {1,2,3,4,5,6,7,8,9,10}
//        Output: 1 5
//        Explanation: The sum of elements
//        from 1st position to 5th position
//        is 15.

import java.util.Scanner;
import java.util. *;

class Scratch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int S = sc.nextInt();
        int A[]= new int[n];
        for (int i=0;i<n;i++){
            A[i]= sc.nextInt();
        }
        ArrayList<Integer> arr = subarraySum(A,n,S);
        for(int a:arr){
            System.out.print(a+" ");
        }

    }

   public static  ArrayList<Integer> subarraySum(int[] arr, int n, int s)
   {
       // Your code here
       ArrayList<Integer> ar = new ArrayList<Integer>();
       int i=0, j=0;
       int sum=0;
       if(s==0){
           ar.add(-1);
           return ar;
       }
       while(j<n && i<n){

           sum+=arr[j];

           if(sum>=s){
               if(sum==s){
                   ar.add(i+1);
                   ar.add(j+1);
                   break;
               }else{
                   while(sum!=s && sum>=s){
                       sum-=arr[i];
                       i++;
                   }
                   if(sum==s){
                       ar.add(i+1);
                       ar.add(j+1);
                       break;
                   }else{
                       j++;
                   }
               }
           }else{
               j++;
           }
           if(j<i){
               j=i;
               sum=0;
           }
       }

       if(ar.size()==0){
           ar.add(-1);
       }

       return ar;
   }
}