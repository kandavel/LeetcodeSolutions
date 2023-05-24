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

    public Integer findHeight(TreeNode root)
    {
        if (root == null)
        return 0;

        return 1 + Math.max(findHeight(root.left), findHeight(root.right));
    }

    public void levelOrderBottomUtil(TreeNode root, int heightFromBottom, List<List<Integer>> levelOrderBottomList) {

        if (root == null || heightFromBottom < 0)
        return;

        List<Integer> levelOrderBottomListAtHeightFromBottom = levelOrderBottomList.get(heightFromBottom-1);
        levelOrderBottomListAtHeightFromBottom.add(root.val);

        levelOrderBottomUtil(root.left, heightFromBottom - 1, levelOrderBottomList);
        levelOrderBottomUtil(root.right, heightFromBottom - 1, levelOrderBottomList);
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        int heightFromBottom = findHeight(root);
        List<List<Integer>> levelOrderBottom = new ArrayList<>();

        for (int i = 0; i < heightFromBottom; i++)
        levelOrderBottom.add(new ArrayList<>());

        levelOrderBottomUtil(root, heightFromBottom, levelOrderBottom);

        return levelOrderBottom;
    }
}