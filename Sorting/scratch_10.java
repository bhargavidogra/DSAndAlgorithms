//New year Chaoes:
//eg 1)    8
//         1 2 3 5 4 6 7 8  // 1
//   2)    8
//         1 2 5 3 7 8 6 4  //7

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
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
        // Write your code here
//     boolean flag = true;
//     int bribe=0;

//     for(int i=0;i<q.size();i++){
//         if(q.get(i)>i){
//             if((q.get(i)-1)-i <= 2){
//                 bribe+=(q.get(i)-1)-i;
//             }else{
//                 flag=false;
//                 break;
//             }
//         }else if(i-q.get(i)>2){
//             bribe=bribe+((i-q.get(i))-2);
//         }
//     }

// if(flag){
//     System.out.println(bribe);
// }else{
//     System.out.println("Too chaotic");
// }

        int mbribes = 0;

        for(int i=0;i<q.size();i++){
            if(q.get(i)>i){
                if((q.get(i)-1)-i > 2){
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }



        Integer[] arr = new Integer[q.size()];
        arr = q.toArray(arr);
        for (int i = arr.length - 4; i >= 0; i--) {
            for (int j = i; j <= i + 2; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    mbribes++;
                }

            }
        }
        System.out.println(mbribes);


    }

}

 class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                Result.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
