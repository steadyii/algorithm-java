package com.steady.leetcode.d6_tree;

/**
 * 二叉树节点
 */
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