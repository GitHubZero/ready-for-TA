import java.util.*;
/*
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


public class removeFib {
    public static ArrayList<Integer> fib (int size) {
        int first = 0;
        int second = 1;
        ArrayList<Integer> fib = new ArrayList<Integer>();
        fib.add(0);
        while(first + second < size) {
            fib.add(first + second);
            int temp = first + second;
            first = second;
            second = temp;
        }
        return fib;
    }
    
    public static void remove(LinkedList list, ArrayList<Integer> fib) {
        int removed = 0;
        for (int i : fib) {
            list.remove(i - removed);
            removed++;
        }
    }
    
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < 36; i++) {
            list.add(i);
        }
        int size = list.size();
        System.out.println(fib(size));
        remove(list, fib(size));
        System.out.println(list);
    }
}