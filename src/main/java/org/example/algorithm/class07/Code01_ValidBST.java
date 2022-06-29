package org.example.algorithm.class07;

public class Code01_ValidBST {

    public static void main(String[] args) {
        Code01_ValidBST a=new Code01_ValidBST();
        //TreeNode root=new TreeNode()
        //a.isValidBST(root)
    }
    public boolean isValidBST(TreeNode root) {
        return process(root).isBST;
    }

    public static class Info {
        int max;
        int min;
        boolean isBST;

        Info(int max, int min, boolean isBST) {
            this.max = max;
            this.min = min;
            this.isBST = isBST;
        }
    }

    public static Info process(TreeNode root) {
        if (root == null) {
            return null;
        }
        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);
        int max = root.val;
        int min = root.val;
        boolean isBST = true;

        if (leftInfo != null) {
            max = Math.max(max, leftInfo.max);
            min = Math.min(min, leftInfo.min);
        }
        if (rightInfo != null) {
            max = Math.max(max, rightInfo.max);
            min = Math.min(min, rightInfo.min);
        }

        if (leftInfo != null && !leftInfo.isBST) {
            isBST = false;
        }
        if (rightInfo != null && !rightInfo.isBST) {
            isBST = false;
        }

        boolean isLeftLessRoot = leftInfo == null ? true : leftInfo.max < root.val;
        boolean isRightMoreRoot = rightInfo == null ? true : rightInfo.min > root.val;

        isBST = isLeftLessRoot && isRightMoreRoot;

        return new Info(max, min, isBST);

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