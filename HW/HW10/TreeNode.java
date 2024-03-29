package HW.HW10;

import java.util.*;

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> level = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
        {
            return result;
        }
        level.add(root);
        while (!level.isEmpty())
        {
            List<Integer> temp = new ArrayList<Integer>();
            //Need to declare outside because level.size is updated within for loop
            int length = level.size();
            for (int i = 0; i < length; i++)
            {
                //Sets current as the current treenode
                TreeNode current = level.poll();
                temp.add(current.val);
                if (current.left != null)
                {
                    //Add left child to queue
                    level.add(current.left);
                }
                if (current.right != null)
                {
                    //Add right child to queue
                    level.add(current.right);
                }
            }
            result.add(temp);
        }
        return result;
    }
}

        
