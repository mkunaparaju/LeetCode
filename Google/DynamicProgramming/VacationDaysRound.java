package Google.DynamicProgramming;

import java.awt.image.AreaAveragingScaleFilter;
import java.lang.management.ManagementFactory;
import java.nio.channels.FileLock;
import java.util.Arrays;

public class VacationDaysRound {

    public static void main(String[] args) {
        int[][] flights = {{0, 1, 1}, {1, 0, 1}, {1, 1, 0}}, days = {{1, 3, 1}, {6, 0, 3}, {3, 3, 3}};
        int[][] flights2 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, days2 = {{1, 1, 1}, {7, 7, 7}, {7, 7, 7}};
        int[][] flights3 = {{0, 1, 1}, {1, 0, 1}, {1, 1, 0}}, days3 = {{7, 0, 0}, {0, 7, 7}, {7, 7, 0}};
        int[][] flights4 = {{0, 1, 0}, {0, 0, 0}, {0, 0, 0}}, days4 = {{0, 0, 7}, {2, 0, 0}, {7, 7, 7}};

        VacationDaysRound vdr = new VacationDaysRound();
        System.out.println(vdr.maxVacationDays(flights3, days3));
    }
    private int [][] memo;
    public int maxVacationDays(int[][] flights, int[][] days) {
        memo = new int [days.length][days[0].length];
        for(int i []  : memo) Arrays.fill(i, -1);

        return maxVacationDays(flights, days, 0, 0);
    }


    private int maxVacationDays(int[][] flights, int[][] days, int currentCity, int week) {
        if(currentCity == days.length || week == days[0].length) return 0;
        if (memo[currentCity][week] != -1) return memo[currentCity][week];
        int vacayDays = 0;

        //possible destinations
        for (int i = 0; i < days.length; i++) {
            // checking flights to that destination city
            if (flights[currentCity][i] != 0) {
                vacayDays = Math.max(vacayDays, days[i][week] + maxVacationDays(flights, days, i, week + 1));
            } else if (currentCity == i) {
                vacayDays = Math.max(vacayDays, days[i][week] + maxVacationDays(flights, days, currentCity,week+1));
            }
//            System.out.println(vacayDays);
        }
        memo[currentCity][week] = vacayDays;
        return vacayDays;
    }

//    public int maxVacationDaysDP(int [][] flights, int [][] days){
//
//    }
}
