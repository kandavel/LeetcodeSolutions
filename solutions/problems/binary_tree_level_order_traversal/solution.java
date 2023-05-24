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

    public void levelOrderUtil(TreeNode root, int h, List<List<Integer>> levelOrder) {
        
        if (root == null)
        return;

        if (levelOrder.isEmpty() || levelOrder.size() < h)
            levelOrder.add(new ArrayList<>());
            
        List<Integer> levelOrderAtH = levelOrder.get(h-1);
        levelOrderAtH.add(root.val);

        levelOrderUtil(root.left, h + 1, levelOrder);
        levelOrderUtil(root.right, h + 1, levelOrder);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        int h = 1;
        List<List<Integer>> levelOrder = new ArrayList<>();

        levelOrderUtil(root, h, levelOrder);

        return levelOrder;
    }
}