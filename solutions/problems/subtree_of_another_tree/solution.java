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

    private boolean isEqual(TreeNode A, TreeNode B) {

        if (A == null && B != null)
        return false;

        if (A != null && B == null)
        return false;

        if (A == null && B == null)
        return true;

        if (A.val != B.val)
        return false;
        
        return isEqual(A.left, B.left) & isEqual(A.right, B.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        if (subRoot == null)
        return true;

        if (root == null && subRoot != null)
        return false;

        boolean subtreeInclRoot = (root.val == subRoot.val) && isEqual(root, subRoot);

        if (subtreeInclRoot)
        return true;

        boolean SubtreeLeft = isSubtree(root.left, subRoot);
        boolean SubtreeRight = isSubtree(root.right, subRoot);

        return (SubtreeLeft || SubtreeRight);
    }
}