import sys
class TreeNode(object):

     def __init__(self, val=0, left=None, right=None):

         self.val = val

         self.left = left

         self.right = right
    
    def isValidBST(self, root): 
     #If left and right aren't there
        if root.left is None and root.right is None:
            return True
        def check(root, upper, lower):
            if root is None:
                return True
            if root.val <= lower or root.val >= upper:
                return False
            else:
             return check(root.left, root.val, lower) and check(root.right, upper, root.val)
        return check(root, sys.maxsize, -sys.maxsize-1)



