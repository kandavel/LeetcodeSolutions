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
    public boolean isMirror(TreeNode a, TreeNode b) {
        if (a == null)
            return (b == null);
        
        if (b == null)
            return (a == null);
        
        if (a.val != b.val)
            return false;
        
        boolean leftRightChildrenMirror = isMirror(a.left, b.right);
        boolean rightLeftChildrenMirror = isMirror(a.right, b.left);
        
        return leftRightChildrenMirror & rightLeftChildrenMirror;
    }
    
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return false;
        
        return isMirror(root.left, root.right);
        
    }
}