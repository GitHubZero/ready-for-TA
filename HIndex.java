import java.util.*;

public class HIndex {
    public int cal (int[] arr) {
        if (arr == null || arr.length ==0) {
            return 0;
        }
        int[] count = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            count[Math.min(arr[i], arr.length)]++;
        }
        int sum = 0;
        for (int i = count.length - 1; i >= 0; i--) {
            sum += count[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] input = {0,3,4,5,8,9,10,6};
        HIndex test = new HIndex();
        System.out.println(test.cal(input));
    }
}