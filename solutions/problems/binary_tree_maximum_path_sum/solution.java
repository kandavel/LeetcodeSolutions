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
    class PathCombinations {
        int rooted;
        int ending;

        public PathCombinations(int rooted, int ending) {
            this.rooted = rooted;
            this.ending = ending;
        }
    }

    public PathCombinations maxPathCombinations(TreeNode root) {
        if (root == null)
        {
            return new PathCombinations(
                Integer.MIN_VALUE, 
                Integer.MIN_VALUE);
        }

        PathCombinations leftST = maxPathCombinations(root.left);
        PathCombinations rightST = maxPathCombinations(root.right);

        int maxPathEndingAtRoot = root.val + Math.max(
            Math.max(0, leftST.ending), 
            Math.max(0, rightST.ending));

        int maxPathRootedAtRootSubtrees =  Math.max(
            leftST.rooted, rightST.rooted);

        int maxPathRootedAtRoot = root.val + 
        Math.max(0, leftST.ending) + 
        Math.max(0, rightST.ending);

        // System.out.println(root.val + ", " + maxPathRootedAtRoot);

        int maxPathRoot = Math.max(
            maxPathRootedAtRoot, maxPathRootedAtRootSubtrees);

        return new PathCombinations(maxPathRoot, maxPathEndingAtRoot);
    }

    public int maxPathSum(TreeNode root) {
        if (root == null)
        return 0;

        PathCombinations pathCombinations = maxPathCombinations(root);

        return Math.max(
            pathCombinations.rooted, pathCombinations.ending);
    }
}