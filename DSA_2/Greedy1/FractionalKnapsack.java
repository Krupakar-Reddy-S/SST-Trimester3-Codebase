import java.util.Arrays;

public class FractionalKnapsack {

    /* 
     * You have a bag (Knapsack) which has a weight capacity of "W",
     * Given N items, where each item has a cost and a weight,
     * 
     * Pick items to maximize the value of the bag.
     * Fractional Knapsack allows you to take fractions of an item.
     * 
     * If Fractional Knapsack is not allowed, then we wil have to
     * find all possible combinations of items and then pick the best one. (Dynamic Programming)
     * 
     * But here we can take fractions of an item, so we can use Greedy Algorithm.
     * i.e. maximize per unit cost of an item and select from the array sorted,
     * use a custom comparator for sorting based on our logic.
     * 
    */

    // TC = O(NlogN), SC = O(N) [N = number of items]
    public static int fractionalKnapsack(int[] weight, int[] value, int W) {
        int n = weight.length;
        double[] cost = new double[n];

        for (int i = 0; i < n; i++) {
            cost[i] = (double) value[i] / weight[i];
        }

        Integer[] index = new Integer[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }

        Arrays.sort(index, (a, b) -> Double.compare(cost[b], cost[a]));

        int currentWeight = 0;
        double finalValue = 0.0;

        for (int i = 0; i < n; i++) {
            if (currentWeight + weight[index[i]] <= W) {
                currentWeight += weight[index[i]];
                finalValue += value[index[i]];
            } 
            else {
                int remainingWeight = W - currentWeight;
                finalValue += cost[index[i]] * remainingWeight;
                break;
            }
        }

        return (int) finalValue;
    }

    public static void main(String[] args) {
        int W = 50;
        int[] weight = {10, 20, 30};
        int[] value = {60, 100, 120};

        System.out.println(fractionalKnapsack(weight, value, W));
    }
}
