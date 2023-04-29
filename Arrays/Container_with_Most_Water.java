//Container With Most Water
//        Easy  Prev   Next
//        1. Given n non-negative integers a1, a2, ..., an.
//        2. Each represents a point at coordinate (i, ai).
//        3. 'n' vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0).
//        4. Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.
//        5. (Not volume because we are working with 2D so amount of water is basically Area).
//        Note : that you may not slant the container.
//        Input Format
//        1. Take 'n', size of Array
//        2. Take 'n' different element for Array
//        Output Format
//        1. Max water
//
//
//        Sample Input
//        9
//        1
//        8
//        6
//        2
//        5
//        4
//        8
//        3
//        7
//        Sample Output
//        49


import java.util.*;

 class FindMaxWater {

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~

    public static int mostWater(int[] heights) {
        // write your code here

        int result=0;
        int i=0, j=heights.length-1;
        while(i<j){
            int w =j-i;
            int h=Math.min(heights[i],heights[j]);
            result = Math.max(result,h*w);
            if(heights[i] < heights[j]){
                i++;
            }else{
                j--;
            }
        }
        return result;
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        // Write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] heights = new int[n];
        for(int i = 0; i < n; i++) {
            heights[i] = scn.nextInt();
        }

        int res = mostWater(heights);
        System.out.println(res);
    }
}