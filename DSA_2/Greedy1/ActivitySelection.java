import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {

    /* 
    * Given N activities with Start & End times,
    * At a time only onee activity can be preferred.
    * 
    * Maximize the number of activities that can be performed.
    * 
    */

    public static int maxActivities(int start[], int end[]) {
        int n = start.length;

        int[][] activities = new int[n][2];
        for (int i = 0; i < n; i++) {
            activities[i][0] = start[i];
            activities[i][1] = end[i];
        }

        Arrays.sort(activities, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });

        System.out.println(Arrays.deepToString(activities));

        int count = 1;
        int end_time = activities[0][1];

        for (int i = 1; i < n; i++) {
            if (activities[i][0] >= end_time) {
                System.out.println(Arrays.toString(activities[i]));
                count++;
                end_time = activities[i][1];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int start[] = { 1, 3, 0, 8, 5, 5 };
        int end[] = { 2, 4, 6, 9, 7, 9 };
        System.out.println("Maximum No. of Activities Possible: " + maxActivities(start, end));
    }
}