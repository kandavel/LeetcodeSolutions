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
    
    
    public void maxLevelSumUtil(TreeNode root, int level, List<Integer> q) {
        if (root == null)
        return;

        if (q.size() < level)
            q.add(root.val);
        else 
            q.set(level-1, q.get(level-1) + root.val);

        maxLevelSumUtil(root.left, level + 1, q);
        maxLevelSumUtil(root.right, level + 1, q);


    }
    public int maxLevelSum(TreeNode root) {
        List<Integer> q = new LinkedList<>();
        maxLevelSumUtil(root, 1, q);
        
        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 1;

        for (int i = 0; i < q.size(); i++) {
            if (maxSum < q.get(i)){
                maxSum = q.get(i);
                maxLevel = i + 1;
            }
        }
        return maxLevel;    
    }
}