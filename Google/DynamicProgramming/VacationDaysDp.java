package Google.DynamicProgramming;

import java.util.Arrays;

public class VacationDaysDp {

    public static void main(String[] args) {
        int[][] flights = {{0, 1, 1}, {1, 0, 1}, {1, 1, 0}}, days = {{1, 3, 1}, {6, 0, 3}, {3, 3, 3}};
        int[][] flights2 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, days2 = {{1, 1, 1}, {7, 7, 7}, {7, 7, 7}};
        int[][] flights3 = {{0, 1, 1}, {1, 0, 1}, {1, 1, 0}}, days3 = {{7, 0, 0}, {0, 7, 7}, {7, 7, 0}};
        int[][] flights4 = {{0, 1, 0}, {0, 0, 0}, {0, 0, 0}}, days4 = {{0, 0, 7}, {2, 0, 0}, {7, 7, 7}};

        VacationDaysDp vd = new VacationDaysDp();
        System.out.println(vd.maxVacationDaysDp(flights, days));

    }

    public int maxVacationDays(int[][] flights, int[][] days) {

        int[][] memo = new int[days[0].length][days.length];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return maxVacationDays(flights, days, 0, 0, memo);
    }

    private int maxVacationDays(int[][] flights, int[][] days, int week, int currentCity, int[][] memo) {
        if (week == days[0].length) return 0;
        if (memo[week][currentCity] != -1) return memo[week][currentCity];
        int maxVacay = 0;

        for (int i = 0; i < days.length; i++) {
            if (flights[currentCity][i] != 0) {
                int vacayDays = days[i][week] + maxVacationDays(flights, days, week + 1, i, memo);
                maxVacay = Math.max(maxVacay, vacayDays);

//                System.out.println("current city " + currentCity + " week " +week + " i " + i + " vacay " + vacayDays   );
            } else if (currentCity == i) {
                int vacayDays = days[currentCity][week] + maxVacationDays(flights, days, week + 1, currentCity, memo);
                maxVacay = Math.max(maxVacay, vacayDays);
//                System.out.println("week " +week + " i " + i + " vacay " + vacayDays   );
            }
        }
        memo[week][currentCity] = maxVacay;
        return maxVacay;
    }

    private int maxVacationDaysDp(int[][] flights, int[][] days) {
        int[] dp = new int[days.length];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 0; i < days[0].length; i++) {
            int[] temp = new int[dp.length];
            Arrays.fill(temp, -1);
            for (int j = 0; j < days.length; j++) {
                for (int k = 0; k < days.length; k++) {
                    if (flights[j][k] == 1 || j == k) {
                        temp[j] = Math.max(temp[j], dp[k] + days[j][i]);
                    }
                }
            }
            dp = temp;
        }
        int max = 0;
        for (int m : dp) {
            max = Math.max(m, max);
        }
        return max;
    }


}
