// Given a String S and an integer K. Find the count of all substrings of length K which have exactly K-1 distinct characters.
//
//
//
//        Example 1:
//
//        Input:
//        S = "abcc"
//        K = 2
//        Output:
//        1
//        Explanation:
//        Possible substrings of length K = 2 are
//        ab : 2 distinct characters
//        bc : 2 distinct characters
//        cc : 1 distinct character
//        Only one valid substring exists {"cc"}.
//        Example 2:
//        Input:
//        S = "aabab"
//        K = 3
//        Output :
//        3
//        Explanation:
//        Possible substrings of length K = 3 are
//        aab : 2 distinct characters
//        aba : 2 distinct characters
//        bab : 2 distinct characters.
//        All of these Substrings are a possible answer,
//        so the count is 3.
//
//
//        Your Task:
//        You don't need to read input or print anything. Your task is to complete the function countOfSubstrings() which takes a String S and an integer K as input and returns the count of substrings of length K having K-1 distinct characters.
//
//
//        Expected Time Complexity: O(|S|)
//        Expected Auxiliary Space: O(constant)
//
//
//        Constraints:
//        1 ≤ K ≤ |S| ≤ 105

import java.util.Scanner;
import java.util. *;

class Scratch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        int K = sc.nextInt();

        System.out.println(countOfSubstrings(S,K));
    }

    static int countOfSubstrings(String S, int K) {
        // code here
        int n = S.length();
        // System.out.println(n);
        int count=0;
        int i=0,j=K;
        String subst = S.substring(i,j);

        HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
        for(int k=0;k<subst.length();k++){
            char c = subst.charAt(k);
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        if(hm.size()==K-1){
            count++;
        }

        for( i=1,j=K;i<=n-K && j<n;i++,j++)
        {

            char cr = S.charAt(i-1);
            char ci = S.charAt(j);

            int f = hm.get(cr);
            if(f==1){
                hm.remove(cr);
            }else{
                f=f-1;
                hm.put(cr,f);
            }

            if(hm.containsKey(ci)){
                f = hm.get(ci);
                f=f+1;
                hm.put(ci,f);
            }else{
                hm.put(ci,1);
            }

            if(hm.size()==K-1){
                count++;
            }
        }
        return count>0?count:0;
    }
}