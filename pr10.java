import java.util.*;
public class pr10 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Number of items: ");
        int n = sc.nextInt();

        int weights[] = new int[n];
        int values[] = new int[n];

        System.out.println("Enter the weight and value for each item:");
        for (int i = 0; i < n; i++) {
            System.out.print("Item " + (i + 1) + " weight: ");
            weights[i] = sc.nextInt();
            System.out.print("Item " + (i + 1) + " value: ");
            values[i] = sc.nextInt();
        }

        System.out.print("Enter the Maximum Capacity of the knapsack: ");
        int capacity = sc.nextInt();

        int dp[][] = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                dp[i][w] = dp[i - 1][w];
                if (weights[i - 1] <= w) {
                    int withItem = dp[i - 1][w - weights[i - 1]] + values[i - 1];
                    dp[i][w] = Math.max(dp[i][w], withItem);
                }
            }
        }

        System.out.println("Maximum Value = " + dp[n][capacity]);
        sc.close();
    }
}
