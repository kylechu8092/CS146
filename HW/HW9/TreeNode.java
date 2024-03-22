package HW.HW9;
import java.util.*;

import javax.lang.model.util.ElementScanner14;

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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //Solves the case of nodes right and left
        if (root.val < p.val && root.val < q.val)
        {
            //Right subtree
            return lowestCommonAncestor(root.right, p, q);
        }
        else if (root.val > p.val && root.val > q.val)
        {
            //Left subtree
            return lowestCommonAncestor(root.left, p, q);
        }
        else{
            return root;
        }
        
    }

    }
