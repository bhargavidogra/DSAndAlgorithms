//Sample 1 :
//       input:
//        abc
//
//        OUTPUT:
//        Number of SUBSEQUENCES (2^n) : 8
//        abc
//        ab
//        ac
//        a
//        bc
//        b
//        c
//
//        Number of SUBSTRING [ (n*(n+1))/2 ] : 6
//        a
//        ab
//        abc
//        b
//        bc
//        c
//
//
//        Sample 2 :
//Input:
//                abcde
//
// OUTPUT:
//
//        Number of SUBSEQUENCES (2^n) : 32
//        abcde
//        abcd
//        abce
//        abc
//        abde
//        abd
//        abe
//        ab
//        acde
//        acd
//        ace
//        ac
//        ade
//        ad
//        ae
//        a
//        bcde
//        bcd
//        bce
//        bc
//        bde
//        bd
//        be
//        b
//        cde
//        cd
//        ce
//        c
//        de
//        d
//        e
//
//        Number of SUBSTRING [ (n*(n+1))/2 ] : 15
//        a
//        ab
//        abc
//        abcd
//        abcde
//        b
//        bc
//        bcd
//        bcde
//        c
//        cd
//        cde
//        d
//        de
//        e


import java.util.Scanner;
import java.util.*;
class Scratch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.next();
        ArrayList<String> subsequences= getSubsequences(st);
        ArrayList<String> substring= getSubstrings(st);
        System.out.println("Number of SUBSEQUENCES (2^n) : "+subsequences.size());
        printresult(subsequences);
        System.out.println("Number of SUBSTRING [ (n*(n+1))/2 ] : "+substring.size());
        printresult(substring);
        System.out.println("Number of SUBSEQUENCES (2^n) : "+subsequences.size());
        printSubsequence(st,"");
        System.out.println("Number of SUBSTRING [ (n*(n+1))/2 ] : "+substring.size());
        printSubString(st);
    }

    public static void printSubsequence(String ques, String ans){
        if(ques.length()==0){
            System.out.println(ans);
            return;
        }

        char ch = ques.charAt(0);
        String ros = ques.substring(1);
        printSubsequence(ros,ans+ch);
        printSubsequence(ros,ans+"");

    }

    public static void printSubString(String ques){
        if (ques.length() == 1) {
            System.out.println(ques);
            return;
        }else{
            System.out.println(ques);
            printSubString(ques.substring(0, ques.length()-1));
            printSubString(ques.substring(1, ques.length()));
        }

    }

    public static ArrayList<String> getSubstrings(String str){

        if(str.length()==1){
            ArrayList<String> bl = new ArrayList<>();
            bl.add(str);
            return bl;
        }

        ArrayList<String> res = getSubstrings(str.substring(1));
        ArrayList<String> ml = new ArrayList<>();
        char ch0 = str.charAt(0);
        char ch1 = str.charAt(1);
        ml.add(""+ch0);
        for(String s : res){
            char chex = s.charAt(0);
            if(chex==ch1){
                ml.add(ch0+s);
            }
        }
        for(String s: res){
            ml.add(s);
        }
        return ml;
    }

    public  static ArrayList<String> getSubsequences(String str){
        if(str.length()==0){
            ArrayList<String> bl = new ArrayList<>();
            bl.add("");
            return bl;
        }

        ArrayList<String> res = getSubsequences(str.substring(1));
        ArrayList<String> ml = new ArrayList<>();
        char ch = str.charAt(0);
        for(String s: res){
            ml.add(ch+s);
        }
        for(String s: res){
            ml.add(""+s);
        }
        return ml;
    }


    public static void printresult(ArrayList<String> ss){
        for(String s: ss)
        {
            System.out.println(s);
        }
    }
}