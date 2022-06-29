package org.example.algorithm.class07;

public class Code02_HasPathSum {
    public static boolean hasPathSum = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        hasPathSum = false;
        process(root, 0, targetSum);
        return hasPathSum;
    }

    public void process(TreeNode root, int preSum, int targetSum) {
        if (root.left == null && root.right == null) {
            if (preSum + root.val == targetSum) {
                hasPathSum = true;
            }
            return;
        }
        preSum = preSum + root.val;
        if (root.left != null) {
            process(root.left, preSum, targetSum);
        }
        if (root.right != null) {
            process(root.right, preSum, targetSum);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}