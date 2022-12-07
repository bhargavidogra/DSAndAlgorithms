//      Given an array of integers and a target value, determine the number of pairs of array elements that have a
//        difference equal to the target value.
//
//        Function Description
//        Complete the pairs function below.
//        pairs has the following parameter(s):
//        int k: an integer, the target difference
//        int arr[n]: an array of integers
//        Returns
//        int: the number of pairs that satisfy the criterion
//        Input Format
//        The first line contains two space-separated integers and , the size of and the target value.
//        The second line contains space-separated integers of the array .
//        Constraints
//        each integer will be unique
//
//        Sample Input
//        STDIN Function
//        ----- --------
//        5 2 arr[] size n = 5, k =2
//        1 5 3 4 2 arr = [1, 5, 3, 4, 2]
//
//        Sample Output
//        3
//        Explanation
//        There are 3 pairs of integers in the set with a difference of 2: [5,3], [4,2] and [3,1].
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
class Result {
    /*
     * Complete the 'pairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER k
     * 2. INTEGER_ARRAY arr
     */
    public static int pairs(int k, List<Integer> arr) {
// Write your code here
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        int count=0;
        for(int i=0;i<arr.size();i++){
            if(hm.containsKey(arr.get(i))){
                int v= hm.get(arr.get(i));
                v+=1;
                hm.put(arr.get(i), v);
            }else{
                hm.put(arr.get(i),1);
            }
        }
        for(int j=0;j<arr.size();j++){
            if(hm.containsKey(Math.abs(arr.get(j)-k)) ){
                int val = hm.get(Math.abs(arr.get(j)-k));
                val--;
                hm.put(Math.abs(arr.get(j)-k ), val);
                if (val>-1)
                    count++;
            }
        }
        return count;
    }
}