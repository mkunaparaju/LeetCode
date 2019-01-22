package Google.DynamicProgramming;

public class VacationDaysDp {

    public static void main(String[] args) {
        int [][] flights = {{0,1,1},{1,0,1},{1,1,0}}, days = {{1,3,1},{6,0,3},{3,3,3}};
        int [][] flights2 = {{0,0,0},{0,0,0},{0,0,0}}, days2 = {{1,1,1},{7,7,7},{7,7,7}};
        int [][] flights3 = {{0,1,1},{1,0,1},{1,1,0}}, days3 = {{7,0,0},{0,7,7},{7,7,0}};
        int [][] flights4 = {{0,1,0},{0,0,0},{0,0,0}}, days4 = {{0,0,7},{2,0,0},{7,7,7}};

        VacationDaysDp vd = new VacationDaysDp();
        System.out.println(vd.maxVacationDays(flights3, days3));

    }

    public int maxVacationDays(int[][] flights, int[][] days) {

        return maxVacationDays(flights,days, 0, 0);
    }

    private int maxVacationDays(int[][] flights, int[][] days, int week, int currentCity) {
        if(week == days[0].length) return 0;

        int maxVacay = 0;

        for(int i = 0; i < days.length; i++){
            if(flights[currentCity][i] != 0) {
                int vacayDays = days[i][week] + maxVacationDays(flights, days, week+1, i);
                maxVacay = Math.max(maxVacay, vacayDays);

                System.out.println("current city " + currentCity + " week " +week + " i " + i + " vacay " + vacayDays   );
            }
            else if(currentCity == i){
                int vacayDays = days[currentCity][week] + maxVacationDays(flights, days, week+1, currentCity);
                maxVacay = Math.max(maxVacay, vacayDays);
                System.out.println("week " +week + " i " + i + " vacay " + vacayDays   );
            }
        }
        return maxVacay;
    }


}
