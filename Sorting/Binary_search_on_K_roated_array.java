//Binary search on an array  // search element in k rotated array.
import java.util.*;
 class Solution {
    public static int search(int arr[], int key) {
        // Write your code here.
        int lo=0;int hi=arr.length-1;

        while(lo<=hi){
            int mid = (lo+hi) /2;

            if(arr[mid]==key){
                return mid;
            }else if(arr[lo]<=arr[mid]){
                //left part sorted
                if(key>=arr[lo] && key<arr[mid]){
                    hi=mid-1;
                }else{
                    lo=mid+1;
                }
            }else if(arr[hi]>=arr[mid]){
                //right part sorted
                if(key>arr[mid] && key<=arr[hi]){
                    lo=mid+1;
                }else{
                    hi=mid-1;
                }
            }
        }
        return -1;
    }
}