

public class DepthOfRandomNode {
    public int getDepth(TreeNode root, TreeNode target) {
        return helper(root, target, 0);
    }
    private static int helper(TreeNode root, TreeNode target, int level) {
        if (root == null) {
            return 0;
        }
        if (root.val == target.val) {
            return level + 1;
        }
        int left = helper(root.left, target, level + 1);
        int right = helper(root.right, target, level + 1);
        if (left != 0) {
            return left;
        }else if(right != 0) {
            return right;
        }else{
            return 0;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);
        TreeNode left21 = new TreeNode(4);
        TreeNode left22 = new TreeNode(5);
        TreeNode right21 = new TreeNode(6);
        TreeNode right22 = new TreeNode(7);
        root.left = left1;
        root.right = right1;
        left1.left = left21;
        left1.right = right21;
        right1.left = left22;
        right1.right = right22;
        DepthOfRandomNode test = new DepthOfRandomNode();
        System.out.println(test.getDepth(root,root));
    }
}