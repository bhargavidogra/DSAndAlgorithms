//Binary Search on 2D Matrix 


/*************************************

 Following is the Pair Class structure.

 class Pair{
 int x; int y;

 Pair(int x, int y){
 this.x = x;
 this.y = y;
 }
 }

 *************************************/

public class Solution {
    public static Pair search(int [][] matrix, int x) {
        // Write your code here.
        int r=0;
        int c = matrix.length -1;
        //check the row's last element if equal to x return index else
        //if row's last elemnt is smaller increase row count
        //else its in the same row decrease column by 1 each and check for element in same row
        // when gained index return pair else when complete traversed return pair(-1,-1)
        while(r < matrix.length && c >= 0){
            if(matrix[r][c]==x){
                return (new Pair(r,c));
            }else if(matrix[r][c]<x){
                r++;
            }else{
                c--;
            }
        }

        return (new Pair(-1,-1));
    }
}
