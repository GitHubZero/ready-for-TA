import java.util.*;

public class MinimumCoin {
    public int min (int[] coins, int target) {
        int count = 0;
        Arrays.sort(coins);
        for (int i = coins.length - 1; i >= 0; i--) {
            count += target / coins[i];
            target = target % coins[i];
        }
        return count;
    }
    public static void main(String[] args) {
        int[] coins = {1,5,10};
        int target = 96;
        MinimumCoin test = new MinimumCoin();
        System.out.println(test.min(coins, target));
    }
}