//Count Distinct Subsequences
//        Easy  Prev   Next
//        1. You are given a string.
//        2. You have to print the count of distinct and non-empty subsequences of the given string.
//
//        Note -> String contains only lowercase letters.
//
//        Sample Input
//        abc
//        Sample Output
//        7


import java.util.*;


 class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int l = str.length();

        long dp[] = new long[l + 1];
        dp[0] = 1;
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 1; i < l + 1; i++) {
            dp[i] = 2 * dp[i - 1];

            char c = str.charAt(i - 1);
            if (hm.containsKey(c)) {
                int j = hm.get(c);
                dp[i] = dp[i] - dp[j - 1];
            }
            hm.put(c, i);
        }

        System.out.println(dp[l] - 1);

    }
}