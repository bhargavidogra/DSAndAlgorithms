//983. Minimum Cost For Tickets
//        Medium
//
//        5323
//
//        91
//
//        Add to List
//
//        Share
//        You have planned some train traveling one year in advance. The days of the year in which you will travel are given as an integer array days. Each day is an integer from 1 to 365.
//
//        Train tickets are sold in three different ways:
//
//        a 1-day pass is sold for costs[0] dollars,
//        a 7-day pass is sold for costs[1] dollars, and
//        a 30-day pass is sold for costs[2] dollars.
//        The passes allow that many days of consecutive travel.
//
//        For example, if we get a 7-day pass on day 2, then we can travel for 7 days: 2, 3, 4, 5, 6, 7, and 8.
//        Return the minimum number of dollars you need to travel every day in the given list of days.
//
//
//
//        Example 1:
//
//        Input: days = [1,4,6,7,8,20], costs = [2,7,15]
//        Output: 11
//        Explanation: For example, here is one way to buy passes that lets you travel your travel plan:
//        On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
//        On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
//        On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
//        In total, you spent $11 and covered all the days of your travel.
//        Example 2:
//
//        Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
//        Output: 17
//        Explanation: For example, here is one way to buy passes that lets you travel your travel plan:
//        On day 1, you bought a 30-day pass for costs[2] = $15 which covered days 1, 2, ..., 30.
//        On day 31, you bought a 1-day pass for costs[0] = $2 which covered day 31.
//        In total, you spent $17 and covered all the days of your travel.
//
//
//        Constraints:
//
//        1 <= days.length <= 365
//        1 <= days[i] <= 365
//        days is in strictly increasing order.
//        costs.length == 3
//        1 <= costs[i] <= 1000

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] days = new int[n];
        for (int i = 0; i < n; i++) {
            days[i] = scn.nextInt();
        }
        int[] costs = new int[3];
        for (int i = 0; i < 3; i++) {
            costs[i] = scn.nextInt();
        }
        Arrays.sort(days);
        System.out.println(mincostTickets(days, costs));
    }

    public static int mincostTickets(int[] days, int[] costs) {

        int dp[] = new int[400]; // as no of days is 365

        for (int i = 399; i >= 0; i--) {
            if (i > days[days.length - 1]) {
                dp[i] = 0;
                continue;
            }

            int min = Integer.MAX_VALUE;

            if (willITravelToday(i, days)) {
                min = dp[i + 1] + costs[0];
                min = Math.min(min, dp[i + 7] + costs[1]);
                min = Math.min(min, dp[i + 30] + costs[2]);
            } else {
                min = dp[i + 1];
            }

            dp[i] = min;
        }
        return dp[0];

    }

    public static boolean willITravelToday(int day, int days[]) {
        for (int i = 0; i < days.length; i++) {
            if (days[i] == day) {
                return true;
            }
        }
        return false;
    }

    public static int mincostTickets1(int[] days, int[] costs) {
        //Write your code here

        int fixed_days[] = new int[3];

        fixed_days[0] = 1;
        fixed_days[1] = 7;
        fixed_days[2] = 30;
        //maximum day to travel
        int mday = Integer.MIN_VALUE;
        for (int day : days) {
            mday = Math.max(mday, day);
        }

        //minimum cost to be given provied you are travelling on needed day
        int dp[] = new int[mday + 1];
        boolean tdays[] = new boolean[mday + 1];
        //mark travel days to be true
        for (int day : days) {
            tdays[day] = true;
        }

        dp[0] = 0;
        for (int i = 1; i < mday + 1; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < costs.length; j++) {
                int val = 0;
                if (tdays[i]) {
                    if (i - fixed_days[j] >= 0) {
                        val = costs[j] + dp[i - fixed_days[j]];
                    } else {
                        val = costs[j];
                    }
                } else {
                    val = dp[i - 1];
                }

                min = Math.min(min, val);
            }
            dp[i] = min;
        }


        return dp[mday];
    }
}