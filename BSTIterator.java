// Time Complexity : O(1) amortized as we are always popping from the stack.
// Space Complexity : O(H) where H is the max height of the BST.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Not really

import java.util.*;

class BSTIterator {

    Stack<TreeNode> currNodes;
    public BSTIterator(TreeNode root) {
        currNodes = new Stack<>();
        updateStack(root);
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode toReturn = currNodes.pop();
        
        if(toReturn.right != null) {
            updateStack(toReturn.right);
        }
        
        return toReturn.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !currNodes.isEmpty();
    }
    
    private void updateStack(TreeNode node) {
        if(node == null) {
            return;
        }
        
        TreeNode temp = node.left;
        while(node != null) {
            currNodes.push(node);
            
            node = temp;
            if(temp != null) {
                temp = temp.left;
            }
        }
    }

    /**
  Definition for a binary tree node.
  */
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
  }
}