package ExtraCredit.selfBalancingTree;

import javax.lang.model.util.ElementScanner14;

public class TreeNode {
    int val;
    TreeNode root;
    TreeNode left;
    TreeNode right;
    boolean color;
    TreeNode parent;
    static final boolean RED = false;
    static final boolean BLACK = true;
    TreeNode() {}

    TreeNode(int val) { this.val = val; }

    TreeNode(int val, TreeNode left, TreeNode right) {

        this.val = val;
        this.left = left;
        this.right = right;

    }

    public void rotateRight(TreeNode n)
    {
        TreeNode parent = n.parent;
        TreeNode leftChild = n.left;

        n.left = leftChild.right;
        if (leftChild.right != null)
        {
            leftChild.right.parent = n;
        }

        leftChild.right = n;
        n.parent = leftChild;

        replaceParentsChild(parent, n, leftChild);
    }

    public void rotateLeft(TreeNode n)
    {
        TreeNode parent = n.parent;
        TreeNode rightChild = n.right;

        n.right = rightChild.left;
        if (rightChild.right != null)
        {
            rightChild.left.parent = n;
        }

        rightChild.left = n;
        n.parent = rightChild;

        replaceParentsChild(parent, n, rightChild);
    }

    public void replaceParentsChild(TreeNode parent, TreeNode oldChild, TreeNode newChild)
    {
        if (parent == null)
        {
            root = newChild;
        }
        else if (parent.left == oldChild) 
        {
            parent.left = newChild;
        } 
        else if (parent.right == oldChild) 
        {
            parent.right = newChild;
        }
        if (newChild != null)
        {
            newChild.parent = parent;
        }
    }

    public TreeNode findMin(TreeNode n)
    {
        while (n.left != null)
        {
            n = n.left;
        }
        return n;
    }

    public TreeNode getSibling(TreeNode n)
    {
        TreeNode parent = n.parent;
        if (n == parent.left)
        {
            return parent.right;
        }
        else 
        {
            return parent.left;
        }
    }

    //Simple BST traversal
    public TreeNode traversal(int key)
    {
        TreeNode curr = root;
        while (curr != null)
        {
            if (curr.val == key)
            {
                return curr;
            }
            else if (key < curr.val)
            {
                curr = curr.left;
            }
            else 
            {
                curr = curr.right;
            }
        }
        return null;
    }

    public TreeNode getUncle(TreeNode parent) {
        TreeNode grandparent = parent.parent;
        if (grandparent.left == parent) 
        {
          return grandparent.right;
        } 
        else
        {
          return grandparent.left;
        }
    }

    public void insertNode(int key)
    {
        TreeNode curr = root;
        TreeNode parent = null;

        while (curr != null)
        {
            parent = curr;
            if (key < curr.val)
            {
                curr = curr.left;
            }
            else 
            {
                curr = curr.right;
            }
        }

        //Found where we want to insert
        TreeNode newNode = new TreeNode(key);
        newNode.color = RED;
        if (parent == null)
        {
            root = newNode;
        }
        else if (key < parent.val)
        {
            parent.left = newNode;
        }
        else 
        {
            parent.right = newNode;
        }
        newNode.parent = parent;
        fixRedBlackPropertiesAfterInsert(newNode);
    }

    public void fixRedBlackPropertiesAfterInsert(TreeNode n)
    {
        TreeNode parent = n.parent;

        //Case: If at root set as black
        if (parent == null)
        {
            n.color = BLACK;
            return;
        }

        //Satisfies rules
        if (parent.color == BLACK)
        {
            return;
        }

        //Now parent is red
        TreeNode grandparent = parent.parent;
        
        //If parent is root
        if (grandparent == null)
        {
            parent.color = BLACK;
            return;
        }

        TreeNode uncle = getUncle(parent);

        //Case where uncle is red
        if (uncle != null && uncle.color == RED)
        {
            parent.color = BLACK;
            grandparent.color = RED;
            uncle.color = BLACK;
             //Must fix again becaues grandparent is red, who could have red parent or be root
            fixRedBlackPropertiesAfterInsert(grandparent);
        }
        else if (parent == grandparent.left)
        {
            //If we are at right left
            if (n == parent.right)
            {
                rotateLeft(parent);
                parent = n;
            }
            //If uncle is black and n is left left
            rotateLeft(grandparent);
            parent.color = BLACK;
            grandparent.color = RED;
        }
        else //parnet is right child of grandparent
        {
            //If uncle is black and n is right left
            if (n == parent.left)
            {
                rotateRight(parent);
                parent = n;
            }
            //If uncle is black and node is right right
            rotateLeft(grandparent);
            parent.color = BLACK;
            grandparent.color = RED;
        }
    } //INSERTION DONE

    


    public void deleteNode(int key)
    {
        TreeNode curr = root;
        while (curr != null && curr.val != key)
        {
            if (key < curr.val)
            {
              curr = curr.left;
            }
             else
             {
            curr = curr.right;
            }
        }
        //if not found
        if (curr == null)
        {
            return;
        }
        TreeNode movedUp;
        boolean deletedNodeColor;

        //One child
        if (curr.left == null || curr.right == null)
        {
            movedUp = deleteNodeWithZeroOrOneChild(curr);
            deletedNodeColor = curr.color;
        }
        else //2 children
        {
            TreeNode inOrderSuccessor = findMin(curr.right);
            curr.val = inOrderSuccessor.val;
            
            //Delete inorder successor
            movedUp = deleteNodeWithZeroOrOneChild(inOrderSuccessor);
            deletedNodeColor = inOrderSuccessor.color;
        } 
        if (deletedNodeColor == BLACK)
        {
            //Removes the temp node
            fixRedBlackPropertiesAfterInsert(movedUp);
            if (movedUp == null)
            {
                replaceParentsChild(movedUp.parent, movedUp, null);
            }
        }
    }

    public TreeNode deleteNodeWithZeroOrOneChild(TreeNode n)
    {
        //If it only has a left, replace left
        if (n.left != null)
        {
            replaceParentsChild(n.parent, n, n.left);
            return n.left;
        }
        else if (n.right != null)
        {
            //If only right
            replaceParentsChild(n.parent, n, n.right);
            return n.right;

        }
        //If no children
        else
        {
            TreeNode newChild = new TreeNode();
            if (n.color == BLACK)
            {
                replaceParentsChild(n.parent, n, newChild);
            }
            return newChild;
        }
    }
    
    public void fixRedBlackPropertiesAfterDelete(TreeNode n)
    {
        //If node is root
        if (n == root)
        {
            return;
        }
        TreeNode sibling = getSibling(n);

        //Case: sibling is red
        if (sibling.color == RED)
        {
            handleRedSibling(n, sibling);
            sibling = getSibling(n);
        }

        //Case if black sibling w two black
        if (sibling.left.color == BLACK && sibling.right.color == BLACK)
        {
            sibling.color = RED;
            //If parent is red change to black
            if (n.parent.color == RED)
            {
                n.parent.color = BLACK;
            }
            else
            {
                fixRedBlackPropertiesAfterDelete(n.parent);
            }
        }
        else
        {
            handleBlackSiblingWithAtleastOneRedChild(n, sibling);
        }
    }
    public void handleRedSibling(TreeNode n, TreeNode sibling)
    {
        //REcolor
        sibling.color = BLACK;
        n.parent.color = RED;

        //Rotate based on where n is 
        if (n == n.parent.left)
        {
            rotateLeft(n.parent);
        }
        else
        {
            rotateRight(n.parent);
        }
    }

    public void handleBlackSiblingWithAtleastOneRedChild(TreeNode n, TreeNode sibling)
    {
        //See where n is
        boolean nodeIsLeftChild = (n == n.parent.left);
        //Black sibling so recolor sibling and child, rotate
        if (nodeIsLeftChild && sibling.right.color == BLACK)
        {
            sibling.left.color = BLACK;
            sibling.color = RED;
            rotateRight(sibling);
            sibling = n.parent.right;
        }
        else if (!nodeIsLeftChild && sibling.left.color == BLACK)
        {
            sibling.right.color = BLACK;
            sibling.color = RED;
            rotateLeft(sibling);
            sibling = n.parent.left;
        }

        //If black sibling with at least one red child

        sibling.color = n.parent.color;
        n.parent.color = BLACK;
        if (nodeIsLeftChild)
        {
            sibling.right.color = BLACK;
            rotateLeft(n.parent);
        }
        else
        {
            sibling.left.color = BLACK;
            rotateRight(n.parent);
        }
    }


}







