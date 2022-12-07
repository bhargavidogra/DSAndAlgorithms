//Rotate matrix by 90 degree anti clockwise direction:

//Sample input:
//
//        test cases: 2
//
//       1) N: 3
//
//        1  2  3
//        4  5  6
//        7  8  9
//
//       2) N: 4
//
//        1  2  3  4
//        5  6  7  8
//        9 10 11 12
//        13 14 15 16
//
//Sample Output:
//        3  6  9
//        2  5  8
//        1  4  7
//
//        4  8 12 16
//        3  7 11 15
//        2  6 10 14
//        1  5  9 13

 class Solution {

    public static void inplaceRotate(int[][] arr, int n) {
        // Write your code here.
        for(int r =0;r<n;r++){
            //reverse  the matrix
            reverse(r,arr);
        }
        //take transpose
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp = arr[i][j];
                arr[i][j]= arr[j][i];
                arr[j][i]= temp;
            }
        }

    }

    public static void reverse(int r, int arr[][]){
        int start=0;int end= arr.length-1;
        while(start<end){
            int temp = arr[r][start];
            arr[r][start]= arr[r][end];
            arr[r][end]= temp;
            start++;
            end--;
        }
    }

}