/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidWithRange(TreeNode root, long l, long u) {
        if (root == null)
            return true;
        
        if (root.val < u && root.val > l)
            return isValidWithRange(root.left, l, root.val) && 
            isValidWithRange(root.right, root.val, u) ;
        return false;
    }
    
    public boolean isValidBST(TreeNode root) {
        long l = (long) Integer.MIN_VALUE - 1l;
        long r = (long) Integer.MAX_VALUE + 1l;
        
        return isValidWithRange(root, l, r);
    }
}