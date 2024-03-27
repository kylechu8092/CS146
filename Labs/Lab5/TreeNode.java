package Lab.Lab5;


public class TreeNode {
    int val;
     TreeNode left;

     TreeNode right;

     TreeNode() {}

     TreeNode(int val) { this.val = val; }

     TreeNode(int val, TreeNode left, TreeNode right) {

         this.val = val;

         this.left = left;

         this.right = right;
     }

     public boolean isValidBST(TreeNode root) {
        //One node
        if (root.left == null || root.right == null)
        {
            return true;
        }
       return check(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public boolean check(TreeNode root, int upper, int lower)
    {
        //Base case, if nothing is wrong on our left and right side
        if (root == null)
        {
            return true;
        }
        if (root.val >= upper || root.val <= lower)
        {
            return false;
        }
        return check(root.left, root.val, lower) && check(root.right, upper, root.val);

    }

}
