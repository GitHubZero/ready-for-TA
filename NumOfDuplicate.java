class NumOfDuplicate {
    public int getNum1 (TreeNode root, TreeNode pre) {
        int duplicate = 0;
        if (root == null) {
            return duplicate;
        }
        if (root != pre && root.val == pre.val) {
            duplicate++;
        }
        duplicate += getNum(root.left, root);
        duplicate += getNum(root.right, root);
        return duplicate;
    }
    
    
    public static List<Integer> inorder (TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode cur = root;
        while(true) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            if (s.isEmpty()) {
                break;
            }
            cur = s.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
    
    public static int checkDup(ArrayList<Integer> list) {
        int size = list.size();
        int duplicate = 0;
        for (int i = 1; i < size; i++) {
            if (list.get(i) == list.get(i - 1)) {
                duplicate++;
            }
        }
        return duplicate;
    }
    
    public int getNum2(TreeNode root) {
        int res = checkDup(inorder(root));
        return res;
    }
}