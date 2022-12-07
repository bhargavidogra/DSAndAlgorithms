//Highest Frequency Character
//        1. You are given a string str.
//        2. You are required to find the character with maximum frequency.
//
//Input:
//        zmszeqxllzvheqwrofgcuntypejcxovtaqbnqyqlmrwitc
//Output:
//        q

import java.io.*;
import java.util.*;

 class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        HashMap<Character, Integer> hm = new HashMap<>();

        for(int i=0;i<str.length() ;i++){
            char ch= str.charAt(i);
            if(hm.containsKey(ch)){
                int of= hm.get(ch);
                int nf=of+1;
                hm.put(ch,nf);
            }else{
                hm.put(ch,1);
            }
        }

        Set<Character> keys= hm.keySet();
        int max=hm.get(str.charAt(0));
        char c=str.charAt(0);
        for(char ch:keys){
            if(hm.get(ch)>max){
                max=hm.get(ch);
                c=ch;
            }

        }
        System.out.println(c);
    }

}