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

    public TreeNode sortedArrayToBSTUtil(int []nums, int l, int r) {
        if (l > r)
        return null;

        int m = l + (r-l)/2;
        
        TreeNode leftSubTree = sortedArrayToBSTUtil(nums, l, m - 1);
        TreeNode rightSubTree = sortedArrayToBSTUtil(nums, m + 1, r);

        TreeNode rootNode = new TreeNode(nums[m], leftSubTree, rightSubTree);
        return rootNode;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {

        int l = 0, r = nums.length - 1;
        return sortedArrayToBSTUtil(nums, l, r);
    }
}