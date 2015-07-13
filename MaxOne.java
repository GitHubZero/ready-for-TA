/* given an array contains only 0s and 1s. You need to pick index i and j,
 * and change 1 to 0, 0 to 1 in substring(i, j + 1).
 * find out the value of i and j that makes array contains most 1s.
 * or return the maximum value of number of 1s.
 */

public class MaxOne {
    public int find(int[] input) {
        if (input == null || input.length == 0) {
            return 0;
        }
        int res = 0;
        //Check if input contains only 1;
        boolean allOne = true;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == 0) {
                allOne = false;
                break;
            }
        }
        if (allOne == true) {
            return input.length;
        }
        //
        int counter[] = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            counter[i] = (input[i] == 1 ? 1 : 0) + (i == 0 ? 0 : counter[i - 1]);
        }
        int keepMax[] = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            keepMax[i] = Integer.MAX_VALUE;
        }
        //most 1s at i, j, counter[i - 1] + (j - i + 1 - (counter[j] - counter[i - 1])) + counter[input.length - 1] - counter[j]
        //j - i - 2counter[j] + counter[i - 1] + counter[input.length - 1]
        for (int i = 1; i < input.length; i++) {
            keepMax[i] = Math.min(keepMax[i - 1], i - 2 * counter[i - 1]);
        }
        for (int j = 1; j < input.length; j++) {
            int val = j + 1 - 2 * counter[j] + counter[input.length - 1];
            val = Math.max(val, j - 2 * counter[j] - keepMax[j] + counter[input.length - 1] + 1);
            res = Math.max(res, val);
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] input = {1,1,1,1,0,0,0,1,0,0,1,1};
        MaxOne res = new MaxOne();
        System.out.println(res.find(input));
    }
}