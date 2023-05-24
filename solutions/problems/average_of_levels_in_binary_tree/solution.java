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

    public void averageOfLevelsUtil(TreeNode root, int level, List<Double> avgValuesAtLevel, List<Integer> nNodesAtLevel) {

        if (root == null)
        return;

        Double avgSoFar = 0.0; Integer nNodes = 1;
        if (avgValuesAtLevel.isEmpty() || avgValuesAtLevel.size() < level)
        {
            avgValuesAtLevel.add(1.0*root.val);
            nNodesAtLevel.add(1);
        }
        else
        {
            avgSoFar = avgValuesAtLevel.get(level - 1);
            nNodes = nNodesAtLevel.get(level - 1);

            avgSoFar = (avgSoFar*nNodes + 1.0* root.val)/ (nNodes + 1);
            nNodes = nNodes + 1;

            avgValuesAtLevel.set(level - 1, avgSoFar);
            nNodesAtLevel.set(level - 1, nNodes);
        }

        averageOfLevelsUtil(root.left, level + 1, avgValuesAtLevel, nNodesAtLevel);
        averageOfLevelsUtil(root.right, level + 1, avgValuesAtLevel, nNodesAtLevel);
    }

    public List<Double> averageOfLevels(TreeNode root) {
        
        List<Double> avgValuesAtLevel = new ArrayList<>();
        List<Integer> nNodesAtLevel = new ArrayList<>();

        int level = 1;
        averageOfLevelsUtil(root, level, avgValuesAtLevel, nNodesAtLevel);

        return avgValuesAtLevel;
    }
}