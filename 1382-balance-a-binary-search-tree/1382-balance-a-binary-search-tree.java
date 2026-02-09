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

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> ll = new ArrayList<>();
        inorderT(root, ll);
        return createTree(ll, 0, ll.size() - 1);
    }

    private void inorderT(TreeNode root, List<Integer> ll) {
        if (root == null) {
            return;
        } 
        inorderT(root.left, ll);
        ll.add(root.val);
        inorderT(root.right, ll);
    }

    private TreeNode createTree(List<Integer> ll,int start,int end) {
        if (start > end) {
            return null;
        } 
        int mid = start + (end - start) / 2;
        TreeNode lt = createTree(ll, start, mid - 1);
        TreeNode rt = createTree(ll, mid + 1, end);
        TreeNode node = new TreeNode(ll.get(mid),lt,rt);
        return node;
    }
}