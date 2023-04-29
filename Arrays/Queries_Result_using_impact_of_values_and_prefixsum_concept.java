//Range Addition
//        Easy  Prev   Next
//        1. Assume you have an array of length 'n' initialized with all 0's and are given 'q' queries to update.
//        2. Each query is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.
//        3. Return the modified array after all 'q' queries were executed.
//        Input Format
//        length = 5,
//        updates =
//        {
//        {1,  3,  2},
//        {2,  4,  3},
//        {0,  2, -2}
//        }
//        Output Format
//        return {-2, 0, 3, 5, 3}
//        Explanation :
//        Initial state:
//        { 0, 0, 0, 0, 0 }
//        After applying operation [1, 3, 2]:
//        { 0, 2, 2, 2, 0 }
//        After applying operation [2, 4, 3]:
//        { 0, 2, 5, 5, 3 }
//        After applying operation [0, 2, -2]:
//        {-2, 0, 3, 5, 3 }

//concept - check the impact that third value will make by adding the value on start index and removeits impact
//          by deleting the same value on end index. Keep tack of last index as it will not be impacted.
//          After processing all queries take a prefix sum of the result array tofind fial result.


import java.util.*;

 class Arraysquery{

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~

    public static int[] getModifiedArray(int length, int[][] queries) {
        // write your code here

        int res []= new int[length];

        for(int i=0;i<queries.length;i++){
            int st = queries[i][0];
            int end = queries[i][1];
            int val = queries[i][2];

            res[st]+=val;
            if(end+1<length){
                res[end+1]-=val;
            }
        }
        int psum=0;

        for(int j=0;j<length;j++){
            psum+=res[j];
            res[j]=psum;
        }
        return res;


    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int length = scn.nextInt();

        int nq = scn.nextInt();

        int[][] queries = new int[nq][3];

        for(int q = 0; q < nq; q++) {
            queries[q][0] = scn.nextInt();
            queries[q][1] = scn.nextInt();
            queries[q][2] = scn.nextInt();
        }


        int[] res = getModifiedArray(length, queries);

        for(int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}