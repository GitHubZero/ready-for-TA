import java.util.*;

public class reconstruct {
    public TreeNode reConstructer(ArrayList<Integer> input, int start, int end) {
    if (input == null || input.size() == 0) {
        return null;
    }
    if (end <= start) {
        return new TreeNode(input.get(start));
    }
    TreeNode root = new TreeNode(input.get(start));
    int divid = start + 1;
    for (; divid < end; divid++) {
        if (input.get(divid) >= input.get(start)) {
            break;
        }
    }
    root.left = reConstructer(input, start + 1, divid - 1);
    root.right = reConstructer(input, divid, end);
    return root;
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<Integer>();
        input.add(5);
        input.add(1);
        input.add(3);
        input.add(4);
        input.add(6);
        input.add(7);
        reconstruct test = new reconstruct();
        test.reConstructer(input, 0, 5);
    }
}