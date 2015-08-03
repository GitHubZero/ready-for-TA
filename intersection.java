import java.util.*;

public class intersection {
    public ArrayList<Integer> inter(int[] l1, int[] l2) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (l1 == null || l2 == null) {
            return res;
        }
        int index1 = 0;
        int index2 = 0;
        while (index1 < l1.length && index2 < l2.length) {
            if (l1[index1] == l2[index2]) {
                res.add(l1[index1]);
                index1++;
                index2++;
            }else{
                if(l1[index1] < l2[index2]) {
                    index1++;
                }else{
                    index2++;
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] l1 = {1,2,3,4,5};
        int[] l2 = {1,5,7,9,11,14};
        intersection test = new intersection();
        System.out.println(test.inter(l1, l2));
    }
}