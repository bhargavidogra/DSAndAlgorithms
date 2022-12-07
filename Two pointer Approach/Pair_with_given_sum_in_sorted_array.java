// Pair with given sum in sorted array

//â€‹Input:
//        n = 7
//        arr[] = {1, 2, 3, 4, 5, 6, 7}
//        K = 8
//        Output:
//        3
//        Explanation:
//        We find 3 such pairs that
//        sum to 8 (1,7) (2,6) (3,5)
//
//        Input:
//        n = 7
//        arr[] = {1, 2, 3, 4, 5, 6, 7}
//        K = 98
//        Output:
//        -1

import java.util.ArrayList;
import java.util.Scanner;

class Scratch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int S = sc.nextInt();
        int A[]= new int[n];
        for (int i=0;i<n;i++){
            A[i]= sc.nextInt();
        }
        int res = Countpair(A,n,S);

            System.out.print(res);

    }
    public static int Countpair(int a[], int n, int sum)
    {
        // Complete the function
        int count=0;
        for(int i=0,j=n-1;i<j;){
            if(a[i]+a[j]==sum){
                count++;
                i++;
                j--;
            }else if(a[i]+a[j]>sum){
                j--;
            }else {
                i++;
            }
        }
        return count>0?count:-1;
    }
}