import java.util.*;
public class pr9 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Number of Coins: ");
        int n = sc.nextInt();

        int coins[] = new int[n];

        System.out.println("Enter the coin denominations:");
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        System.out.print("Enter the target: ");
        int target = sc.nextInt();

        int minCoins[] = new int[target + 1];
        Arrays.fill(minCoins, target + 1);
        minCoins[0] = 0;

        for (int amount = 1; amount <= target; amount++) {
            for (int coin : coins) {
                if (coin <= amount) {
                    minCoins[amount] = Math.min(minCoins[amount], minCoins[amount - coin] + 1);
                }
            }
        }

        if (minCoins[target] > target) {
            System.out.println("Cannot make " + target + " with given coins");
        } else {
            System.out.println("Min coins to make " + target + " = " + minCoins[target]);
        }

        sc.close();
    }
}
