package Google.DynamicProgramming;

public class VacationDays {

    public static void main(String[] args) {
        int[][] flights = {{0, 1, 1}, {1, 0, 1}, {1, 1, 0}}, days = {{1, 3, 1}, {6, 0, 3}, {3, 3, 3}};
        int[][] flights2 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, days2 = {{1, 1, 1}, {7, 7, 7}, {7, 7, 7}};
        int[][] flights3 = {{0, 1, 1}, {1, 0, 1}, {1, 1, 0}}, days3 = {{7, 0, 0}, {0, 7, 7}, {7, 7, 0}};
        int[][] flights4 = {{0, 1, 0}, {0, 0, 0}, {0, 0, 0}}, days4 = {{0, 0, 7}, {2, 0, 0}, {7, 7, 7}};

        VacationDays vd = new VacationDays();
        System.out.println(vd.maxVacationDays(flights4, days4));
    }

    public int maxVacationDays(int[][] flights, int[][] days) {
        int vacayCount = 0;
        int currentCity = 0;

        for (int i = 0; i < days[0].length; i++) {

            int maxVacayInWeek = 0;
            int destinationCity = 0;

            for (int j = 0; j < days.length; j++) {
                if (flights[currentCity][j] != 0 || currentCity == j) {
                    if (days[j][i] > maxVacayInWeek) {
                        maxVacayInWeek = days[j][i];
                        destinationCity = j;
                        currentCity = destinationCity;
                    }
                }
            }
            vacayCount += maxVacayInWeek;

            // System.out.println("vacayCount " + vacayCount);
        }
        return vacayCount;
    }

}
