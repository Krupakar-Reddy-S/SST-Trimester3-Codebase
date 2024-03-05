import java.util.Arrays;

public class JobScheduling {

    /* 
     *      
     * 
    */

    public static int jobScheduling(int[] work, int[] profit) {
        int n = work.length;
        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(work[i], profit[i]);
        }

        Arrays.sort(jobs, (job1, job2) -> Integer.compare(job2.profit, job1.profit));

        boolean[] slot = new boolean[n];

        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            for (int j = Math.min(n, jobs[i].deadline) - 1; j >= 0; j--) {
                if (!slot[j]) {
                    slot[j] = true;
                    maxProfit += jobs[i].profit;
                    break;
                }
            }
        }

        return maxProfit;
    }

    private static class Job {
        int deadline;
        int profit;

        Job(int deadline, int profit) {
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {
        int work[] = { 2, 1, 2, 1, 3 };
        int profit[] = { 100, 19, 27, 25, 15 };

        System.out.println(jobScheduling(work, profit));
    }
}
