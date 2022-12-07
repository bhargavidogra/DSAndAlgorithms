//  A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].
//
//        Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or {) occurs to the left of a closing bracket (i.e., ), ], or }) of the exact same type. There are three types of matched pairs of brackets: [], {}, and ().
//
//        A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. For example, {[(])} is not balanced because the contents in between { and } are not balanced. The pair of square brackets encloses a single, unbalanced opening bracket, (, and the pair of parentheses encloses a single, unbalanced closing square bracket, ].
//
//        By this logic, we say a sequence of brackets is balanced if the following conditions are met:
//
//        It contains no unmatched brackets.
//        The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.
//        Given  strings of brackets, determine whether each sequence of brackets is balanced. If a string is balanced, return YES. Otherwise, return NO.
//
//        Function Description
//
//        Complete the function isBalanced in the editor below.
//
//        isBalanced has the following parameter(s):
//
//        string s: a string of brackets
//        Returns
//
//        string: either YES or NO
//        Input Format
//
//        The first line contains a single integer , the number of strings.
//        Each of the next  lines contains a single string , a sequence of brackets.
//
//        Constraints
//
//        , where  is the length of the sequence.
//        All chracters in the sequences ∈ { {, }, (, ), [, ] }.
//        Output Format
//
//        For each string, return YES or NO.
//
//        Sample Input
//
//        STDIN Function ----- -------- 3 n = 3 {[()]} first s = '{[()]}' {[(])} second s = '{[(])}' {{[[(())]]}} third s ='{{[[(())]]}}'
//
//        Sample Output
//
//        YES
//        NO
//        YES



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
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        // Write your code here
        if(s.length()<=0)
            return "NO";
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            if(c=='{'||c=='['||c=='('){
                st.push(c);
            }else if(c=='}'||c==']'||c==')'){
                if(st.size()<=0){
                    return "NO";
                }
                switch(c){
                    case '}':
                        char ch = st.peek();
                        if(ch!='{'){
                            return "NO";
                        }else{
                            st.pop();
                        }
                        break;

                    case ']':
                        char chr = st.peek();
                        if(chr!='['){
                            return "NO";
                        }else{
                            st.pop();
                        }
                        break;
                    case ')':
                        char chh = st.peek();
                        if(chh!='('){
                            return "NO";
                        }else{
                            st.pop();
                        }
                        break;
                }
            }else{
                return "NO";
            }
        }
        if(st.size()==0)
            return "YES";
        else{
            return "NO";
        }


    }

}

 class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
