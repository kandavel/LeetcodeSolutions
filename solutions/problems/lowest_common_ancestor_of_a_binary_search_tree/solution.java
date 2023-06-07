/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if (root == null)
        return null;

        TreeNode min = (p.val < q.val? p: q);
        TreeNode max = (p.val < q.val? q: p);

        if (root.val < min.val)
        return lowestCommonAncestor(root.right, p, q);
        else if (root.val > max.val)
        return lowestCommonAncestor(root.left, p, q);
        else if (root.val == min.val) 
        return root;
        else if (root.val == max.val)
        return root;
        else 
        return root;
    }
}