//1363. Largest Multiple of Three
//        Hard
//
//        490
//
//        64
//
//        Add to List
//
//        Share
//        Given an array of digits digits, return the largest multiple of three that can be formed by concatenating some of the given digits in any order. If there is no answer return an empty string.
//
//        Since the answer may not fit in an integer data type, return the answer as a string. Note that the returning answer must not contain unnecessary leading zeros.
//
//
//
//        Example 1:
//
//        Input: digits = [8,1,9]
//        Output: "981"
//        Example 2:
//
//        Input: digits = [8,6,7,1,0]
//        Output: "8760"
//        Example 3:
//
//        Input: digits = [1]
//        Output: ""
//
//
//        Constraints:
//
//        1 <= digits.length <= 104
//        0 <= digits[i] <= 9

/*
* Idea
The number is multiple of 3 if and only if the sum of all digits is a multiple of 3
Our goal is to find the maximum number of digits whose sum is a multiple of 3.

Three cases arise:

The sum of digits produces remainder 1 when divided by 3
Delete 1 smallest digit with the remainder = 1 or Delete 2 smallest digits with the remainder = 2
=> Then return the maximum result
The sum of digits produces remainder 2 when divided by 3
Delete 1 smallest digit with the remainder = 2 or Delete 2 smallest digits with the remainder = 1
=> Then return the maximum result
The sum of digits is divisible by 3:
=> Return the maximum result
*  */

import java.util.*;

 class Main {

    public static String getResult(int[] digits, int idx1, int idx2) {
        String res = "";
        for (int j = digits.length - 1; j >= 0; j--) {
            if (j == idx1 || j == idx2) {
                continue;
            } else {
                res = res + digits[j];
            }
        }
        if (res.length() > 0 && res.charAt(0) == '0')
            return "0";

        return res;
    }

    public static String largestMultipleOfThree(int[] digits) {

        int sum = 0;
        for (int d : digits) {
            sum += d;
        }

        Arrays.sort(digits);

        List<Integer> rem1Indxs = new ArrayList<>(2); // Indices of up to 2 elements with remainder = 1
        List<Integer> rem2Indxs = new ArrayList<>(2); // Indices of up to 2 elements with remainder = 2
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] % 3 == 1 && rem1Indxs.size() < 2)
                rem1Indxs.add(i);
            else if (digits[i] % 3 == 2 && rem2Indxs.size() < 2)
                rem2Indxs.add(i);
        }

        if (sum % 3 == 1) { //means digits sum has 1 as extra remainder
            if (rem1Indxs.size() >= 1) {
                return getResult(digits, rem1Indxs.get(0), -1);
            } else {
                return getResult(digits, rem2Indxs.get(0), rem2Indxs.get(1));
            }

        } else if (sum % 3 == 2) { //means digits sum has 2 as extra remainder
            if (rem2Indxs.size() >= 1) {
                return getResult(digits, rem2Indxs.get(0), -1);
            } else {
                return getResult(digits, rem1Indxs.get(0), rem1Indxs.get(1));
            }
        }

        //means digits sum is already a multiple of 3
        return getResult(digits, -1, -1);


    }


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // Write Code here
        int n = scn.nextInt();
        int dig[] = new int[n];
        for (int i = 0; i < n; i++) {
            dig[i] = scn.nextInt();
        }

        System.out.println(largestMultipleOfThree(dig));
        scn.close();
    }
}