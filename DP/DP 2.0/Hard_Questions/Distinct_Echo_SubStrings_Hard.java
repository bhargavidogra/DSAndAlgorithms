//Distinct Echo Substrings
//        Hard
//
//        247
//
//        185
//
//        Add to List
//
//        Share
//        Return the number of distinct non-empty substrings of text that can be written as the concatenation of some string with itself (i.e. it can be written as a + a where a is some string).
//
//
//
//        Example 1:
//
//        Input: text = "abcabcabc"
//        Output: 3
//        Explanation: The 3 substrings are "abcabc", "bcabca" and "cabcab".
//        Example 2:
//
//        Input: text = "leetcodeleetcode"
//        Output: 2
//        Explanation: The 2 substrings are "ee" and "leetcodeleetcode".
//
//
//        Constraints:
//
//        1 <= text.length <= 2000
//        text has only lowercase English letters.

import java.io.*;
import java.util.*;

 class Main {

     public int distinctEchoSubstrings(String text) {
         HashSet<String> set = new HashSet();
         int n = text.length();

         for(int len = 1; len<  n/2 +1; len++){
             int count=0;
             for(int l =0,r=len;r<n;l++,r++){
                 if(text.charAt(l)==text.charAt(r)){
                     count++;
                 }else{
                     count=0;
                 }

                 if(count ==len){
                     String str = text.substring(l,r+1);
                     set.add(str);
                     count--;//Remove first character of found echo string to check next substings of length
                 }
             }
         }
         return set.size();
     }

     public int distinctEchoSubstrings1(String text) {
         HashMap<Integer, String> distinctMap = new HashMap();
         int str_len = text.length();
         Set<String> answers = new HashSet();
         int counter = 0;
         for(int n = 1; n < 1+str_len/2; n++)
         {
             for(int i = 0; i < str_len-n+1; i++)
             {
                 String sub = text.substring(i, i+n);
                 if(distinctMap.containsKey(i) && distinctMap.get(i).equals(sub))
                 {
                     answers.add(sub);
                 }
                 distinctMap.put(i+n, sub);
             }
             distinctMap.clear();
         }
         return answers.size();
     }

}