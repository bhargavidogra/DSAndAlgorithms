//. Longest Substring Without Repeating Characters
//        Medium
//
//        30391
//
//        1300
//
//        Add to List
//
//        Share
//        Given a string s, find the length of the longest substring without repeating characters.
//
//
//
//        Example 1:
//
//        Input: s = "abcabcbb"
//        Output: 3
//        Explanation: The answer is "abc", with the length of 3.
//        Example 2:
//
//        Input: s = "bbbbb"
//        Output: 1
//        Explanation: The answer is "b", with the length of 1.
//        Example 3:
//
//        Input: s = "pwwkew"
//        Output: 3
//        Explanation: The answer is "wke", with the length of 3.
//        Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
//
//
//        Constraints:
//
//        0 <= s.length <= 5 * 104
//        s consists of English letters, digits, symbols and spaces.

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans =0;
        HashMap<Character, Integer> map = new  HashMap<Character, Integer>();
        int i=-1,j=-1;

        while(true){
            boolean f1=false,f2=false;
            //acquire
            while(i<s.length()-1){
                i++;
                f1=true;
                char ch= s.charAt(i);
                map.put(ch,map.getOrDefault(ch,0)+1);
                if(map.get(ch)==2){
                    break;
                }else{
                    int len = i-j;
                    if(len>ans){
                        ans= len;
                    }
                }
            }
            //release
            while(j<i){
                j++;
                f2=true;
                char ch =s.charAt(j);
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==1){
                    break;
                }
            }

            if(f1==false && f2==false){
                break;
            }

        }
        return ans;
    }
}