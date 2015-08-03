import java.util.*;
public class palindromDate {
    public int paDtate() {
        int count = 0;
        for(int m = 1; m <= 12; m++) {
            for (int d = 1; d < 31; d++) {
                StringBuilder item = new StringBuilder();
                System.out.println("in main!");
                if (m < 10) {
                    item.append("0" + m);
                }else{
                    item.append(m);
                }
                if (d < 10) {
                    item.append("0" + d);
                }else{
                    item.append(d);
                }
                if (m < 10) {
                    item.append(m + "0");
                }else{
                    item.append(swap(m));
                }
                if (checkPa(item.toString())) {
                    count++;
                    System.out.println("running" + count);
                }
            }
        }
        return count;
    }
    
    private static String swap(int n) {
        int temp = n % 10;
        if (temp == 0) {
            return "01";
        }else{
            return "" + (temp * 10 + 1);
        }
    }
    
    private static boolean checkPa(String item) {
        int left = 0;
        int right = item.length() - 1;
        while (left < right) {
            if (item.charAt(left) != item.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    public static void main(String[] args) {
        palindromDate test = new palindromDate();
        System.out.println("in main!");
        System.out.println (test.paDtate());
    }
}