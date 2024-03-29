from collections import deque

class TreeNode(object):

     def __init__(self, val=0, left=None, right=None):

         self.val = val

         self.left = left

         self.right = right

def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
    if root is None:
        return []
    queue = deque([root])
    finalList = []
    while queue:
        size = len(queue)
        levelList = []
        for i in range(size):
            curr = queue.popleft()
            levelList.append(curr.val)
            if curr.left:
                queue.append(curr.left)
            if curr.right:
                queue.append(curr.right)
        finalList.append(levelList)
    return finalList

                    
                
